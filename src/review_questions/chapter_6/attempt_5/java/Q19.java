package review_questions.chapter_6.attempt_5.java;

import java.sql.SQLException;

public class Q19 {
	public void readFromDatabase() throws SQLException {}
	
	public void read() throws SQLException {
		try { 
			readFromDatabase(); 
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
