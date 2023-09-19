package chapter_5.revision_notes.javaCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDateAndTime {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2023, 9, 19);
		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		DateTimeFormatter shortDate =
				DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		System.out.println(shortDate.format(date)); // 19/09/2023
		// System.out.println(shortDateTime.format(time));
		// THROWS EXCEPTION
		System.out.println(shortDate.format(dateTime));
		// 19/09/2023
		
		DateTimeFormatter shortTime =
				DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(shortTime.format(time)); // 11:22
		System.out.println(shortTime.format(dateTime)); // 11:22
		// System.out.println(shortTime.format(date));
		// THROWS EXCEPTION
		
		DateTimeFormatter shortDateTime =
				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(shortDateTime.format(dateTime));
		// 19/09/2023, 11:22
		// System.out.println(shortDateTime.format(time));
		// shortDateTime.format(date);
		
		
	}
}
