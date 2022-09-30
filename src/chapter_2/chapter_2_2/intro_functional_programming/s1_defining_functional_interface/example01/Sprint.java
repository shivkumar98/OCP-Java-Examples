package chapter_2.chapter_2_2.intro_functional_programming.example01;
/* below defines a functional interface*/

import chapter_2.chapter_2_1.designing_an_interface.example03.Animal;

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