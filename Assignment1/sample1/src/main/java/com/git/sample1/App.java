package com.git.sample1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Assignment 1
public class App {
	
	private static String path = "C:\\Users\\Admin\\Downloads\\netflix_titles.csv";
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Hello, World!");
		long startTime = System.nanoTime();
		try {
			Scanner sc=new Scanner(System.in);  
			
			//get date range as string and parse tat to date
			System.out.println("Enter start date in DD/MM/YYYY ");  
			String start= sc.next(); 
			System.out.println("Enter end date in DD/MM/YYYY ");  
			String end= sc.next(); 
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate=null;
			Date endDate = null;
			
			startDate = dateFormat.parse(start);
			endDate = dateFormat.parse(end);
			
				
			System.out.println("Enter option for which you need to list entries");
			System.out.println(" (1.Type:TV Show / 2.listed_in : horror movies / 3.country: India) ");
			int option = sc.nextInt();
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			switch(option) {
			
			case 1 :
			
			System.out.println();
			System.out.println("Enter first  n records for tv show ");  
			int n= sc.nextInt(); 
			String row =  "" ;
		
			
			while((row = br.readLine()) != null &&  n>0) {
				String[] values = row.split(",");
				if(values[1].contentEquals("TV Show") ){
					Date actualDate = getDate(row);
					if( actualDate.after(startDate) && actualDate.before(endDate)) {
						System.out.println(row);
						n--;
					}
				}
				
			}
			break;
			
			case 2:
			System.out.println();
			System.out.println("Enter first  n records to list horror movies ");  
			n= sc.nextInt();
			
			while((row = br.readLine()) != null &&  n>0) {
				if(row.contains("Horror Movies") ) {
					Date actualDate = getDate(row);
					if(actualDate.after(startDate) && actualDate.before(endDate)) {
						System.out.println(row);
						n--;
					}
				}
				
			}
			break;
			
			case 3:
			System.out.println();
			System.out.println("Enter first  n records to list Indian movies ");  
			n= sc.nextInt();
			
			while((row = br.readLine()) != null &&  n>0) {
				if(row.contains("India") ) {
					Date actualDate = getDate(row);
					if(actualDate.after(startDate) && actualDate.before(endDate)) {
						System.out.println(row);
						n--;
					}
				}
					
			}
			break;
			}
			
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println();
			System.out.println("Total execution time in ns = " +totalTime);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
		    e.printStackTrace();
		}catch (NullPointerException e) {
		    e.printStackTrace();
		}
		
	}

}

