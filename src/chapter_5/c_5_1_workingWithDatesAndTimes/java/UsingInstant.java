package chapter_5.c_5_1_workingWithDatesAndTimes.java;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class UsingInstant {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2023,9,9);
		ZoneId zone = ZoneId.of("Etc/UTC");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date, LocalTime.now(), zone);
		Instant instant = zonedDateTime.toInstant();
		System.out.println(instant); // 2023-09-09T16:38:42.578524300Z
		
		Instant then = Instant.now();
		someTimeConsumingCode();
		Instant now = Instant.now();
		System.out.println(Duration.between(then, now)); // PT4.677916S

	}

	private static void someTimeConsumingCode() {
		StringBuffer s = new StringBuffer("");
		for (int i =0;i<100000;i++)
			s.append(i);
		System.out.println(s);
	}
}
