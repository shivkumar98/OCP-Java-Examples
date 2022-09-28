package review_questions.chapter_1.q10;
/* QUESTION: The following code appears in a file named Book.java. What is the result of compiling the 
			source file?
   OPTIONS:
	A. The code compiles successfully, and one bytecode file is generated: Book.class.
	B. The code compiles successfully, and two bytecode files are generated: Book.class and 
	BookReader.class.
	C. The code compiles successfully, and two bytecode files are generated: Book.class and 
	   Book$BookReader.class.
	D. A compiler error occurs on line 3.
	E. A compiler error occurs on line 5.  
	
	CORRECT ANSWER: C - The inner class does not compile to BookReader.class as it would raise a namespace conflict
					    The scope of the BookReader class is limited to Book
*/
public class Book {
	private int pageNumber;
	private class BookReader {
		public int getPage() {
			return pageNumber;
		}
	}
}
