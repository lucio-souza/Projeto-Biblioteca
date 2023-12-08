package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import model.Livro;

public class LivroDao {
	
	@SuppressWarnings("finally")
	public List<Livro> getAll()throws SQLException {
		
		String sql=("select * from Livro");
		List<Livro> livros=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			rset=pstm.executeQuery();
			
			while(rset.next()) {
				String titulo=rset.getString("titulo");
				java.sql.Date sqlDate=rset.getDate("dtpublicacao");
				String genero=rset.getString("genero");
				String status=rset.getString("status");
				String autor=rset.getString("autor");			
				Livro livro=new Livro(titulo,sqlDate.toLocalDate(),genero,autor,status);
				livro.setId(rset.getInt("id"));
				livros.add(livro);
			}
			conn.close();
			pstm.close();
			rset.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			return livros;
		}
	}
	
	public static Livro getOneByID(int id)throws SQLException{
		
		String sql="select * from Livro where id = ?";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;
		
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset=pstm.executeQuery();
			if(rset.next()) {
				String titulo=rset.getString("titulo");
				java.sql.Date sqlDate=rset.getDate("dtpublicacao");
				String genero=rset.getString("genero");
				String status=rset.getString("status");
				String autor=rset.getString("autor");			
				Livro livro=new Livro(titulo,sqlDate.toLocalDate(),genero,autor,status);
				livro.setId(rset.getInt("id"));
				conn.close();
				pstm.close();
				rset.close();
				return livro;
			}

		return null;
	}
	
	public void create(Livro livro) throws SQLIntegrityConstraintViolationException,SQLException{
		String sql="insert into Livro(titulo,dtPublicacao,genero,autor) values(?,?,?,?)";

		Connection conn=null;
		PreparedStatement pstm=null;
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			
			pstm.setString(1, livro.getTitulo());
			pstm.setObject(2, livro.getDtPubli());
			pstm.setString(3, livro.getGenero());
			pstm.setString(4, livro.getAutor());
			pstm.execute();
			conn.close();
			pstm.close();
	}
	
	public void delete(int id) throws SQLException{
		String sql="delete from Livro where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			conn.close();
			pstm.close();
	}
	
	public void atualizarStatus(int id,String status) throws SQLIntegrityConstraintViolationException,SQLException{
		String sql="update Livro set status=? where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=ConexaoDAO.conectarBD();
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,status);	
		pstm.setInt(2, id);
		pstm.executeUpdate();
		conn.close();
		pstm.close();
	}
	
	public void Update(Livro livro) throws SQLIntegrityConstraintViolationException,SQLException{
		String sql="update Livro set titulo=?, dtPublicacao=?, genero=?, status=?, autor=? where id=?";
		
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=ConexaoDAO.conectarBD();
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, livro.getTitulo());
		pstm.setObject(2,livro.getDtPubli());
		pstm.setString(3, livro.getGenero());
		pstm.setString(4, livro.getStatus());;
		pstm.setString(5, livro.getAutor());
		pstm.setInt(6, livro.getId());
		pstm.executeUpdate();
		conn.close();
		pstm.close();

	}
}
