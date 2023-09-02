package chapter_1.revision_notes.localinnerclasses;

public class Outer {
	int width = 10;
	void calculateArea() {
		int length = 20;
		class Calculator {
			void multiply() {
				System.out.println(width*length);
			}
		}
		Calculator calculator = new Calculator();
		calculator.multiply();
	}
	public static void main(String[] args) {
		new Outer().calculateArea(); // 200
	}
}
