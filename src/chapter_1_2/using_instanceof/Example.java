package chapter_1_2.using_instanceof;

/* What is instanceof?
 * 'A instanceof B'
 *  returns true if ref of A points to is:
 *  1) an instance of class B
 *  2) a class which implements the B interface (indirect or direct)
 *  A common use of instanceof is to determine if an instance is a subclass of a particular object before applying an explicit cast  
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
		System.out.println(lion2 instanceof Object); // false
		
		Lion lion3 = new Lion();
		
		/* the compiler can check whether a object is not related to a class:
		* E.g.: System.out.println(lion3 instanceof Tiger);  does not compile
		* However this compiler check only applies for classes and not interfaces
		*/
		
		ScaryAnimal tiger3 = new Tiger();
		System.out.println(tiger3 instanceof Mother); // false
		/* even though tiger is not an implementation of Mother,
		 * the compiler does not do a check
		 */
	}

}

class ScaryAnimal {}
class Tiger extends ScaryAnimal {}
class Lion extends ScaryAnimal {}

interface Mother {}
