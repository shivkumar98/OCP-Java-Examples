package chapter_1_1.access_modifiers.cat.species;

import chapter_1_1.access_modifiers.cat.BigCat;

public class Lynx extends BigCat {
	
	public static void main(String[] args) {
		BigCat cat = new BigCat();
		// You can access public field in any class
		cat.breed = "Lynx";
		// You can not access protected variables
		// this codes not compile: cat.owner = "shiv";
		// a subclass instance can access the default access field
		Lynx lynx = new Lynx();
		lynx.owner = "shiv";
		// You would not be able to access fields if use BigCat as reference
		BigCat sameLynx= lynx;
		/* this does not compile:
		sameLynx.owner = "sammy" */
	}

}
