package chapter_1.chapter_1_7.creating_nested_classes.section_3.Anonymous_Inner_Classes;
/* You can define an anonymous class as an argument to another class*/
public class AnonClassAsAParameter {
	public int admission(int basePrice, SaleToday sale) {
		return basePrice - sale.poundsOff();
	}
	interface SaleToday{
		int poundsOff();
	}
	public int pay() {
		return admission(100, new SaleToday() {
			public int poundsOff() {
				return 20;
			}
		});
	}
}
