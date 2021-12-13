package com.git.webapi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.git.webapi.entity.Show;
import com.git.webapi.repository.ShowRepository;

@Service
public class WebServiceJPA {
	
	@Autowired
	private ShowRepository showRepository;
	
	public List<Show> getAllTVShows(int count) throws  IOException{
		Pageable pageable = PageRequest.of(0, count);
		return showRepository.findByType("TV Show", pageable);
	}
	
	
	public List<Show> getAllHorrorMovies(String movieType) throws IOException{
		return showRepository.findAllHorrorMovies(movieType);
		
	}
	
	public List<Show> getAllByCountry(String country) throws  IOException{
		return showRepository.findAllByCountry(country);	
	}
	
	public List<Show> getAllTVShows( String start, String end) throws ParseException, IOException{
		List<Show> shows = new ArrayList();
		List<Show> result = new ArrayList();
		Date startDate=null;
		Date endDate = null;
		
		
		if(!start.contentEquals("") && !end.contentEquals("")) {
			startDate = parseDate(start);
			endDate = parseDate(end);
		}
		
		shows = showRepository.findByType("TV Show");
		for(Show show : shows) {
			String date = show.getDateAdded();
			try {
			String[] month  = date.split(" ");
			String dateString = "";
			//dates starts with " "
			if(month[0].contentEquals("")) {
				 String mon = convert(month[1]);
				  dateString = month[2].split(",")[0] + "/" + mon + "/"+ month[3];
			}
			//dates starts with month
			else {
				String mon = convert(month[0]);
				 dateString = month[1].split(",")[0] + "/" + mon + "/"+ month[2];
			}
			 Date actualDate  =new SimpleDateFormat("dd/MM/yyyy").parse(dateString);  
			 if( actualDate != null && actualDate.after(startDate) && actualDate.before(endDate)) {
					result.add(show);
			}
			}catch (java.lang.ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}
		return result;
		
	}
	
	public static Date parseDate(String date) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(date);
	}
	
	public static String convert(String mon) {
		  switch(mon) {
		  case "January": return "01";
		  case "February": return "02";
		  case "March" : return "03";
		  case "April" : return "04";
		  case "May": return "05";
		  case "June" : return "06";
		  case "July" : return "07";
		  case "August" : return "08";
		  case "September" : return "09";
		  case "October" : return "10";
		  case "November" : return "11";
		  case "December" : return "12";
		  }
		  return null;
	  }
}
