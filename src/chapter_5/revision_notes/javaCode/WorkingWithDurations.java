package chapter_5.revision_notes.javaCode;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class WorkingWithDurations {
	public static void main(String[] args) {
		Duration d = Duration.ofDays(1);
		System.out.println(d); // PT24H
		Duration d1 = Duration.ofHours(24*365);
		System.out.println(d1); // PT8760H
		Duration d2 = Duration.ofMinutes(1);
		System.out.println(d2); // PT1M
		Duration sixtySeconds = Duration.ofSeconds(60);
		System.out.println(sixtySeconds); // PT1M
		System.out.println(Duration.ofMinutes(60)); // PT1H
		Duration d3 = Duration.ofSeconds(1);
		System.out.println(d3);
		Duration d4 = Duration.ofMillis(1);
		System.out.println(d4); // PT0.001S
		Duration d5 = Duration.ofNanos(1);
		System.out.println(d5); // PT0.000000001S
		
		Duration chainedDuration = Duration
				.ofHours(1)
				.ofMinutes(2)
				.ofSeconds(1);
		System.out.println(chainedDuration);
		
		LocalDate date = LocalDate.of(2023, 9, 18);
		LocalTime time = LocalTime.of(12, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Duration duration = Duration.ofHours(6);
		// System.out.println(date.plus(duration)); // THROWS EXCEPTION
		System.out.println(time.plus(duration));
		System.out.println(dateTime.plus(duration));
	}
}
