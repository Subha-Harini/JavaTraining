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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.git.webapi.service.WebService;

@RestController
public class WebController {
	
	@Autowired
	public WebService webService;
	
	
	
	@GetMapping("/tvshows")
	public ResponseEntity getAllTVShows(@RequestParam(value = "count" , defaultValue= "5") String count, @RequestParam(value = "movieType" , defaultValue= "") String type, @RequestParam(value = "country" , defaultValue= "") String country, @RequestParam(value = "startDate" , defaultValue= "") String startDate, @RequestParam(value = "endDate" , defaultValue= "") String endDate) {
		 List<String> result = null;
		 HttpHeaders headers = new HttpHeaders();
		long startTime = System.nanoTime();
		System.out.println(count + type + country + startDate + endDate);
		 try {
		 if (!type.contentEquals("")) {
			
				result =  webService.getAllHorrorMovies(type,count, startDate, endDate);
			
		}else if (!country.contentEquals("")) {
			 result = webService.getAllByCountry(country, count, startDate, endDate);
		}else {
			 result = webService.getAllTVShows(count, startDate, endDate);
		}
		 
		 long endTime   = System.nanoTime();
		 long totalTime = endTime - startTime;
		 
		 headers.add("X-TIME-TO-EXECUTE", totalTime+"");
		 } catch (ParseException e) {
				e.printStackTrace();
				return new ResponseEntity<>(
						 e, headers, HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<>(
						 e, headers, HttpStatus.BAD_REQUEST);
		}
		 return new ResponseEntity<>(
				 result, headers, HttpStatus.OK);
	}
}
