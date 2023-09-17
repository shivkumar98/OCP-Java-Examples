package review_questions.chapter_5.attempt_1.javaCode;

import java.time.LocalDate;
import java.time.Month;

public class Q09 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2018, Month.APRIL, 30);
		date.plusDays(2);
		date.plusYears(3);
		System.out.println(date.getYear() + " "
		    + date.getMonth() + " " + date.getDayOfMonth());
	}
}
