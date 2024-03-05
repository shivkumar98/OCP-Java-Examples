package chapter_1.c_1_7_creating_nested_classes.section_3_Anonymous_Inner_Classes;
/* What is an anonymous inner class?
 * A: this is a local inner class with no name!
 *   - Anonymous inner class are required to extend/implement an existing class
 *   - This is useful when a short implementation will not be used anywhere else
 * */
public class AnonymousInnerClass {
	abstract class SaleToday{
		abstract int poundsOff();
	}
	public int costOfEntry(int basePrice) {
		SaleToday sale = new SaleToday() {
			int poundsOff() {
				return 3;
			}
		};
		return basePrice - sale.poundsOff();
	}
}
