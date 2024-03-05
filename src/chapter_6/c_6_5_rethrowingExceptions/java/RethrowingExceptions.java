package chapter_6.c_6_5_rethrowingExceptions.java;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class RethrowingExceptions {
	static void parseData() throws SQLException, DateTimeParseException {
		throw new NullPointerException();
	}
	
	public static void main(String[] args) throws DateTimeParseException, SQLException {
		rethrowing();
	}
	
	static void rethrowing() throws SQLException, DateTimeParseException {
		try {
			parseData();
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		} 
	}
}
