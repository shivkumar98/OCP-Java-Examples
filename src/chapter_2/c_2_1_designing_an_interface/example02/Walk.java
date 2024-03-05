package chapter_2.c_2_1_designing_an_interface.example02;
/* an interface can extend another interface: */
public interface Walk {
	boolean isQuadruped();
	abstract double getMaxSpeed();
}

interface Run extends Walk {
	public abstract boolean canHuntWhileRunning();
	abstract double getMaxSpeed();
}

/* the above interface inherits all abstract methods of Walk interface*/
/* compiler automatically insert public & abstract to all non default/ non static methods */
class Lion implements Run{
	public boolean isQuadruped() {
		return true;
	}
	public boolean canHuntWhileRunning() {
		return true;
	}
	public double getMaxSpeed() { return 100; }
	
}

/* An interface cannot extend a class: */
//interface Sleep extends Lion {} // does not compile

/* class cannot extend an interface, even an abstract one */
//class Jog extends Run {} // does not compile
