package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;
import model.Cliente;

public class ClienteDao {
	
	public List<Cliente> getAll()throws SQLException{
		String sql="select * from Cliente";
		List<Cliente> clientes=new ArrayList<>();
		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rset=pstm.executeQuery();
			
		while(rset.next()) {
			String cpf=rset.getString("cpf");
			String nome=rset.getString("nome");
			String telefone=rset.getString("telefone");
			Cliente cliente=new Cliente(cpf,nome,telefone);
			cliente.setId(rset.getInt("id"));
			clientes.add(cliente);
		}
		conn.close();
		pstm.close();
		rset.close();	
		return clientes;
	}
	
	public Cliente getOneById(int id) throws SQLException{
		String sql="select * from Cliente where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;
		
		conn=ConexaoDAO.conectarBD();
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rset=pstm.executeQuery();
		
		if(rset.next()) {
			String nome=rset.getString("nome");
			String telefone=rset.getString("telefone");
			String cpf=rset.getString("cpf");
			Cliente cliente=new Cliente(cpf,nome,telefone);
			cliente.setId(rset.getInt("id"));
			return cliente;
		}
		conn.close();
		pstm.close();
		rset.close();
		return null;
	}
	
	public static Cliente getOneByCpf(String cpf) throws SQLException{
		String sql="select * from Cliente where cpf=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;
		
		conn=ConexaoDAO.conectarBD();
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, cpf);
		rset=pstm.executeQuery();
		
		if(rset.next()) {
			rset.getString("cpf");
			String nome=rset.getString("nome");
			String telefone=rset.getString("telefone");
			
			Cliente cliente=new Cliente(cpf,nome,telefone);
			cliente.setId(rset.getInt("id"));
			return cliente;
		}
		conn.close();
		pstm.close();
		rset.close();
		return null;
	}
	
	public void create(Cliente cliente) throws SQLIntegrityConstraintViolationException,SQLException{
		String sql="insert into Cliente(cpf,nome,telefone) values(?,?,?)";
		Connection conn=null;
		PreparedStatement pstm=null;

		conn=ConexaoDAO.conectarBD();
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, cliente.getCpf());
		pstm.setString(2, cliente.getNome());
		pstm.setString(3, cliente.getTelefone());
		pstm.execute();
		conn.close();
		pstm.close();
	}
	
	public void delete(int id) throws SQLException{
		String sql="delete from Cliente where id = ?";
		Connection conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.setInt(1, id);
		pstm.execute();
		conn.close();
		pstm.close();
	}
	
	public void update(Cliente cliente) throws SQLIntegrityConstraintViolationException,SQLException{
		String sql="update Cliente set cpf=?,nome=?,telefone=? where id=?";
		
		Connection 	conn=ConexaoDAO.conectarBD();
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.setString(1, cliente.getCpf());
		pstm.setString(2, cliente.getNome());
		pstm.setString(3, cliente.getTelefone());
		pstm.setInt(4, cliente.getId());
		pstm.executeUpdate();
		conn.close();
		pstm.close();
	}
}
