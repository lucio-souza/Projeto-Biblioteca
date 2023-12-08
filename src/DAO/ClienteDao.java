package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Cliente;

public class ClienteDao {
	
	@SuppressWarnings("finally")
	public List<Cliente> getAll(){
		String sql="select * from Cliente";
		List<Cliente> clientes=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			rset=pstm.executeQuery();
			
			while(rset.next()) {
				String cpf=rset.getString("cpf");
				String nome=rset.getString("nome");
				String telefone=rset.getString("telefone");
				Cliente cliente=new Cliente(nome,cpf,telefone);
				cliente.setId(rset.getInt("id"));
				clientes.add(cliente);
			}
			conn.close();
			pstm.close();
			rset.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally{
			return clientes;
		}
	}
	
	public Cliente getOneById(int id) {
		String sql="select * from Cliente where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rset=null;

		try {		
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset=pstm.executeQuery();
			if(rset.next()) {
				String nome=rset.getString("nome");
				String telefone=rset.getString("telefone");
				String cpf=rset.getString("cpf");
				Cliente cliente=new Cliente(nome,telefone,cpf);
				cliente.setId(rset.getInt("id"));
				return cliente;
			}
			conn.close();
			pstm.close();
			rset.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public void create(Cliente cliente) {
		String sql="insert into Cliente(cpf,nome,telefone) values(?,?,?)";
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getTelefone());
			pstm.execute();
			conn.close();
			pstm.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql="delete from Cliente where id = ?";
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
	
	public void update(Cliente cliente) {
		String sql="update Cliente set cpf=?,nome=?,telefone=? where id=?";
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn=ConexaoDAO.conectarBD();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getTelefone());
			pstm.setInt(4, cliente.getId());
			pstm.executeUpdate();
			conn.close();
			pstm.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}