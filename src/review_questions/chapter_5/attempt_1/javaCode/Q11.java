package review_questions.chapter_5.attempt_1.javaCode;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Q11 {
	public static void main(String[] args) {
		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
		Period p = Period.ofMonths(1).ofYears(2);
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter.
		    ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(d.format(f));
	}
}
