package revision_notes.javaCode.chapter2;

public class FunctionalInterfaces {
	public static void main(String[] args) {
		InterfaceFunctional f = () -> true;
	}
}

@FunctionalInterface
interface InterfaceFunctional {
	boolean test();
//	boolean method();
	default void defaultMethod() {	}
	static void staticMethod() {}
}

@FunctionalInterface
interface VoidInterface{
	void voidMethod();
}