package chapter_5.c_5_1_workingWithDatesAndTimes.java;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class WorkingWithDurations {
	public static void main(String[] args) {
		Duration nano = Duration.ofNanos(1);
		System.out.println(nano); // PT0.000000001S
		Duration milli = Duration.ofMillis(-1);
		System.out.println(milli); // PT-0.001S
		Duration second = Duration.ofSeconds(1);
		System.out.println(second); // PT1S
		Duration minute = Duration.ofMinutes(1);
		System.out.println(minute); // PT1M
		Duration hourly = Duration.ofHours(1);
		System.out.println(hourly); // PT1H
		// suppose we want one second, minus a nanoSecond
		System.out.println(Duration.ofSeconds(1, -1)); // PT0.000000001S
		
		Duration nanos = Duration.of(1, ChronoUnit.NANOS);
		System.out.println(nanos);
		
	}
}
