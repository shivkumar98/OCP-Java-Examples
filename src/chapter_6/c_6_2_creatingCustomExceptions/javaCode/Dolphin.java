package chapter_6.c_6_2_creatingCustomExceptions.javaCode;

class CanNotSwimException extends Exception {}
class DangerInTheWater extends RuntimeException {}
public class Dolphin {
	void swim() throws CanNotSwimException {
		// if logic:
		throw new CanNotSwimException();
	}
	
	void swim2() {
		throw new DangerInTheWater();
	}
	
	public static void main(String[] args) {
		Dolphin dolphin = new Dolphin();
		// dolphin.swim(); // COMPILER ERROR
		try { 
			dolphin.swim();
		} catch (CanNotSwimException e) { // REQUIRED!
			System.out.println(e);
		} finally {
			System.out.println("FINALLY");
		}
		System.out.println("after try/catch");
		
		dolphin.swim2(); // COMPILES FINE
	}
}