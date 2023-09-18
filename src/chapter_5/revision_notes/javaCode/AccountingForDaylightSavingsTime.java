package chapter_5.revision_notes.javaCode;

import java.time.LocalDate;
import java.time.LocalTime;
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

	}
}
