package chapter_5.revision_notes.javaCode;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AccountingForDaylightSavingsTime {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2016, 3, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(zonedDateTime); 
		// 2016-03-13T01:30-05:00[US/Eastern]
		System.out.println(zonedDateTime.plusHours(1));
		// 2016-03-13T03:30-04:00[US/Eastern]

		// trying to make a time which is not possible:
		System.out.println(ZonedDateTime.of(date, time.plusHours(1), zone));
		// 2016-03-13T03:30-04:00[US/Eastern]
		// Java automatically rolls over
		
		LocalDate dateWhenHoursMoveBack = LocalDate.of(2016, Month.NOVEMBER, 6);
		ZonedDateTime zonedDateTime2 = ZonedDateTime.of(dateWhenHoursMoveBack, time, zone);
		System.out.println(zonedDateTime2); // 2016-11-06T01:30-04:00[US/Eastern]
		System.out.println(zonedDateTime2.plusHours(1)); // 2016-11-06-01:30-05:00[US/Eastern]
		System.out.println(ZonedDateTime.of(dateWhenHoursMoveBack, time, zone));
	}
}
