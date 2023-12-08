package DAO;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConexaoDAO {
	
	public static Connection conectarBD() {
		Connection conn=null;

		try {
			FileInputStream in=new FileInputStream("database.properties");
			Properties props=new Properties();
			props.load(in);
			String url=props.getProperty("url");
			String user=props.getProperty("user");
			String password=props.getProperty("password");
			conn=DriverManager.getConnection(url,user,password);
		}catch(IOException ex) {
			ex.printStackTrace();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
