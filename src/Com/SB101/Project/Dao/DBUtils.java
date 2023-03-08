package Com.SB101.Project.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	static String url;
	static String user;
	static String password;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ResourceBundle bundle = ResourceBundle.getBundle("details");
			url = bundle.getString("url");
			user = bundle.getString("user");
			password = bundle.getString("password");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection connectToDatabase() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	public static void closeConnection(Connection c) throws SQLException{
		if(c!=null)
			c.close();
	}
}
