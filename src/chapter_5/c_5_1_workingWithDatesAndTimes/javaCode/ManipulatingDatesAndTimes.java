package chapter_5.c_5_1_workingWithDatesAndTimes.javaCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class ManipulatingDatesAndTimes {
	
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2023, Month.SEPTEMBER, 3);
		date1 = date1.plusDays(2);
		System.out.println(date1); // 2023-09-05
		date1 = date1.plusWeeks(1);
		System.out.println(date1); // 2023-09-12
		date1 = date1.plusMonths(1);
		System.out.println(date1); // 2023-10-12
		date1 = date1.plusYears(5);
		System.out.println(date1); // 2028-10-12
		
		LocalDate date2 = LocalDate.of(2020, 1, 20);
		LocalTime time2 = LocalTime.of(5, 15);
		LocalDateTime dateTime2 = LocalDateTime.of(date2, time2);
		System.out.println(dateTime2); // 2020-01-20T05:15
		dateTime2 = dateTime2.minusDays(1);
		System.out.println(dateTime2); // 2020-01-19T05:15
		dateTime2 = dateTime2.minusHours(10); // 2020-01-18T19:15
		System.out.println(dateTime2);
		dateTime2 = dateTime2.minusSeconds(30);
		System.out.println(dateTime2); // 2020-01-18T19:14:30
		
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(5, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time)
				.minusDays(1).minusHours(10).minusSeconds(30);
		System.out.println(dateTime); // 2020-01-18T19:14:30
		
		System.out.println(LocalDate.of(2020, Month.JANUARY, 20));
		
		
	}

}
