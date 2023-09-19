package chapter_5.revision_notes.javaCode;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbers {
	
	public static void main(String[] args) throws ParseException {
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		NumberFormat ger = NumberFormat.getInstance(Locale.GERMANY);
		String num = "32,000,000";
		System.out.println(us.parseObject(num)); // 32000000
		System.out.println(ger.parse(num)); // 32
		
		String amt = "$92,807.99";
		NumberFormat usDollar = NumberFormat.getCurrencyInstance(Locale.US);
		Number dollar = usDollar.parse(amt);
		System.out.println(dollar);
	}

}
