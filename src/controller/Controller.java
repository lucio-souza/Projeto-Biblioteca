package controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import application.*;
import javafx.stage.Stage;
import model.Bibliotecario;
import model.Cliente;
import DAO.*;

public class Controller {
    private ViewLogin viewLogin;
    private ViewPrincipal viewPrincipal;
    private ViewEmprestimos viewEmprestimo;
    private ViewClientes viewClientes;
    private ViewLivros viewLivros;
    private ViewUsuario viewUsuario;
    private DeleteCliente deleteCliente;
    private DeleteLivro deleteLivro;
    private DeleteUsuario deleteUsuario;
    
    public Controller(ViewLogin viewLogin, ViewPrincipal viewPrincipal,ViewEmprestimos viewEmprestimo,ViewClientes viewClientes,ViewLivros viewLivros,ViewUsuario viewUsuario,DeleteCliente deleteCliente,DeleteLivro deleteLivro,DeleteUsuario deleteUsuario) {
        this.viewLogin = viewLogin;
        this.viewPrincipal = viewPrincipal;
        this.viewEmprestimo=viewEmprestimo;
        this.viewClientes=viewClientes;
        this.viewLivros=viewLivros;
        this.viewUsuario=viewUsuario;
        this.deleteLivro=deleteLivro;
        this.deleteCliente=deleteCliente;
        this.deleteUsuario=deleteUsuario;
        
        this.deleteCliente.setController(this);
        this.deleteLivro.setController(this);
        this.deleteUsuario.setController(this);
        this.viewLogin.setController(this);
        this.viewPrincipal.setController(this);
        this.viewEmprestimo.setController(this);
        this.viewClientes.setController(this);
        this.viewLivros.setController(this);
        this.viewUsuario.setController(this);
    }

    
    public void iniciar() {
    	Stage stage=new Stage();
        viewLogin.mostrar(stage);
    }

    public void realizarAutenticacao(String email, int senha,Stage stage) {
        if (autenticarUsuario(email, senha)) {
            viewPrincipal.mostrar();
        } else {
            System.out.println("usuario invalido");
        }
    }

    private boolean autenticarUsuario(String email, int senha) {
    	BibliotecarioDao b =new BibliotecarioDao();
    	try {
    	Bibliotecario bi=b.getOneByemail(email);
        if(bi != null && bi.getSenha()==senha) {
        	return true;
        }
    	}catch(SQLException ex) {
    		ex.printStackTrace();
    	}
    	return false;
    }
    public void VoltarTela() {
    	viewPrincipal.mostrar();
    }
    public boolean FazerEmprestimo(String Cpf,String Titulo) {
        EmprestimoDao emprestimo=new EmprestimoDao();
        try {
			boolean verificador=emprestimo.emprestar(Cpf, Titulo);
			return verificador;
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return false;
    }
    
    public boolean CriarCliente(String cpf,String nome,String telefone) {
    	ClienteDao cliente=new ClienteDao();
    	try {
			cliente.create(new Cliente(cpf, nome, telefone));
			return true;
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("já existe um cliente com esse cpf");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }
    public void mostrarTelaEmprestimos(Stage stage) {
	viewEmprestimo.mostrar(stage);
    }

    public void mostrarTelaClientes(Stage stage) {
        viewClientes.mostrar(stage);
    }
    
    public void mostraTelaLivros(Stage stage) {
    	viewLivros.mostrar(stage);
    }

    public void mostrarTelaUsuarios(Stage stage) {
    	viewUsuario.mostrar(stage);
    }
    public void mostrarTelaDeleteCliente(Stage stage) {
    	deleteCliente.mostrar(stage);
    }
}