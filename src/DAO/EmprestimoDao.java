package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.Cliente;
import model.Emprestimo;
import model.Livro;

import java.time.LocalDate;
public class EmprestimoDao {
	
	public List<Emprestimo> getAll()throws SQLException{
		String sql="select * from Emprestimo";

		List<Emprestimo> emprestimos=new ArrayList<>();

		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rset=pstm.executeQuery();
			
		while(rset.next()) {
			int cliente=rset.getInt("idcliente");
			int livro=rset.getInt("idlivro");
			java.sql.Date dtreserva=rset.getDate("dtreserva");
			java.sql.Date dtentregaSql=rset.getDate("dtentrega");
			String status=rset.getString("status");
			LocalDate dtentrega = (dtentregaSql != null) ? dtentregaSql.toLocalDate() : null;
			Emprestimo emprestimo=new Emprestimo(cliente,livro,dtreserva.toLocalDate());
			emprestimo.setId(rset.getInt("id"));
			emprestimo.setStatus(status);
			emprestimo.setDtEntrega(dtentrega);
			emprestimos.add(emprestimo);
		}
		conn.close();
		pstm.close();
		rset.close();

		return emprestimos;
	}

	public Emprestimo getOneById(int id) throws SQLException{
		String sql="select * from Emprestimo where id=?";

		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rset=pstm.executeQuery();
			
		if(rset.next()) {
			int cliente=rset.getInt("idcliente");
			int livro=rset.getInt("idlivro");
			java.sql.Date dtreserva=rset.getDate("dtreserva");
			java.sql.Date dtentregaSql=rset.getDate("dtentrega");
			String status=rset.getString("status");
			LocalDate dtentrega = (dtentregaSql != null) ? dtentregaSql.toLocalDate() : null;
			Emprestimo emprestimo=new Emprestimo(cliente,livro,dtreserva.toLocalDate());
			emprestimo.setId(rset.getInt("id"));
			emprestimo.setStatus(status);
			emprestimo.setDtEntrega(dtentrega);
			return emprestimo;
		}
		conn.close();
		pstm.close();
		rset.close();
		return null;
	}
	
    public boolean verificarEmprestimoPendente(int idCliente) throws SQLException {
        String sql = "SELECT id FROM Emprestimo WHERE idCliente = ? AND (status = 'Em andamento' OR status = 'Atrasado')";

        Connection conn = ConexaoDAO.conectarBD();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idCliente);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
	
	public boolean emprestar(String cpf,String titulo) throws NullPointerException,SQLIntegrityConstraintViolationException,SQLException{

	    Cliente cliente = ClienteDao.getOneByCpf(cpf);
	    Livro livro = LivroDao.getOneByTitulo(titulo);
		String sql="insert into Emprestimo(idcliente,idlivro,dtreserva,dtentrega)values(?,?,?,?)";
		if(cliente!=null && livro!=null) {
		int idCliente=ClienteDao.getOneByCpf(cpf).getId();
		int idLivro=LivroDao.getOneByTitulo(titulo).getId();
		
		if(!verificarEmprestimoPendente(idCliente)) {
			if(LivroDao.getOneByID(idLivro).getStatus().equals("disponivel")){
				Connection conn=ConexaoDAO.conectarBD();
				PreparedStatement pstm=conn.prepareStatement(sql);
				Emprestimo emprestimo=new Emprestimo(idCliente,idLivro,LocalDate.now());
				
				pstm.setInt(1, idCliente);
				pstm.setInt(2, idLivro);
				pstm.setObject(3, emprestimo.getDtReserva());
				pstm.setObject(4, emprestimo.getDtentrega());
				pstm.executeUpdate();
				
				String status="Indisponivel";
				LivroDao livrodao=new LivroDao();
				livrodao.atualizarStatus(emprestimo.getIdLivro(),status);
				conn.close();
				pstm.close();
				return true;
			}else {
				System.out.println("livro indisponivel");
			}
		}else {
			System.out.println("o cliente tem pendências");
		}
		}else {
			System.out.println("cpf ou titulo invalido");
		}
		return false;

	}
	public void devolverLivro(int id) throws SQLException{
		String sql="update Emprestimo set status=? where id=?";
		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
			
		String status="Devolvido";
		pstm.setString(1,status);
		pstm.setInt(2, id);
		pstm.executeUpdate();
			
		String statusLivro="Disponivel";
		LivroDao livroDao=new LivroDao();
		int idLivro=getOneById(id).getId();
		livroDao.atualizarStatus(idLivro, statusLivro);
	}
		
	public void delete(int id) throws SQLException {
		String sql="delete from Emprestimo where id=?";

		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.execute();
		conn.close();
		pstm.close();
	}
}