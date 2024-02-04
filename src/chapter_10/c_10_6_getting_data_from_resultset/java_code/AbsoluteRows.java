package chapter_10.c_10_6_getting_data_from_resultset.java_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbsoluteRows {
	public static void main(String[] args) throws SQLException {
	String url = "jdbc:derby:zoo";
	String sqlQuery = "SELECT id FROM species"
			+ " ORDER BY id";
	try (Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(sqlQuery)) {
		System.out.println(rs.absolute(0)); // false
		System.out.println(rs.next()); // true
		System.out.println(rs.getInt(1));
	}
	
	}
	

}
