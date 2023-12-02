package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import model.Livro;
public class LivroDao {
	
	@SuppressWarnings("finally")
	public List<Livro> getAll() {
		
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
				Livro livro=new Livro();
				livro.setId(rset.getInt("id"));
				livro.setTitulo(rset.getString("titulo"));
				livro.setDtPubli(rset.getDate("dtpublicacao"));
				livro.setGenero(rset.getString("genero"));
				livro.setStatus(rset.getString("status"));
				livro.setAutor(rset.getString("autor"));
				
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
	
	public void create(Livro livro) {
		String sql=("insert into Livro(titulo,dtPublicacao,genero,autor) values(?,?,?,?);");

		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			
			//adciona valores na query
			pstm.setString(1, livro.getTitulo());
			pstm.setDate(2, new Date(livro.getDtPubli().getTime()));
			pstm.setString(3, livro.getGenero());
			pstm.setString(4, livro.getAutor());
			
			pstm.execute();
			conn.close();
			pstm.close();
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("livro já existente");
		}catch(SQLException ex) {
			ex.printStackTrace();	
		}
	}
}
