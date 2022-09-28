package chapter_1.chapter_1_7.creating_nested_classes.section_4.Static_Nested_Classes;
/* What is a static nested class?
 * A: this is a static class defined at member level of another class.
 *   - This type can be instantiated without an object of the enclosing class.
 *   - Nesting creates namespace
 *   - They can be private/protected/public/default access
 *   - The enclosing class can refer to members of static nested class
 */
public class StaticNestedClass {
	static class StaticClass{
		int price = 100;
	}
	public static void main(String[] args) {
		StaticNestedClass enlosing = new StaticNestedClass();
		/* Enclosing class cannot access the member of nested element*/
		 // System.out.println(enclosing.price); does not compile
		StaticClass nested = new StaticClass();
		System.out.println(nested.price); // 100
		
	}
}
