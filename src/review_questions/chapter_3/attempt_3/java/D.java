package review_questions.chapter_3.attempt_3.java;

class A {}
class B extends A {}
class C extends B {}

public class D<C> {
	A a1 = new A();
	A a2 = new B();
	// A a3 = new C(); COMPILER ERROR
	// C c1 = new C(); // COMPILER ERROR

}
