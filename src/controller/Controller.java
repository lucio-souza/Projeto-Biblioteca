package controller;

import java.sql.SQLException;
import application.*;
import javafx.stage.Stage;
import model.Bibliotecario;
import DAO.*;

public class Controller {
    private ViewLogin viewLogin;
    private ViewPrincipal viewPrincipal;

    public Controller(ViewLogin viewLogin, ViewPrincipal viewPrincipal) {
        this.viewLogin = viewLogin;
        this.viewPrincipal = viewPrincipal;

        // Configurar o controlador nas visões
        this.viewLogin.setController(this);
        this.viewPrincipal.setController(this);
    }

    
    public void iniciar() {
    	Stage stage=new Stage();
        viewLogin.mostrar(stage);
    }

    public void realizarAutenticacao(String email, int senha,Stage stage) {
        if (autenticarUsuario(email, senha)) {
            viewPrincipal.mostrar(new Bibliotecario(email, senha));
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

    public void mostrarTelaEmprestimos() {
        // Lógica para mostrar a tela de empréstimos
        System.out.println("Mostrar tela de Empréstimos");
    }

    public void mostrarTelaLivros() {
        // Lógica para mostrar a tela de livros
        System.out.println("Mostrar tela de Livros");
    }

    public void mostrarTelaClientes() {
        // Lógica para mostrar a tela de clientes
        System.out.println("Mostrar tela de Clientes");
    }

    public void mostrarTelaUsuarios() {
        // Lógica para mostrar a tela de usuários
        System.out.println("Mostrar tela de Usuários");
    }
}