package chapter_5.c_5_1_workingWithDatesAndTimes.javaCode;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UsingDuration {
	public static void main(String[] args) {
		Duration duration = Duration.ofHours(6);
		LocalDate date = LocalDate.of(2023, 9, 8);
		// date.plus(duration); // throws exception
		
		LocalTime time = LocalTime.of(23, 20);
		System.out.println(time.plus(duration)); // 05:20
		
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println(dateTime.plus(duration));
		
	}
}
