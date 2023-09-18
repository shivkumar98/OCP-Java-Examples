package chapter_5.revision_notes.javaCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class WorkingWithPeriods {
	public static void main(String[] args) {
		Period p = Period.of(1, 2, 3);
		Period p1 = Period.ofYears(1).ofMonths(2).ofDays(1);
		System.out.println(p1); // P1D
		Period p4 = Period.ofWeeks(1);
		
		LocalDate date = LocalDate.of(2015, 1, 20);
		LocalTime time = LocalTime.of(6, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		dateTime.plus(Period.ofDays(1));
		date.plus(Period.ofDays(1));
		// time.plus(Period.ofDays(1)); // THROWS UnsupportedTemportalTypeException 
	}
}
