package com.git.webapi.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class WebService {
	private static String path = "C:\\Users\\Admin\\Downloads\\netflix_titles.csv";
	
	public List<String> getAllTVShows(String count, String start, String end) throws ParseException, IOException{
		List<String> shows = new ArrayList();
		Date startDate=null;
		Date endDate = null;
		
		
		if(!start.contentEquals("") && !end.contentEquals("")) {
			startDate = parseDate(start);
			endDate = parseDate(end);
		}
		BufferedReader br = new BufferedReader(new FileReader(path));
		String row =  "" ;
		int n = Integer.parseInt(count);
		while((row = br.readLine()) != null &&  n>0) {
			String[] values = row.split(",");
			if(values[1].contentEquals("TV Show")  && startDate != null && endDate != null ){
				Date actualDate = getDate(row);
				if( actualDate.after(startDate) && actualDate.before(endDate)) {
					shows.add(row);
					n--;
				}
			}	else if(values[1].contentEquals("TV Show") ){
				System.out.println("TV Show");
				shows.add(row);
				n--;
			}
		}				
		
		return shows;
		
	}
	
	
	public List<String> getAllHorrorMovies(String type, String count, String start, String end) throws ParseException, IOException{
		List<String> shows = new ArrayList();
		Date startDate=null;
		Date endDate = null;
		
		
			if(!start.contentEquals("") && !end.contentEquals("")) {
				
				startDate = parseDate(start);
				endDate = parseDate(end);
				
			}
		BufferedReader br = new BufferedReader(new FileReader(path));
		String row =  "" ;
		int n = Integer.parseInt(count);
		System.out.println(type);
		while((row = br.readLine()) != null &&  n>0) {
			if(row.contains(type) && startDate != null && endDate != null) {
				Date actualDate = getDate(row);
				if( actualDate.after(startDate) && actualDate.before(endDate)) {
					shows.add(row);
					n--;
				}
			} else if(row.contains(type) ) {
					//System.out.println(row);
					shows.add(row);
					n--;
			}
			
		}		
		
		System.out.println(shows.size());
		return shows;
		
	}
	
	public List<String> getAllByCountry(String country, String count, String start, String end) throws ParseException, IOException{
		List<String> shows = new ArrayList();
		Date startDate=null;
		Date endDate = null;
		
		
			if(!start.contentEquals("") && !end.contentEquals("")) {
				startDate = parseDate(start);
				endDate = parseDate(end);
			}
		BufferedReader br = new BufferedReader(new FileReader(path));
		String row =  "" ;
		int n = Integer.parseInt(count);
		while((row = br.readLine()) != null && n>0) {
			if(row.contains(country) && startDate != null && endDate != null) {
				Date actualDate = getDate(row);
				if( actualDate.after(startDate) && actualDate.before(endDate)) {
					shows.add(row);
					n--;
				}
			} else if(row.contains(country) ) {
					//System.out.println(row);
					shows.add(row);
					n--;
			}
		}			
		
		return shows;
		
	}
	
	
	public static Date parseDate(String date) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(date);
	}
	
	public static Date getDate(String dataRow) throws ParseException {
		String dateStr = "";
		  Pattern p = Pattern.compile("[A-Za-z]{3,10} [0-9]{1,2}, [0-9]{4}");   // the pattern to search for
		    Matcher m = p.matcher(dataRow);
		    if (m.find())
		    {
		    	dateStr = m.group(0);
		       
		    }
		    String[] month  = dateStr.split(" ");
		    String mon = convert(month[0]);
		    
		    String dateString = month[1].split(",")[0] + "/" + mon + "/"+ month[2];
		    Date date  =new SimpleDateFormat("dd/MM/yyyy").parse(dateString);  
		    return date;
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
