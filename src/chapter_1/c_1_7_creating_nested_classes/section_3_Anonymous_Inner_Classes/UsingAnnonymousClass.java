package chapter_1.c_1_7_creating_nested_classes.section_3_Anonymous_Inner_Classes;

public class UsingAnnonymousClass {
	interface SaleTodayOnly {
		int priceOff();
	}
	SaleTodayOnly sale = new SaleTodayOnly() {
		public int priceOff() {
			return 50;
		}
	};
}
