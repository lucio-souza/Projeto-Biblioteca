package DAO;

import model.Bibliotecario;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class BibliotecarioDao {
	

	public List<Bibliotecario> getAll() throws SQLException{
		String sql="select * from Bibliotecario";
		List<Bibliotecario> bibliotecarios=new ArrayList<>();
		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rset=pstm.executeQuery();
			
		while(rset.next()) {
			String email=rset.getString("email");
			int senha=rset.getInt("senha");
			Bibliotecario bibliotecario=new Bibliotecario(email,senha);
			bibliotecario.setId(rset.getInt("Id"));
			bibliotecarios.add(bibliotecario);
		}
		conn.close();
		pstm.close();
		return bibliotecarios;
	}
	
	public Bibliotecario getOneById(int id) throws SQLException{
		String sql="select * from Bibliotecario where id=?";
		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.setInt(1, id);
		ResultSet rset=pstm.executeQuery();

		if(rset.next()) {
			String email=rset.getString("email");
			int senha=rset.getInt("senha");
			Bibliotecario bibliotecario=new Bibliotecario(email,senha);
			bibliotecario.setId(rset.getInt("Id"));
			return bibliotecario;
		}
		conn.close();
		pstm.close();
		rset.close();
		return null;
	}
	
	public void delete(int id)throws SQLException {
		String sql="delete from Bibliotecario where id=?";
		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.setInt(1, id);
		pstm.execute();
		conn.close();
		pstm.close();
	}
	
	public void create(Bibliotecario bibliotecario)throws SQLException{
		String sql="insert into Bibliotecario(email,senha) values(?,?)";
		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.setString(1, bibliotecario.getEmail());
		pstm.setInt(2, bibliotecario.getSenha());
		pstm.execute();
		conn.close();
		pstm.close();
	}
	
	public void update(Bibliotecario bibliotecario)throws SQLIntegrityConstraintViolationException,SQLException{
		String sql="update Bibliotecario set email=?,senha=? where id=?";
		Connection conn=ConexaoDAO.conectarBD();
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1,bibliotecario.getEmail());
		pstm.setInt(2, bibliotecario.getSenha());
		pstm.setInt(3, bibliotecario.getId());
		pstm.executeUpdate();
		conn.close();
		pstm.close();
	}
}