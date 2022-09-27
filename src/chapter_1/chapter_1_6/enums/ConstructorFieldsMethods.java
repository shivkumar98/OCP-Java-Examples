package chapter_1.chapter_1_6.enums;

/* We can add a constructor for each enum value, as well as fields */

public enum ConstructorFieldsMethods {
	WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
	private String expectedVisitors; // this is a field
	private ConstructorFieldsMethods(String s) { // this is a constructor
		this.expectedVisitors = s;
	}
	public void printExpectedVisitors() {
		System.out.println(expectedVisitors);
	}
	public static void main(String[] args) {
		ConstructorFieldsMethods.SUMMER.printExpectedVisitors(); //High
	}
}
