package com.git.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.git.webapi.entity.Show;
import com.git.webapi.service.WebServiceCSV;
import com.git.webapi.service.WebServiceJPA;

@RestController
public class WebController {
	
	@Autowired
	private WebServiceCSV webService;
	
	@Autowired
	private WebServiceJPA webServiceJPA;
	
	 @RequestMapping(value = "/tvshows",params = {"count","fetchFrom"}, method = RequestMethod.GET)
	 ResponseEntity  getTVShows(@RequestParam (value = "count" , defaultValue= "") int count, @RequestParam (value = "fetchFrom" , defaultValue= "") String fetchFrom) {
		 long startTime = System.currentTimeMillis();
		 List<Show> result = null;
		 HttpHeaders headers = new HttpHeaders();
		 try {
			 if(fetchFrom.contentEquals("csv")) {
				 result = webService.getAllTVShows(count);
			 }else {
				 result =  webServiceJPA.getAllTVShows(count);
			 }
			 
		 }
		 catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<>(
						 "Input output exception", headers, HttpStatus.BAD_REQUEST);
		}
		 long endTime   = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
		 
		 headers.add("X-TIME-TO-EXECUTE", totalTime+"");
		 return new ResponseEntity<>(
				 result, headers, HttpStatus.OK);
	    }
	
	 
	 @RequestMapping(value = "/tvshows", params = {"movieType","fetchFrom"}, method = RequestMethod.GET)
	 ResponseEntity  getHorrorMovies(@RequestParam (value = "movieType" , defaultValue= "") String type, @RequestParam (value = "fetchFrom" , defaultValue= "") String fetchFrom) {
		 long startTime = System.currentTimeMillis();
		 List<Show> result = null;
		 HttpHeaders headers = new HttpHeaders();
		 try {
			 if(fetchFrom.contentEquals("csv")) {
				 result = webService.getAllHorrorMovies(type);
			 }else {
				 result = webServiceJPA.getAllHorrorMovies(type);
			 }
		 }
		 catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<>(
						 "Input output exception", headers, HttpStatus.BAD_REQUEST);
		} 
		 long endTime   = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
		 
		 headers.add("X-TIME-TO-EXECUTE", totalTime+"");  
		 
		 return new ResponseEntity<>(
				 result, headers, HttpStatus.OK);
	    }
	
	 
	 @RequestMapping(value = "/tvshows", params = {"country", "fetchFrom"}, method = RequestMethod.GET)
	 ResponseEntity  getByCountry(@RequestParam (value = "country" , defaultValue= "") String country, @RequestParam (value = "fetchFrom" , defaultValue= "") String fetchFrom) {
		 long startTime = System.currentTimeMillis();
		 List<Show> result = null;
		 HttpHeaders headers = new HttpHeaders();
		 try {
			
			 if(fetchFrom.contentEquals("csv")) {
				 result = webService.getAllByCountry(country);
			 }else {
				 result = webServiceJPA.getAllByCountry(country);
			 }
		 }
		 catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<>(
						 "Input output exception", headers, HttpStatus.BAD_REQUEST);
		}  
		 long endTime   = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
		 
		 headers.add("X-TIME-TO-EXECUTE", totalTime+"");
		 return new ResponseEntity<>(
				 result, headers, HttpStatus.OK);
	    }
	
	 
	 @RequestMapping(value = "/tvshows", params = {"startDate", "endDate", "fetchFrom"}, method = RequestMethod.GET)
	 ResponseEntity  getByDate(@RequestParam(value = "startDate" , defaultValue= "") String startDate, @RequestParam(value = "endDate" , defaultValue= "") String endDate,  @RequestParam (value = "fetchFrom" , defaultValue= "") String fetchFrom) {
		 long startTime = System.currentTimeMillis();
		 List<Show> result = null;
		 HttpHeaders headers = new HttpHeaders();
		 try {
			 
			
			 if(fetchFrom.contentEquals("csv")) {
				 result = webService.getAllTVShows(startDate, endDate);
			 }else {
				 result = webServiceJPA.getAllTVShows(startDate, endDate);
			 }
		 }
		 catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<>(
						 "Input output exception", headers, HttpStatus.BAD_REQUEST);
		} catch (ParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(
					 "Date parse error", headers, HttpStatus.BAD_REQUEST);
		} 
		 long endTime   = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
		 
		 headers.add("X-TIME-TO-EXECUTE", totalTime+"");
		 return new ResponseEntity<>(
				 result, headers, HttpStatus.OK);
	    }
	
	
	 /*
		@GetMapping("/tvshows")
		public ResponseEntity getAllTVShows(@RequestParam(value = "count" , defaultValue= "") String count, @RequestParam(value = "movieType" , defaultValue= "") String type, @RequestParam(value = "country" , defaultValue= "") String country, @RequestParam(value = "startDate" , defaultValue= "") String startDate, @RequestParam(value = "endDate" , defaultValue= "") String endDate) {
			 List<String> result = null;
			 HttpHeaders headers = new HttpHeaders();
			long startTime = System.nanoTime();
			System.out.println(count + type + country + startDate + endDate);
			 try {
			 if (!type.contentEquals("")) {
					result =  webService.getAllHorrorMovies(type, startDate, endDate);
			}else if (!country.contentEquals("")) {
				 result = webService.getAllByCountry(country, startDate, endDate);
			}else {
				if(count.contentEquals("")) {
					result = webService.getAllTVShows(startDate, endDate);
				}
				else{
					result = webService.getAllTVShows(count, startDate, endDate);
				}
			}
			 
			 long endTime   = System.nanoTime();
			 long totalTime = endTime - startTime;
			 
			 headers.add("X-TIME-TO-EXECUTE", totalTime+"");
			 } catch (ParseException e) {
					e.printStackTrace();
					return new ResponseEntity<>(
							 "Date parse error", headers, HttpStatus.BAD_REQUEST);
			} catch (IOException e) {
					e.printStackTrace();
					return new ResponseEntity<>(
							 "Input output exception", headers, HttpStatus.BAD_REQUEST);
			}
			 return new ResponseEntity<>(
					 result, headers, HttpStatus.OK);
		}*/
}
