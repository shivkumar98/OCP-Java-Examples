package chapter_2.c_2_4_understanding_design_principles.s1_Encapsulating_Data.example01;
/* E.g. suppose we deisgn an Animal class with the following design requirements:
 * 1) Each animal has a non-null, non-empty species field
 * 2) Each animal has an age >= 0
 */

/* To demonstrate encapsulation, let's look at a class WITHOUT encapsulation: */

public class Animal {
	
	public String species;
	public int age;
	
	public static void main(String[] args) {
		Animal animal = new Animal(); // this violates requirement 1
		animal.age = -100; // this violates requirement 2
	}

}

/* We can encapsulate this class via the following:*/

class Animal2 {
	private String species;
	private int age;
	
	public Animal2(String speciesName) { // age is 0 by default
		this.setSpecies(speciesName);
		
	}
	
	// public setters:
	public void setSpecies(String speciesName) {
		if (speciesName.trim().length()== 0 || speciesName == null) {
			throw new IllegalArgumentException("provide valid species name");
		}
		this.species = speciesName;
	}
	
	public void setAge(int age) {
		if (age>=0) {
			this.age = age;
		}
	}
	
	//public getters
	public int getAge() { return this.age;	}
	public String getSpecies() { return this.species; }
}