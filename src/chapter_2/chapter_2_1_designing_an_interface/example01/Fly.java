package chapter_2.chapter_2_1_designing_an_interface.example01;
/* Below is an example of an interface and a class which implements it
*/
public interface Fly {
	public int getWingSpan() throws Exception;
	public static final int MAX_SPEED = 100;
	
	public default void land() {
		System.out.println("Animal is landing");
	}
	public static double calculateSpeed(float distance, double time) {
		return distance/time;
	}
}

/* Implementing class: */

class Eagle implements Fly {
	public int getWingSpan() throws Exception {
		return 15;
	}
	public void land() {
		System.out.println("Eagle dives quickly");
	}
}

/* the getWingSpan override optionally throws exception
   the land() method is optionally overrided
   the calculateSpeed is a static method
*/