package chapter_1.c_1_7_creating_nested_classes.section_2_Local_Inner_Classes;

public class Outer {

	private int length = 5;
	void calculate() {
		int width = 20;
		//width= 2;
		class Inner {
			void multiply() {
				System.out.println(width*length); // COMPILER ERRO IF ABOVE IS PRESENT
			}
		}
		new Inner().multiply();
		
	}
	public static void main(String[] args) {
		new Outer().calculate(); // 100
		
	}
}
