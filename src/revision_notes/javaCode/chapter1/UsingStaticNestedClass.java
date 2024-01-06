package revision_notes.javaCode.chapter1;

public class UsingStaticNestedClass {
	static int x;
	protected static class Inner {
		static int x;
	}
	
	public static void main(String[] args) {
		Inner inner = new Inner();
		System.out.println(inner.x);
		
		}
}
