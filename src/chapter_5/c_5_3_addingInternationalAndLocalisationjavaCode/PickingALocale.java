package chapter_5.c_5_3_addingInternationalAndLocalisationjavaCode;

import java.util.Locale;

public class PickingALocale {
	
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		System.out.println(locale); // en_GB
		
		Locale customLocale = new Locale.Builder()
				.setRegion("UK")
				.setLanguage("en")
				.build();
		System.out.println(customLocale); // en_UK
		
	}

}
