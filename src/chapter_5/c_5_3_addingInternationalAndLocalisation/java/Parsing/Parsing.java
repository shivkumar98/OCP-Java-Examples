package chapter_5.c_5_3_addingInternationalAndLocalisation.java.Parsing;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Parsing {
	public static void main(String[] args) throws ParseException {
		String s = "40.45";
		NumberFormat us = NumberFormat
				.getInstance(Locale.US);
		NumberFormat fr = NumberFormat
				.getInstance(Locale.FRANCE);
		System.out.println(us.parse(s));
		// 40.45
		System.out.println(fr.parse(s));
		// 40 
		
		String dollarAmount = "$92,807.99";
		NumberFormat cf = 
				NumberFormat.getCurrencyInstance(
						Locale.US);
		double value = (double) cf.parse(dollarAmount);
		System.out.println(value); // 92807.99
		
	}
}
