package chapter_5.c_5_1_workingWithDatesAndTimes.javaCode;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class UsingChronoUnit {
	public static void main(String[] args) {
		LocalTime one = LocalTime.of(5,15);
		LocalTime two = LocalTime.of(6,30);
		System.out.println(ChronoUnit.HOURS.between(one, two)); // 1 - 15 mins is truncated!
		System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
		
	}
}
