package chapter_5.c_5_3_addingInternationalAndLocalisation.javaCode.Zoo;

import java.util.Locale;
import java.util.ResourceBundle;

public class ZooOpenUsingJava {
	public static void main(String[] args) {
		Locale locale = new Locale("en", "US");
		ResourceBundle rb = ResourceBundle.getBundle("ZooJava");
		rb.keySet().stream()
			.forEach(k -> System.out.println(k +": "+rb.getString(k)));
		
	}
}
