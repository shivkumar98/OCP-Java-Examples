package chapter_1.c_1_1_access_modifiers.access_modifiers.access_modifiers.cat;

public class CatInSamePackage extends BigCat {
	public static void main(String[] args) {
		String w = BigCat.publicVar;
		String y = BigCat.protectedVar; // sub class can access
		boolean x = BigCat.defaultVar; // same package, accessible
	}

}
