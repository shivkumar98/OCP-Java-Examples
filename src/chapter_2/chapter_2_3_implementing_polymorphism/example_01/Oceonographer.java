package chapter_2.chapter_2_3_implementing_polymorphism.example_01;

interface LivesInSea { public void makeSound();}

class Whales implements LivesInSea {
	public void makeSound() { System.out.println("pulse");	}
}

class Dolphin implements LivesInSea {
	public void makeSound() { System.out.println("sing");	}
}

public class Oceonographer {
	public void checkSound(LivesInSea animal) {
		animal.makeSound();
	}
	public static void main(String[] args) {
		Oceonographer o = new Oceonographer();
		o.checkSound(new Dolphin()); // sing
		o.checkSound(new Whales()); // pulse
	}
}

/* In this example, we can see the use of polymorphic parameters allowing the checkSound method to take any class which implements the interface
*/