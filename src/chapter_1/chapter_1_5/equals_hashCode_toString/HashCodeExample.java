package chapter_1.chapter_1_5.equals_hashCode_toString;


/*
 * What is a hashcode?
 * hashcode is an integer associated with an object
 * 
 * Javadocs specifies what a hashCode pertains to:
 * 1) Within the same program, the hashcode value must not change.
 * 	  I.e. the hashcode should not be associated with a variable
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
