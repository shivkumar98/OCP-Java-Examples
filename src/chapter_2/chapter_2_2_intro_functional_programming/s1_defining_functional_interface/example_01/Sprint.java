package chapter_2.chapter_2_2_intro_functional_programming.s1_defining_functional_interface.example_01;
/* below defines a functional interface*/

import chapter_2.chapter_2_1_designing_an_interface.example03.Animal;

@FunctionalInterface
public interface Sprint {
	public void sprint(Animal animal);
}

/* implementation of functional interface: */
class Tiger implements Sprint {
	public void sprint(Animal animal) {
		System.out.println("The animal: "+animal.toString()+ " is sprinting");;
	}
}