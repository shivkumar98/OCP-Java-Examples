package chapter_10.c_10_6_getting_data_from_resultset.java_code;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ReadingAResultSet {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby:zoo";
		try (Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id, name from animal")) {
			Map<Integer, String> idToNameMap = new HashMap<>();
			while(rs.next()) {
				int id = rs.getInt("id"); // rs.getInt(1) gives same result
				String name = rs.getString("name"); // rs.getString(2) gives same result
				System.out.println( id + " " + name);
				idToNameMap.put(id, name);
			}
			System.out.println(idToNameMap);
			// {1=Elsa, 2=Zelda, 3=Ester, 4=Eddie, 5=Zoe}
		}
		
		}
			 
	}
