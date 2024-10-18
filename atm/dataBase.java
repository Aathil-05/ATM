package atm;
import java.sql.*;

public class dataBase {
	
	private static String url = "jdbc:mysql://localhost:3306/atm";
	private static String userName = "root";
	private static String pass = "2005";
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, userName, pass);
	}

}
