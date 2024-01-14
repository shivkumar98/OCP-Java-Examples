package revision_notes.javaCode.chapter2;

public interface InterfacesInJava {
	private static void staticMethod() { System.out.println(1); }
	public static final int height = 1;
	private default defaultMethod() { System.out.println(12); }
}


interface InterfaceA {
	static void sameNameMethodA() {}
	default void sameNameMethodB() {}
}
interface InterfaceB {
	static void sameNameMethodA() {}
	default void sameNameMethodB() {}
}
interface ExtendsAAndB extends InterfaceA, InterfaceB {}