package review_questions.chapter_1.q16;
/* QUESTION: Which of the following can be inserted in main?
   OPTIONS:
	A. Inner in = new Inner(); - can not instantiate local inner class
	B. Inner in = Outer.new Inner(); - can not use reference to instantiate inner
	C. Outer.Inner in = new Outer.Inner(); - nope
	D. Outer.Inner in = new Outer().new Inner(); - yes
	E. Outer.Inner in = Outer.new Inner()
   
 */
public class Outer {
	
	class Inner { }
	
	public static void main(String[] args) {
		// INSERT CODE HERE
		Inner in = new Outer().new Inner(); // this is valid
		Outer.Inner in2 = new Outer().new Inner(); //this is also valid
		Inner in3 = new Inner(); // does not compile
		Outer.Inner in4 = Outer.new Inner(); // does not compile
	}

}
