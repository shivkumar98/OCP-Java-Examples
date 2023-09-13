package chapter_5.c_5_3_addingInternationalAndLocalisation.javaCode.Formatting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class PredefinedFormats {
	public static void main(String[] args) {
//		LocalDate date = LocalDate.of(2023, 9, 13);
//		LocalTime time = LocalTime.of(11,12,34);
//		LocalDateTime dateTime = LocalDateTime.of(date, time);
//		
//		DateTimeFormatter shortF = 
//				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
//		DateTimeFormatter mediumF = 
//				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
//		System.out.println(dateTime); // 2023-09-13T11:12:34
//		System.out.println(shortF.format(dateTime)); // 13/09/2023, 11:12
//		System.out.println(mediumF.format(dateTime)); // 13 Sept 2023, 11:12:34
//		
//		// You can also define your own DateTimeFormatter
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
//		System.out.println(formatter.format(dateTime)); // September 13, 2023, 11:12
	
		System.out.println("----------------");
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
		// LocalDate date = LocalDate.parse("01 02 2015"); // THROWS EXCEPTION
		System.out.println(LocalDate.parse("01 02 2015", f)); // 2015-01-02
		System.out.println(LocalTime.parse("16:27")); // 16:27
		
	}
}
