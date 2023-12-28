package review_questions.chapter_6.attempt_3.javaCode;

import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;

public class Q19 {

	public void readFromDB() throws SQLException {	}
	public void read() throws SQLException {
		try {
			readFromDB();

		} catch (SQLException | IOException e) { // does not compile
			// TODO: handle exception
		}
		
	}
	
}

