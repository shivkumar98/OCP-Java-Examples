package chapter_10.c_10_6_getting_data_from_resultset.java_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ScrollingResultSet {
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby:zoo";
		String sqlQuery = "SELECT id FROM species"
				+ " ORDER BY id";
		try (Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
				
			ResultSet rs = stmt.executeQuery(sqlQuery)) {
			rs.afterLast();

			System.out.println(rs.previous()); // true
			System.out.println(rs.getInt(1)); // 2
			System.out.println(rs.previous()); // true
			System.out.println(rs.getInt(1)); // 1
			System.out.println(rs.previous()); // false
			/* The following would throw an SQLException:
			System.out.println(rs.getInt(1)); 
			*/
			System.out.println(rs.next());
			System.out.println(rs.getInt(1)); // 1
		}
	}
}
