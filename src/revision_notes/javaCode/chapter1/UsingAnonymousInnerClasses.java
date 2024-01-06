package revision_notes.javaCode.chapter1;

public class UsingAnonymousInnerClasses {
	interface Vehicle {
		void move();
	}
	public static void main(String[] args) {
		Vehicle car = new Vehicle() {
			public void move() { System.out.println("Lift clutch");			}
		};
	}
}
