package chapter_1.chapter_1_1_access_modifiers.access_modifiers.access_modifiers.cat.species;

import chapter_1.chapter_1_1_access_modifiers.access_modifiers.access_modifiers.cat.BigCat;

public class CatInDifferentPackage extends BigCat{
	
	public static void main(String[] args) {
		String w = BigCat.publicVar;
		String x =  BigCat.protectedVar;
		// Boolean y = BigCat.defaultVar // ONLY ACCESSIBLE IN SAME PACKAGE
		
	}
	

}
