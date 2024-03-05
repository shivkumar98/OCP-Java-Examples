package chapter_1.c_1_4_annotating_overridden_methods;

/* Annotations can be used to explicity indicate a method is being overridden
 * using the @Override method can be useful as the compiler will tell you if the method is not overiddent correctly
 */
public class Example {

}

abstract class Abstraction{
	abstract void method();
	abstract void findHome();
}

class Concretions extends Abstraction {
	@Override
	void method() {	}
	/*
	 * The compiler will ask you if you want to change the signature of the method in the abstract class
	@Override
	void findHome(Boolean x) {}
	*/

	@Override
	void findHome() {
		// TODO Auto-generated method stub
		
	}
}