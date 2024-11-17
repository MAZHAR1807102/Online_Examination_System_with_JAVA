package Connect;

import java.sql.*;



public class ConnectionProvider {

	public static Connection getcon()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			return con;
		}catch(Exception e)
		{
			return null;
		}
	}
}
