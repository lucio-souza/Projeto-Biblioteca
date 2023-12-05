package DAO;

import model.Bibliotecario;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BibliotecarioDao {
	
	@SuppressWarnings("finally")
	public List<Bibliotecario> getAll(){
		String sql="select * from Bibliotecario";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;
		List<Bibliotecario> bibliotecarios=new ArrayList<>();
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			rset=pstm.executeQuery();
			
			while(rset.next()) {
				Bibliotecario bibliotecario=new Bibliotecario();
				bibliotecario.setId(rset.getInt("id"));
				bibliotecario.setEmail(rset.getString("email"));
				bibliotecario.setSenha(rset.getInt("senha"));
				bibliotecarios.add(bibliotecario);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			return bibliotecarios;
		}
	}
	
	public Bibliotecario getOneById(int id) {
		String sql="select * from Bibliotecario where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;

		try {		
			Bibliotecario bibliotecario=new Bibliotecario();
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset=pstm.executeQuery();

			if(rset.next()) {
				bibliotecario.setId(rset.getInt("Id"));
				bibliotecario.setEmail(rset.getString("email"));
				bibliotecario.setSenha(rset.getInt("senha"));
			}
			return bibliotecario;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void delete(int id) {
		String sql="delete from Bibliotecario where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			conn.close();
			pstm.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void create(Bibliotecario bibliotecario){
		String sql="insert into Cliente(email,senha) values(?,?)";
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, bibliotecario.getEmail());
			pstm.setInt(2, bibliotecario.getSenha());
			pstm.execute();
			conn.close();
			pstm.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void update(Bibliotecario bibliotecario) {
		String sql="update Livro set email=?,senha=? where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,bibliotecario.getEmail());
			pstm.setInt(2, bibliotecario.getSenha());
			pstm.setInt(3, bibliotecario.getId());
			pstm.executeUpdate();
			conn.close();
			pstm.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}