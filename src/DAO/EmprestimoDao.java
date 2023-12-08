package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import model.Emprestimo;

import java.time.LocalDate;
public class EmprestimoDao {
	
	public List<Emprestimo> getAll(){
		String sql="select * from Emprestimo";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;
		List<Emprestimo> emprestimos=new ArrayList<>();
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			rset=pstm.executeQuery();
			
			while(rset.next()) {
				int cliente=rset.getInt("idcliente");
				int livro=rset.getInt("idlivro");
				java.sql.Date dtreservaSql=rset.getDate("dtreserva");
				java.sql.Date dtentregaSql=rset.getDate("dtentrega");
				LocalDate dtreserva = (dtreservaSql != null) ? dtreservaSql.toLocalDate() : null;
				LocalDate dtentrega = (dtentregaSql != null) ? dtentregaSql.toLocalDate() : null;
				Emprestimo emprestimo=new Emprestimo(cliente,livro,dtreserva);
				emprestimo.setId(rset.getInt("id"));
				emprestimo.setDtEntrega(dtentrega);
				emprestimos.add(emprestimo);
			}
			conn.close();
			pstm.close();
			rset.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return emprestimos;
	}

	public Emprestimo getOneById(int id) throws SQLException{
		String sql="select * from Emprestimo where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset=pstm.executeQuery();
			
			if(rset.next()) {
				int cliente=rset.getInt("idcliente");
				int livro=rset.getInt("idlivro");
				java.sql.Date dtreserva=rset.getDate("dtreserva");
				java.sql.Date dtentrega=rset.getDate("dtentrega");
				Emprestimo emprestimo=new Emprestimo(cliente,livro,dtreserva.toLocalDate());
				emprestimo.setId(rset.getInt("id"));
				emprestimo.setDtEntrega(dtentrega.toLocalDate());
				return emprestimo;
			}
			conn.close();
			pstm.close();
			rset.close();
		return null;
	}
	
	public void Emprestar(Emprestimo emprestimo) throws SQLException{
		String sql="insert into Emprestimo(idcliente,idlivro,dtreserva,dtentrega)values(?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			if(LivroDao.getOneByID(emprestimo.getIdLivro()).getStatus().equals("Disponivel") || LivroDao.getOneByID(emprestimo.getIdLivro()).getStatus().equals("disponivel")) {
				try {
					conn=ConexaoDAO.conectarBD();
					pstm=conn.prepareStatement(sql);
					pstm.setInt(1, emprestimo.getIdCliente());
					pstm.setInt(2, emprestimo.getIdLivro());
					pstm.setObject(3, emprestimo.getDtReserva());
					pstm.setObject(4, emprestimo.getDtentrega());
					pstm.executeUpdate();
					String status="Indisponivel";
					LivroDao livrodao=new LivroDao();
					livrodao.atualizarStatus(emprestimo.getIdLivro(),status);
					conn.close();
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("livro indisponivel");
			}
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql="delete from Emprestimo where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			conn.close();
			pstm.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
