package review_questions.chapter_5.attempt_4.java;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Q10 {
	public static void main(String[] args) {
		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
		Period p = Period.of(1,2,3);
		d = d.minus(p);
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(d));
		DateTimeFormatter.ofLocalizedDate(null);
		
	}
}
