package chapter_3.revision_notes;

public class Generics {
	public static void main(String[] args) {
		ShippableAbstractCrate s = new ShippableAbstractCrate();
		s.ship(new Robot());
	}
}

interface Shippable<T> {
	void ship(T t);
}

class ShippableAbstractCrate<U> implements Shippable<U> {

	
	public void ship(U u) {
		
	}
	
}
