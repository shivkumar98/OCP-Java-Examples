package chapter_10.c_10_3_connecting_to_a_db.java_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:derby:zoo",
				"username",
				"password");
		System.out.println(conn);
		// org.apache.derby.impl.jdbc.EmbedConnection@98826337 (XID = 266), (SESSIONID = 1), (DATABASE = zoo), (DRDAID = null) 

		Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ocp-book",
"username",
"password");
		System.out.println(conn2);
		
	}
}
