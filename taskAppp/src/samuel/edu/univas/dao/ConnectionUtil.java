package samuel.edu.univas.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static final  String USER = "root";
	private static final String PASSWORD = "";
	
	
	public static Connection getConnection() throws SQLException{
		
		
		String url = "jdbc:mysql://localhost/task";
			
				Connection conn = DriverManager.getConnection(url,USER,PASSWORD);
				return conn;
	}
	
	
}
