package com.firstHelpFinacial.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstHelpFinancialUtil {

	public FirstHelpFinancialUtil () {
		
	}
	
	public String dateFormatterFromDate(String date) throws Exception {
		
		try {
			String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String formattedDate = simpleDateFormat.format(new Date(date));
			return formattedDate;
			
		}
		catch(Exception e) {
			throw new Exception("Error in parsing the date entered - " + e);
		}	
	}
	
	public String dateFormatterToDate(String date) throws Exception {
		
		try {
			String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date nextDay = new Date(date);
			nextDay.setDate(nextDay.getDate()+1);
			String formattedDate = simpleDateFormat.format(nextDay);
			return formattedDate;
			
		}
		catch(Exception e) {
			throw new Exception("Error in parsing the date entered - " + e);
		}	
	}
	
	public String getTomorrowsDate() throws Exception {
		try {
			Date tomorrow = new Date();
			tomorrow.setDate(tomorrow.getDate()+1);
			tomorrow.setHours(0);
			tomorrow.setMinutes(0);
			tomorrow.setSeconds(0);
			String todayAsString = tomorrow.toString();
			return dateFormatterToDate(todayAsString);
		}
		catch(Exception e) {
			throw new Exception("Error in parsing the date entered - " + e);
		}
	}
	
	public String getTodaysDate() throws Exception {
		try {
			Date today = new Date();
			today.setHours(0);
			today.setMinutes(0);
			today.setSeconds(0);
			String todayAsString = today.toString();
			return dateFormatterToDate(todayAsString);
		}
		catch(Exception e) {
			throw new Exception("Error in parsing the date entered - " + e);
		}
	}
	
	
}
