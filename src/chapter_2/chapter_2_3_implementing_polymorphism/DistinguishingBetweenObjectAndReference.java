package chapter_2.chapter_2_3_implementing_polymorphism;


/*
 * In java, objects can only be accessed via reference. There is no direct memory access
 * Regardless of type, the object in memory does not change.
 * 	For example, we can instantiate a Lemur object and reference it via Object.
 * If we reference the lemur as Object, we no longer have access to the Lemur properties unless we cast it back to Lemur
 * 
 * Hence, we have two rules for polymorphism
 * 1) Type of object determines which properties exist in memory
 * 2) Type of reference to object determines which variables and methofds are accessible to Java program
 * 
 */
public class DistinguishingBetweenObjectAndReference {
	public static void main(String[] args) {
		Primate lemur = new Lemur();
		// lemur.age; - does not compile
		Lemur lemur2 = (Lemur) lemur;
		System.out.println(lemur2.age); // 10
	}
}

/* Here are two rules for casting variables:
 * 1) Casting to superclass does not require explicit cast - but is allowed
 * 2) Casting to subclass REQUIRES explicit cast
 * 3) The compiler will not allow cast to unrelated types
 * 4) Not all unrelated casting can be detected at compile time
 */
 


class Primate {
	public boolean hasHair() { return true; }
}

interface HasTail {
	public boolean isTailStriped();
}

class Lemur extends Primate implements HasTail{
	public int age = 10;
	public boolean isTailStriped() { return false; }
}