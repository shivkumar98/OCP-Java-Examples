package chapter_1.using_instanceof;

/* What is instanceof?
 * 'A instanceof B'
 *  returns true if ref of A points to is:
 *  1) an instance of class B
 *  2) a class which implements the B interface (indirect or direct) 
 */



public class Example {
	
	public static void main(String[] args) {
		ScaryAnimal tiger = new Tiger();
		Tiger tiger2 = new Tiger();
		
		System.out.println(tiger instanceof Tiger); // true
		System.out.println(tiger instanceof ScaryAnimal); // true
		System.out.println(tiger2 instanceof ScaryAnimal); // true
		/* System.out.println(tiger2 instanceof Lion); // does not compile */
		System.out.println(tiger instanceof Lion); // false
		
		/* All classes inherit from java.lang.Object,
		 * so instanceof Object returns true for all instances:
		 */
		Lion lion = new Lion();
		System.out.println(lion instanceof Object); // true
		/* however, null is not considered an instance of Object*/
		Lion lion2 = null;
		System.out.println(lion2 instanceof Lion); // false
		System.out.println(lion2 instanceof Object);
		
	}

}

class ScaryAnimal {}
class Tiger extends ScaryAnimal {}
class Lion extends ScaryAnimal {}