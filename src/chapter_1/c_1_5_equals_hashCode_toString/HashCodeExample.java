package chapter_1.c_1_5_equals_hashCode_toString;


/*
 * What is a hashcode?
 * hashcode is an integer associated with an object
 * 
 * Javadocs specifies what a hashCode pertains to:
 * 1) Within the same program, the hashcode value must not change.
 * 	  I.e. the hashcode should not be associated with a variable
 * 2) For two objects to be equal when calling equals(), their hashCodes must also be equal
 * 	  I.e. objects with different hashcodes should not be considered equal
 * 3) It is not required that for two object considered unequal that the hashCodes also be equal
 *    I.e. hence, two objects having the same hashCode does NOT imply the objects are equal
 */
public class HashCodeExample {
	
	public static void main(String[] args) {
		Card card = new Card();
		System.out.println(card.hashCode()); // 0
		String str = "hello, world";
		System.out.println(str.hashCode()); // -640608884

	}
	

}

class Card {
	@Override
	public int hashCode() {
		return 0;
		
	}
}
