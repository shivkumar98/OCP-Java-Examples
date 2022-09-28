package chapter_1.chapter_1_7.creating_nested_classes.section_2.Local_Inner_Classes;

public class OuterClass {
	private int length = 5;
	public void calculate() {
		final int width = 20;
		class Inner {
			public void multiply() {
				System.out.println("multiply: "+length*width);
				
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}
	
	/* A main method is required for the above to run*/
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.calculate(); // multiply: 100
	}
}
