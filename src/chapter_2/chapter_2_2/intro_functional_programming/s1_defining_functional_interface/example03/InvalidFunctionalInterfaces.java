package chapter_2.chapter_2_2.intro_functional_programming.example03;
import chapter_2.chapter_2_1.designing_an_interface.example03.Animal;
import chapter_2.chapter_2_2.intro_functional_programming.example01.Sprint;

public class InvalidFunctionalInterfaces {}
/* Here are some examples of invalid functional interfaces:*/

// invalid #1:
interface Walk{}
// there are no abstract methods defined

// invalid #2:
interface Dance extends Sprint {
	public void dance(Animal animal);
}
// this interface inherits an abstract method giving a total of two

// invalid #3:
interface Crawl {
	public void crawl();
	public int getCount();
}
// two abstract methods are defined

/*NOTE: using @FunctionalInterface on any of the above will yield compiler error*/