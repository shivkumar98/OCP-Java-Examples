package chapter_5.c_5_1_workingWithDatesAndTimes.javaCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
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
		// dateTime.toEpochDay() // COMPILER ERROR
		
		Period anually = Period.ofYears(1);
		System.out.println(anually); // P1Y
		Period quartly = Period.ofMonths(3);
		System.out.println(quartly); // P3M
		Period weekly = Period.ofWeeks(1);
		System.out.println(weekly); // P7D
		Period everyOtherDay = Period.ofDays(2);
		System.out.println(everyOtherDay); // P2D
		
		Period wrong = Period.ofYears(1).ofDays(1);
		System.out.println(wrong); // P1D
		
		Period correct = Period.of(1, 0, 1);
		System.out.println(correct); // P1Y1D

		switchToys(start, end, Period.ofMonths(1));
		
		Period period = Period.of(0, 44, 60);
		System.out.println(period);
	}

	private static void switchToys(LocalDate start, LocalDate end, Period period) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) {
			System.out.println("give new toy: "+upTo);
			upTo =upTo.plus(period);
		}
	}

	private static void switchToys(LocalDate start, LocalDate end) {
		LocalDate upTo = start;
		while (upTo.isBefore(end)) {
			System.out.println("give new toy: "+upTo);
			upTo = upTo.plusMonths(1);
		}
	}

}
