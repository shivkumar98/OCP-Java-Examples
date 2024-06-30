package review_questions.chapter_5.attempt_4.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Q7 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.parse("2018-04-30",
				DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(date.plusDays(2));
		System.out.println(date.getYear()+" "+date.getMonth()+" "+date.getDayOfMonth());
	}
}
