package chapter_1.chapter_1_4_annotating_overridden_methods;

public class Phone {
	public static void staticMethod() {}
	private void privateMethod() {}
	public void regMethod() {}
}

class iPhone extends Phone {
//	@Override
//	public static void staticMethod() {} // COMPILER ERROR
	
//	@Override
//	public void privateMethod() {} // CAN NOT SEE Phone's privateMethod
	
	@Override
	public void regMethod() {} // WORKS FINE
	
	
}