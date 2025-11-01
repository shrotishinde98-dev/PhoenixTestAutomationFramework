package com.api.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {
	
  private DateTimeUtil() {
	  
	  
  }
  
  public static String getTimewithDaysAgo(int Days) {
	return Instant.now().minus(Days,ChronoUnit.DAYS).toString();
  }
}
