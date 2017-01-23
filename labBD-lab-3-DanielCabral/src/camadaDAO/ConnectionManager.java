package camadaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String server = "localhost";
	private static final String dataBaseName = "contabancaria";
	private static final String user = "root";
	private static final String pw = "root";
	private static Connection conn = null;

	public Connection connect(){
		if (conn == null){
			try{
				Class.forName(driver);
				return conn =  DriverManager.getConnection("jdbc:mysql://" + server + "/" + dataBaseName, user, pw);
			}
			catch (ClassNotFoundException e){
				e.printStackTrace();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return conn;
	}
}
