package chapter_5.c_5_1_workingWithDatesAndTimes.javaCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class WorkingWithPeriods {

	
	public static void main(String[] args) {
		LocalDate start = LocalDate.of(2023, Month.SEPTEMBER, 1);
		LocalDate end = LocalDate.of(2023, Month.NOVEMBER, 30);
		switchToys(start, end);
		// give new toy: 2023-09-01
		// give new toy: 2023-10-01
		// give new toy: 2023-11-01
		LocalDate date = LocalDate.of(2023,1,1);
		System.out.println(date.toEpochDay()); // 19358
		LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.of(0, 0));
		System.out.println(dateTime.toEpochSecond(ZoneOffset.UTC)); // 1672531200
		
		
	}

	private static void switchToys(LocalDate start, LocalDate end) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) {
			System.out.println("give new toy: "+upTo);
			upTo = upTo.plusMonths(1);
		}
	}

}
