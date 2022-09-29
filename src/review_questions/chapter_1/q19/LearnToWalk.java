package review_questions.chapter_1.q19;
/* QUESTION: Which of the following can be inserted to override the supereclass method?
   OPTIONS:
	A. public void toddle() {} - yes
	B. public void Toddle() {} - no
	C. public final void toddle() { } - yes
	D. public static void toddle() { } - no, this is not a valid override
	E. public void toddle(boolean fall) {} - no, this is an overload
	
	ANSWER: A,C
 */
public class LearnToWalk {
	public void toddle() {
		class BabyRhino extends LearnToWalk{
			// INSERT CODE HERE
		}
	}
}

class LearnToWalk1 {
	public void Toddle() {
		class BabyRhino extends LearnToWalk1{
			public void toddle() {} // compiles fine
		}
	}
}

class LearnToWalk2 {
	public void Toddle() {
		class BabyRhino extends LearnToWalk2{
			public void Toddle() {} // compiles fine but not an overload
		}
	}
}

class LearnToWalk3 {
	public void Toddle() {
		class BabyRhino extends LearnToWalk3{
			public final void toddle() {} // compiles fine
		}
	}
}

class LearnToWalk4 {
	public void Toddle() {
		class BabyRhino extends LearnToWalk4{
			public static void toddle() {} // does not compile
		}
	}
}

class LearnToWalk5 {
	public void Toddle() {
		class BabyRhino extends LearnToWalk5{
			public void toddle(boolean fall) {} // compiles fine but not an override
		}
	}
}