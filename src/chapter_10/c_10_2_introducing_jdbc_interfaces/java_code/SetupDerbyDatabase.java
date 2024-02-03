package chapter_10.c_10_2_introducing_jdbc_interfaces.java_code;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SetupDerbyDatabase {
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby:zoo;create=true";
		try (Connection conn = DriverManager.getConnection(url);
			 Statement stmt = conn.createStatement()) {
			
			stmt.executeUpdate(
			"CREATE TABLE species ("
					+ "id INTEGER PRIMARY KEY, "
					+ "name VARCHAR(255), "
					+ "num_acres DECIMAL)");
			stmt.executeUpdate("DROP TABLE animal");
			stmt.executeUpdate(
			"CREATE TABLE animal ("
					+ "id INTEGER PRIMARY KEY, "
					+ "species_id integer, "
					+ "name VARCHAR(255))");
			
			stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
			stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
			stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa')");
			stmt.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda')");
			stmt.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester')");
			stmt.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie')");
			stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe')");		
		}
	}

}
