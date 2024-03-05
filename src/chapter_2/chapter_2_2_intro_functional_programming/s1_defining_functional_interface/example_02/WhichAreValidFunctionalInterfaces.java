package chapter_2.chapter_2_2_intro_functional_programming.s1_defining_functional_interface.example_02;

import chapter_2.chapter_2_1_designing_an_interface.example03.Animal;

/* Sprint interface definition:
	@FunctionalInterface
	public interface Sprint {
		public void sprint(Animal animal);
	}
 */


public class WhichAreValidFunctionalInterfaces {}

/* QUESTION: Which of the following 3 are valid functional interfaces?*/

// interface 1:
//interface Run extends Sprint{}
// interface 2:
//interface SprintFaster extends Sprint{
//	public void sprint(Animal animal);
//}
// interface 3
//interface Skip extends Sprint{
//	public default int getHopCount(Kangaroo kangaroo) {	return 10; }
//	public static void skip(int speed) {}
//}

/* ANSWER: All 3 of them!
*  interface 1 extends sprint so it inherits a single abstract method
*  interface 2 overrides the abstract method with another abstract method
*  interface 3 contains a default implementation meaning it still has the inherited abstract method
*  ∴ all 3 are valid functional interfaces*/
