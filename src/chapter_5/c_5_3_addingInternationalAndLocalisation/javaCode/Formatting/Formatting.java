package chapter_5.c_5_3_addingInternationalAndLocalisation.javaCode.Formatting;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatting {
	public static void main(String[] args) {
		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		NumberFormat ger = NumberFormat.getInstance(Locale.GERMANY);
		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println(us.format(attendeesPerMonth)); // 266,666
		System.out.println(ca.format(attendeesPerMonth)); // 266 666
		System.out.println(ger.format(attendeesPerMonth)); // 266.666
		
		double price = 48;
		System.out.println(NumberFormat
				.getCurrencyInstance(Locale.US)
				.format(price)); // $48.00
		System.out.println(NumberFormat
				.getCurrencyInstance(Locale.CANADA_FRENCH)
				.format(price)); // 48,00 $ CA
		System.out.println(NumberFormat
				.getCurrencyInstance(Locale.GERMANY)
				.format(price)); // 48,00 €
		
	}
}
