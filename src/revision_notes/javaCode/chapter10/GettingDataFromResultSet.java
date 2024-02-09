package revision_notes.javaCode.chapter10;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class GettingDataFromResultSet {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id from species");
		while(rs.next()) {
			Boolean s = rs.getBoolean(1);
			System.out.println(s);
			Date date = rs.getDate(1);
			LocalDate localDate = date.toLocalDate();
		}
	}
}
