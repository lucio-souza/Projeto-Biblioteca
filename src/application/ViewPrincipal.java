package application;
import controller.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
	public class ViewPrincipal {
	    private Controller controller;
		String cssFile = getClass().getResource("style.css").toExternalForm();

	    public ViewPrincipal(Stage stage) {
	        GridPane gridPane = new GridPane();
	        gridPane.setVgap(10);
	        gridPane.setHgap(10);
	        
	        Label labelTexto=new Label("BIBLIOTECA");
	        GridPane.setConstraints(labelTexto, 0, 0);
	        labelTexto.setId("label-view-principal");

	        Button btnEmprestimos = new Button("Empréstimos");
	        btnEmprestimos.setOnAction( e -> controller.mostrarTelaEmprestimos(stage));
	        GridPane.setConstraints(btnEmprestimos, 0, 0);
	        btnEmprestimos.setId("botao-Emprestimo");
	        btnEmprestimos.getStyleClass().add("botao-view-principal");

	        Button btnLivros = new Button("Livros");
	        btnLivros.setOnAction(e -> controller.mostraTelaLivros(stage));
	        GridPane.setConstraints(btnLivros, 1, 0);
	        btnLivros.getStyleClass().add("botao-view-principal");
	        btnLivros.setId("botao-Livro");

	        Button btnClientes = new Button("Clientes");
	        btnClientes.setOnAction(e -> controller.mostrarTelaClientes(stage));
	        GridPane.setConstraints(btnClientes, 0, 1);
	        btnClientes.getStyleClass().add("botao-view-principal");
	        btnClientes.setId("botao-Cliente");

	        Button btnUsuarios = new Button("Usuários");
	        btnUsuarios.setOnAction(e -> controller.mostrarTelaUsuarios(stage));
	        GridPane.setConstraints(btnUsuarios, 1, 1);
	        btnUsuarios.getStyleClass().add("botao-view-principal");
	        btnUsuarios.setId("botao-Usuario");
	        
	        gridPane.getChildren().addAll(labelTexto,btnEmprestimos,btnLivros,btnClientes,btnUsuarios);
	        Scene scene = new Scene(gridPane, 700, 500);
	        scene.getStylesheets().add(cssFile);
	        stage.setScene(scene);
	        stage.show();
	    }

	    public void setController(Controller controller) {
	        this.controller = controller;
	    }

	    public void mostrar() {
	        Stage stage = new Stage();
	        stage.show();
	        GridPane gridPane = new GridPane();
	        gridPane.setVgap(10);
	        gridPane.setHgap(10);
	        
	        Label labelTexto=new Label("BIBLIOTECA");
	        GridPane.setConstraints(labelTexto, 0, 0);
	        labelTexto.setId("label-view-principal");
	        
	        Button btnEmprestimos = new Button("Empréstimos");
	        btnEmprestimos.setOnAction(e -> controller.mostrarTelaEmprestimos(stage));
	        GridPane.setConstraints(btnEmprestimos, 0, 0);
	        btnEmprestimos.getStyleClass().add("botao-view-principal");

	        Button btnLivros = new Button("Livros");
	        btnLivros.setOnAction(e -> controller.mostraTelaLivros(stage));
	        GridPane.setConstraints(btnLivros, 1, 0);
	        btnLivros.getStyleClass().add("botao-view-principal");
	        btnLivros.setId("botao-Livro");

	        Button btnClientes = new Button("Clientes");
	        btnClientes.setOnAction(e -> controller.mostrarTelaClientes(stage));
	        GridPane.setConstraints(btnClientes, 0, 1);
	        btnClientes.getStyleClass().add("botao-view-principal");
	        btnClientes.setId("botao-Cliente");

	        Button btnUsuarios = new Button("Usuários");
	        btnUsuarios.setOnAction(e -> controller.mostrarTelaUsuarios(stage));
	        GridPane.setConstraints(btnUsuarios, 1, 1);
	        btnUsuarios.getStyleClass().add("botao-view-principal");
	        btnUsuarios.setId("botao-Usuario");
	        
	        gridPane.getChildren().addAll(labelTexto,btnEmprestimos,btnLivros,btnClientes,btnUsuarios);
	        Scene scene = new Scene(gridPane, 700, 500);
	        scene.getStylesheets().add(cssFile);
	        stage.setScene(scene);
	        stage.show();
	    }
	}