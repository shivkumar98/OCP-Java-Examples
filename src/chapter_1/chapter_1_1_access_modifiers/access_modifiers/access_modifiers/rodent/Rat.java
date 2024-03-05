package chapter_1.chapter_1_1_access_modifiers.access_modifiers.access_modifiers.rodent;

import chapter_1.chapter_1_1_access_modifiers.access_modifiers.access_modifiers.cat.BigCat;

public class Rat {
	
	public static void main(String[] args) {
		 String w = BigCat.publicVar;
//		 String x = BigCat.protectedVar; // not accessible from random class
//		 boolean y = BigCat.defaultVar; // not accessible from seperate package
	}

}
