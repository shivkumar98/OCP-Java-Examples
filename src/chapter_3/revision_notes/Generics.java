package chapter_3.revision_notes;

public class Generics {
	//static T variable; // COMPILER ERROR
	public static void main(String[] args) {
		Shippable[] arr = new Shippable[2];
		
	}
}

interface Shippable<T> {
	void ship(T t);
}

class ShippableAbstractCrate<U> implements Shippable<U> {
	public void ship(U u) {	}
}

class WithGeneric<T> {
	void method(T t) {
		//T[] arr = new T[2]; // CAN NOT CREATE A GENERIC ARRAY WITH T
	}
}