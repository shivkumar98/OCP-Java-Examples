package chapter_2.chapter_2_2.intro_functional_programming.s2_lambdas_implementing_functional_interfaces;
public class UnderstandingLambdaSyntax {}

/* Let's try to understand the lambda syntax:
 * 1) (Animal a) -> { return a.canHop(); }
 * 2) a -> a.canHop();
 * The above lambdas are equivalent. The LHS of the -> symbols are the input parameters. 
 * The parameters are consumed by a functional interface whose abstract methods has the same number of parameters and compatible type
 * The RHS of -> is called the "body of the lambda expression".
 * The body can be consumed by a functional interface whose abstract method can be consumed by a functional interface
 * 
 * Let's  review the differences between 1) and 2)
 * The first lambda expression has () around the parameters. If there is one parameter => brackets can be omitted. So if there are 0 or >1 parameters you must include ()
 * The curly braces on the RHS are only required if you are using the return keyword. If there are no returns you can still write an empty brace: {}
 * You can not redeclare a local variable in Java so the following syntax would be invalid:
 * 	(a,b) -> { int a=0; return 5; }
 */

class LamdaSyntaxExamples {
	Run r1 = () -> 0;
	Run r2 = () -> {return 0;};
	// Run r3 = () -> {}; - does not compile, requires an int to be returned
	
	Walk w1 = () -> {};
	// Walk w2 = (String s) -> {}; - does not compile, does not match signature of interface 
	Walk w3 = () -> {return;};
	
	Jog j1 = (e, d) -> e+d;
	// Jog j2 = (int e, d) -> e+d; - does not compile, must specify all types
	
	Limp l1 = (e, n) -> e+n;
	// Limp l2 = (e,n) -> { int e = 1; return "energy" + e; - does not compile, can not redeclare local type
}

interface Run {
	public int speed();
}


interface Walk {
	void speed();
}

interface Jog {
	int speed(int energy, int distance);
}

interface Limp {
	String speed(int energy, String name);
}