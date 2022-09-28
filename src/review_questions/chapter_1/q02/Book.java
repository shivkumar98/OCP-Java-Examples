package review_questions.chapter_1.q02;
/* QUESTION: What is the result of compiling the following class?
 * ANSWERS:
 *  A. The code compiles.
	B. The code does not compile because hashCode() is incorrect.
	C. The code does not compile because equals() does not override the parent method 
	   correctly.
	D. The code does not compile because equals() tries to refer to a private field.
	E. The code does not compile because the ClassCastException is not handled or 
	   declared.
	F. The code does not compile for another reason.
	
	CORRECT ANSWER: A 
 */

public class Book {
	private int ISBN;
	private String title, author;
	private int pageCount;
	public int hashCode() { return ISBN; }
	@Override public boolean equals(Object obj) {
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		return this.ISBN == other.ISBN;
	}
}
