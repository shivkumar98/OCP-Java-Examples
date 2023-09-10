package chapter_5.c_5_3_addingInternationalAndLocalisation.javaCode.Zoo;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class ZooOpen {
	
	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		printProperties(us);
		System.out.println("----------");
		printProperties(france);
		
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);
		Set<String> keys = rb.keySet();
		keys.stream().map(k -> k + " "+rb.getString(k))
			.forEach(System.out::println);
		// hello Hello
		// open The zoo is open.

		
	}

	private static void printProperties(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
		
		
	}

}
