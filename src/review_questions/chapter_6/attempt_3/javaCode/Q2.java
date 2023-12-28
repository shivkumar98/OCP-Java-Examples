package review_questions.chapter_6.attempt_3.javaCode;

class StuckTurkeyCage implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new Exception("Cage door does not close");
	}
	
}

public class Q2 {
	public static void main(String[] args) throws Exception  {
		try (StuckTurkeyCage cage = new StuckTurkeyCage()) {
			
		} 
	}
}
