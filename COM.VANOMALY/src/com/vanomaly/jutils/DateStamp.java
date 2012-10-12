package com.vanomaly.jutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateStamp {
	public static String getDateStamp(String format, String timeZone) {
		
		String dateStamp = "";
		
		DateFormat df = new SimpleDateFormat(format);  
	    df.setTimeZone(TimeZone.getTimeZone(timeZone.toUpperCase()));  
	    dateStamp = df.format(new Date()); 
	    
		return dateStamp;
	}
}