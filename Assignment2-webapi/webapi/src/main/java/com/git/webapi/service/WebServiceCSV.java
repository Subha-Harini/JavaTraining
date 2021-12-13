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

import com.git.webapi.entity.Show;

@Service
public class WebServiceCSV {
	private static String path = "C:\\Users\\Admin\\Downloads\\netflix_titles.csv";
	
	public List<Show> getAllTVShows(int count) throws  IOException{
		List<Show> shows = new ArrayList();
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		String row =  "" ;
		while((row = br.readLine()) != null &&  count>0) {
			String[] values = row.split(",");
			 if(values[1].contentEquals("TV Show") ){
				Show show =  createShow(row); // pojo creation call
				shows.add(show);
				count--;
			}
		}				
		
		return shows;
		
	}
	
	public List<Show> getAllTVShows( String start, String end) throws ParseException, IOException{
		List<Show> shows = new ArrayList();
		Date startDate=null;
		Date endDate = null;
		
		
		if(!start.contentEquals("") && !end.contentEquals("")) {
			startDate = parseDate(start);
			endDate = parseDate(end);
		}
		BufferedReader br = new BufferedReader(new FileReader(path));
		String row =  "" ;
		while((row = br.readLine()) != null) {
			String[] values = row.split(",");
			try {
			if(values[1].contentEquals("TV Show")  && startDate != null && endDate != null ){
				Date actualDate = getDate(row);
				if( actualDate != null && actualDate.after(startDate) && actualDate.before(endDate)) {
					Show show =  createShow(row); // pojo creation call
					shows.add(show);
				}
			}	}catch (java.lang.ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}				
		
		return shows;
		
	}
	
	
	public List<Show> getAllHorrorMovies(String type) throws IOException{
		List<Show> shows = new ArrayList();
			
		BufferedReader br = new BufferedReader(new FileReader(path));
		String row =  "" ;
		while((row = br.readLine()) != null ) {
			if(row.contains(type) ) {
				Show show =  createShow(row); // pojo creation call
					shows.add(show);	
			}
		}		
		
		return shows;
		
	}
	
	public List<Show> getAllByCountry(String country) throws  IOException{
		List<Show> shows = new ArrayList();
	
		BufferedReader br = new BufferedReader(new FileReader(path));
		String row =  "" ;
		
		while((row = br.readLine()) != null ) {
			if(row.contains(country)  ) {
				Show show =  createShow(row); // pojo creation call
					shows.add(show);
					
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
				 String[] month  = dateStr.split(" ");
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
				 Date date  =new SimpleDateFormat("dd/MM/yyyy").parse(dateString);  
				 return date;
		    }
		   return null;
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
	
	
	public Show createShow(String row) {
		 String showId="", type="", title="", director="", cast="", country="", dateAdded="", releaseYear="", rating = "", duration ="", listedIn = "", description = "" ;
				int index = 1;
				boolean doubleQuotesBalanced = true;
				for(int i=0; i< row.length(); i++) {
					if(row.charAt(i) == ',' && doubleQuotesBalanced) {
						index++;
					}else if(row.charAt(i) == '\"') {
						doubleQuotesBalanced = !doubleQuotesBalanced;
					}
					else {
					
					switch (index) {
					case 1 : showId += row.charAt(i);
					break;
					case 2: type += row.charAt(i);
					break;
					case 3 : title+= row.charAt(i);
					break;
					case 4 : director+= row.charAt(i);
					break;
					case 5 : cast+= row.charAt(i);
					break;
					case 6 : country+= row.charAt(i);
					break;
					case 7 : dateAdded+= row.charAt(i);
					break;
					case 8 : releaseYear+= row.charAt(i);
					break;
					case 9 : rating+= row.charAt(i);
					break;
					case 10 : duration+= row.charAt(i);
					break;
					case 11 : listedIn+= row.charAt(i);
					break;
					case 12 : description+= row.charAt(i);
					break;
					}
					}
		
			
		}
				return new Show(showId, type, title, director, cast, country, dateAdded, Integer.parseInt(releaseYear), rating, duration, listedIn, description);
	}
	
}
