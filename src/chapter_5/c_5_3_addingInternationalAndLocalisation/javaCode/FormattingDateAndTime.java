package chapter_5.c_5_3_addingInternationalAndLocalisation.javaCode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDateAndTime {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2020, 2, 3);
		System.out.println(date1.getDayOfYear()); // 34
		System.out.println(date1.getDayOfMonth()); // 3
		System.out.println(date1.getDayOfWeek()); // MONDAT
		System.out.println(date1.getMonth()); // FEBRUARY
		
		System.out.println("----------------------");
		
		LocalDate date = LocalDate.of(2020,
				Month.JANUARY, 
				20);
		LocalTime time = LocalTime.of(11,12,34);
		LocalDateTime dateTime =
				LocalDateTime.of(date, time);
		System.out.println(date); // 2020-01-20
		System.out.println(
				date.format(DateTimeFormatter
						.ISO_DATE)
				); // 2020-01-20
		System.out.println(time); // 11:12:34
		System.out.println(
				 time.format(DateTimeFormatter
						 .ISO_LOCAL_TIME)); // 11:12:34
		System.out.println(
				dateTime.format(
						DateTimeFormatter
						.ISO_DATE_TIME)
				); // 2020-01-20T11:12:34
		
		
		DateTimeFormatter shortDateTime = DateTimeFormatter
				.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(dateTime.format(shortDateTime));
		// 20/01/2020
		
		System.out.println(date.format(shortDateTime)); 
		// 20/01/2020
		// System.out.println(time.format(shortDateTime));
		// throws UnsupportedTemporalTypeException
		
		
		
		
				
	}
}
