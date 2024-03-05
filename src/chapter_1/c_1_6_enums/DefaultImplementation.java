package chapter_1.c_1_6_enums;

public class DefaultImplementation {
	
	/* enums can have a default implementation*/

}

enum Season3 {
	WINTER{
		public void printHours() { System.out.println("short hours");}
	},
	SUMMER {
		public void printHours() { System.out.println("long hours");}
	}, SPRING, FALL;
	public void printHours() {
		System.out.println("default hours");
	}
	
}


