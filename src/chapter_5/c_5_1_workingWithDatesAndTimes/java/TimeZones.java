package chapter_5.c_5_1_workingWithDatesAndTimes.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZones {
	LocalDate date = LocalDate.of(2023, 3, 9);
	LocalTime time = LocalTime.of(11, 58);
	LocalDateTime dateTime = LocalDateTime.of(date, time);
	ZoneId zone = ZoneId.of("US/Eastern");
	ZonedDateTime zone1 = 
			ZonedDateTime.of(date, time, zone);
	ZonedDateTime zone2 = 
			ZonedDateTime.of(dateTime, zone);
	ZonedDateTime zone3 =
			ZonedDateTime.of(2023,9,3,12,1,0,0, zone);
}
