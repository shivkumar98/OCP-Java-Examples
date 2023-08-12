package chapter_2.revision_notes.factorypattern;

public abstract class Food {
	private int quantity;
	public Food(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() { return quantity; }
	public abstract void consumed();
}

class Pizza extends Food {
	public Pizza(int quantity) {
		super(quantity);
	}
	public void consumed() {
		System.out.println("pizza eaten "+getQuantity());
	}
}
class Falafel extends Food {
	public Falafel(int quantity) {
		super(quantity);
	}
	public void consumed() {
		System.out.println("falafel eaten "+getQuantity());
	}
}
class Fish extends Food {
	public Fish(int quantity) {
		super(quantity);
	}
	public void consumed() {
		System.out.println("pizza eaten "+getQuantity());
	}
}

