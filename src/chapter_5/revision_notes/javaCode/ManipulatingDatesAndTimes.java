package chapter_5.revision_notes.javaCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class ManipulatingDatesAndTimes {
	
	public static void main(String[] args) {
		// LocalDate invalidDate = LocalDate.of(2014, 2, 29);
		// THROWS EXCEPTION
		LocalDate date1 = LocalDate.of(2014, 1, 29);
		LocalDate notALeapDay = date1.plusMonths(1);
		System.out.println(notALeapDay); // 2014-02-28
		
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(5, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		// date.plusHours(1); // COMPILER ERROR
		time.plusHours(1);
		dateTime.plusHours(1);
		date.plusDays(1);
		dateTime.plusDays(1);
		// time.plusDays(1); // COMPILER ERROR
		
		dateTime = LocalDateTime.of(date, time)
				.minusDays(1)
				.minusHours(10)
				.minusSeconds(30);
		System.out.println(dateTime);
	}

}
