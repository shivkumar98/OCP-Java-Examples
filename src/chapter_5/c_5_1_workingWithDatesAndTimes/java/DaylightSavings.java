package chapter_5.c_5_1_workingWithDatesAndTimes.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DaylightSavings {
	
	public static void main(String[] args) {
		// 13/03/2026 the clocks move forward
		// clocks jump from 2am to 3am => there is not 2.30am on that day!
		LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zoneId = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime = ZonedDateTime.of(date, time, zoneId);
		System.out.println(dateTime); // 2016-03-13T03:30-5:00[US/Eastern]
		System.out.println(dateTime.plusHours(1)); // 2016-03-13T03:30-04:00[US/Eastern]
		// 2am does not exist:
		ZonedDateTime dateTimeWhichDoesNotExist =
				ZonedDateTime.of(date, LocalTime.of(2, 0), zoneId);
		System.out.println(dateTimeWhichDoesNotExist + "!"); // 2016-03-13T03:00-04:00[US/Eastern]!
		
		
		//2016-11-6 the time at 2am goes back to 1am
		LocalDate date2 = LocalDate.of(2016,  Month.NOVEMBER, 6);
		LocalTime time2 = LocalTime.of(1, 30);
		ZonedDateTime zonedDateTime2 = ZonedDateTime.of(date2, time2, zoneId);
		System.out.println(zonedDateTime2); // 2016-11-06T01:30-4:00[US/Eastern]
		System.out.println(zonedDateTime2.plusMinutes(30)); // 2016-11-06T01:00-5.00[US/Eastern]
		System.out.println(zonedDateTime2.plusHours(1)); // 2016-11-06T:1:30-5:00[US/Eastern]
		
		
	}

}
