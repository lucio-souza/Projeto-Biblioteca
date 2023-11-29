package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexaoDAO {
	
	public Connection conectarBD() {
		Connection conn=null;
		try {
			String url="jdbc:mysql://localhost:3306/ProjetoBiblioteca?user=root&password=a1b2c3d4";
			conn=DriverManager.getConnection(url);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
