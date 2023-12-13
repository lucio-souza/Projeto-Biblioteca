package application;
import controller.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Bibliotecario;
	public class ViewPrincipal {
	    private Controller controller;

	    public ViewPrincipal(Stage stage) {
	        VBox vbox = new VBox(10);

	        Button btnEmprestimos = new Button("Empréstimos");
	        btnEmprestimos.setOnAction(e -> controller.mostrarTelaEmprestimos());
	        vbox.getChildren().add(btnEmprestimos);

	        Button btnLivros = new Button("Livros");
	        btnLivros.setOnAction(e -> controller.mostrarTelaLivros());
	        vbox.getChildren().add(btnLivros);

	        Button btnClientes = new Button("Clientes");
	        btnClientes.setOnAction(e -> controller.mostrarTelaClientes());
	        vbox.getChildren().add(btnClientes);

	        Button btnUsuarios = new Button("Usuários");
	        btnUsuarios.setOnAction(e -> controller.mostrarTelaUsuarios());
	        vbox.getChildren().add(btnUsuarios);

	        Scene scene = new Scene(vbox, 300, 200);
	        stage.setScene(scene);
	    }

	    public void setController(Controller controller) {
	        this.controller = controller;
	    }

	    public void mostrar(Bibliotecario usuario) {
	        Stage stage = new Stage();
	        stage.setTitle("Tela Principal - Bem-vindo " + usuario.getEmail());
	        stage.show();
	        VBox vbox = new VBox(10);

	        Button btnEmprestimos = new Button("Empréstimos");
	        btnEmprestimos.setOnAction(e -> controller.mostrarTelaEmprestimos());
	        vbox.getChildren().add(btnEmprestimos);

	        Button btnLivros = new Button("Livros");
	        btnLivros.setOnAction(e -> controller.mostrarTelaLivros());
	        vbox.getChildren().add(btnLivros);

	        Button btnClientes = new Button("Clientes");
	        btnClientes.setOnAction(e -> controller.mostrarTelaClientes());
	        vbox.getChildren().add(btnClientes);

	        Button btnUsuarios = new Button("Usuários");
	        btnUsuarios.setOnAction(e -> controller.mostrarTelaUsuarios());
	        vbox.getChildren().add(btnUsuarios);

	        Scene scene = new Scene(vbox, 700, 500);
	        stage.setScene(scene);
	    }
	}