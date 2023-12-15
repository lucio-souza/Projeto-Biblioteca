package application;

import java.sql.SQLException;
import DAO.ClienteDao;
import controller.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ViewClientes {
		private Controller controller;
		String cssFile = getClass().getResource("style.css").toExternalForm();
		
		public ViewClientes(Stage stage) {
			GridPane gridPane = new GridPane();
	        gridPane.setVgap(10);
	        gridPane.setHgap(10);
	        
	        Label labelTexto=new Label("Clientes");
	    	GridPane.setConstraints(labelTexto, 0,1);
	    	labelTexto.setId("Titulo-Clientes");

	    	Label labelCpf = new Label("CPF:");
	    	GridPane.setConstraints(labelCpf, 1, 4);
	    	labelCpf.getStyleClass().add("label-Cliente");
	    	labelCpf.setId("cliente-cpf");
	    	
	    	Label labelTelefone = new Label("Telefone:");
	    	GridPane.setConstraints(labelTelefone, 1, 6);
	    	labelTelefone.getStyleClass().add("label-Cliente");
	    	
	    	Label labelNome = new Label("nome:");
	    	GridPane.setConstraints(labelNome, 1, 5);
	    	labelNome.getStyleClass().add("label-Cliente");
	    	labelNome.setId("cliente-nome");
	    	
	    	TextField campoCpf = new TextField();
	    	GridPane.setConstraints(campoCpf, 2, 4);
	    	campoCpf.getStyleClass().add("campo-Cliente");

	    	TextField campoTelefone = new TextField();
	    	GridPane.setConstraints(campoTelefone, 2, 5);
	    	campoTelefone.getStyleClass().add("campo-Cliente");
	    	
	    	TextField campoNome =new TextField();
	    	GridPane.setConstraints(campoNome, 2, 6);
	    	campoNome.getStyleClass().add("campo-Cliente");
	    	
	    	Button botaoCriar= new Button("Criar Cliente");
	    	botaoCriar.setId("criar-cliente");
	    	botaoCriar.setOnAction(e -> {
	    		if(!campoCpf.getText().isEmpty() && !campoTelefone.getText().isEmpty() && !campoNome.getText().isEmpty()) {
	        	    String cpf = campoCpf.getText();
	        	    String Telefone=campoTelefone.getText();
	        	    String nome=campoNome.getText();
	        	    
	        	    boolean verificador=controller.CriarCliente(cpf, Telefone,nome);
	        	    if(verificador==true) {
	        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                	Label labelInvalid=new Label("Cliente criado com sucesso");
	                    labelInvalid.getStyleClass().add("erro-Cliente");
	                    GridPane.setConstraints(labelInvalid, 0, 0);
	                    gridPane.getChildren().add(labelInvalid);
	        	    }else {
	        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                	Label labelInvalid=new Label("Erro ao criar cliente");
	                    labelInvalid.getStyleClass().add("erro-Cliente");
	                    GridPane.setConstraints(labelInvalid, 0, 0);
	                    gridPane.getChildren().add(labelInvalid);
	        	    }
	        }else {
	        	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	        	Label labelInvalid=new Label("Erro:campos em branco");
	            labelInvalid.getStyleClass().add("erro-Cliente");
	            GridPane.setConstraints(labelInvalid, 0, 0);
	            gridPane.getChildren().add(labelInvalid);
	        }

	    	});
	    	GridPane.setConstraints(botaoCriar, 0, 1);
	        
	        Button btnVoltar = new Button("Voltar");
	        btnVoltar.getStyleClass().add("botao-voltar");
	        btnVoltar.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnVoltar, 0, 1);
	        
	        Button btnAll= new Button("Mostrar Clientes");
	    	btnAll.setId("botao-Mostrar-Clientes");
	        btnAll.setOnAction(e -> {
	        	ClienteDao cliente=new ClienteDao();
	        	try {
					System.out.println(cliente.getAll().toString());
	        	}catch (SQLException e1) {
					e1.printStackTrace();
				}
	        });
	        
	        GridPane.setConstraints(btnAll, 0, 2);
	        
	        Button btnDelete = new Button("Delete");
	        btnDelete.setId("deletar-Cliente");
	        btnDelete.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnDelete, 0, 1);

	        gridPane.getChildren().addAll(labelTexto,labelCpf, labelTelefone,labelNome, campoCpf, campoTelefone,campoNome, botaoCriar,btnVoltar,btnAll,btnDelete);

	        Scene scene = new Scene(gridPane, 700, 500);
	        scene.getStylesheets().add(cssFile);
	        stage.setScene(scene);
	    }
	    public void setController(Controller controller) {
	        this.controller = controller;
	    }
	    public void mostrar(Stage stage) {
	    	GridPane gridPane = new GridPane();
	    	gridPane.setVgap(10);
	    	gridPane.setHgap(10);

	    	Label labelTexto=new Label("Clientes");
	    	GridPane.setConstraints(labelTexto, 0,1);
	    	labelTexto.setId("Titulo-Clientes");

	    	Label labelCpf = new Label("CPF:");
	    	GridPane.setConstraints(labelCpf, 1, 4);
	    	labelCpf.getStyleClass().add("label-Cliente");
	    	labelCpf.setId("cliente-cpf");
	    	
	    	Label labelTelefone = new Label("Telefone:");
	    	GridPane.setConstraints(labelTelefone, 1, 6);
	    	labelTelefone.getStyleClass().add("label-Cliente");
	    	
	    	Label labelNome = new Label("nome:");
	    	GridPane.setConstraints(labelNome, 1, 5);
	    	labelNome.getStyleClass().add("label-Cliente");
	    	labelNome.setId("cliente-nome");
	    	
	    	TextField campoCpf = new TextField();
	    	GridPane.setConstraints(campoCpf, 2, 3);
	    	campoCpf.getStyleClass().add("campo-Cliente");

	    	TextField campoTelefone = new TextField();
	    	GridPane.setConstraints(campoTelefone, 2, 4);
	    	campoTelefone.getStyleClass().add("campo-Cliente");
	    	
	    	TextField campoNome =new TextField();
	    	GridPane.setConstraints(campoNome, 2, 5);
	    	campoNome.getStyleClass().add("campo-Cliente");

	    	Button botaoCriar= new Button("Criar Cliente");
	    	botaoCriar.setId("criar-cliente");
	    	botaoCriar.setOnAction(e -> {
	    		if(!campoCpf.getText().isEmpty() && !campoTelefone.getText().isEmpty() && !campoNome.getText().isEmpty()) {
	        	    String cpf = campoCpf.getText();
	        	    String Telefone=campoTelefone.getText();
	        	    String nome=campoNome.getText();
	        	    
	        	    boolean verificador=controller.CriarCliente(cpf, Telefone,nome);
	        	    if(verificador==true) {
	        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                	Label labelInvalid=new Label("Cliente criado com sucesso");
	                    labelInvalid.getStyleClass().add("sucesso-Cliente");
	                    GridPane.setConstraints(labelInvalid, 0, 0);
	                    gridPane.getChildren().add(labelInvalid);
	        	    }else {
	        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                	Label labelInvalid=new Label("Erro ao criar cliente");
	                    labelInvalid.getStyleClass().add("erro-Cliente");
	                    GridPane.setConstraints(labelInvalid, 0, 0);
	                    gridPane.getChildren().add(labelInvalid);
	        	    }
	        }else {
	        	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	        	Label labelInvalid=new Label("Erro:campos em branco");
	            labelInvalid.getStyleClass().add("erro-Cliente");
	            GridPane.setConstraints(labelInvalid, 0, 0);
	            gridPane.getChildren().add(labelInvalid);
	        }

	    	});
	    	GridPane.setConstraints(botaoCriar, 0, 1);
	        
	        Button btnVoltar = new Button("Voltar");
	        btnVoltar.getStyleClass().add("botao-voltar");
	        btnVoltar.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnVoltar, 0, 1);
	        
	        Button btnAll= new Button("Mostrar Clientes");
	    	btnAll.setId("botao-Mostrar-Clientes");
	        btnAll.setOnAction(e -> {
	        	ClienteDao cliente=new ClienteDao();
	        	try {
					System.out.println(cliente.getAll().toString());
	        	}catch (SQLException e1) {
					e1.printStackTrace();
				}
	        });
	        GridPane.setConstraints(btnAll, 0, 2);
	        
	        Button btnDelete = new Button("Delete");
	        btnDelete.setId("deletar-Cliente");
	        btnDelete.setOnAction(e -> controller.mostrarTelaDeleteCliente(stage));
	        GridPane.setConstraints(btnDelete, 0, 1);

	        gridPane.getChildren().addAll(labelTexto,labelCpf, labelTelefone,labelNome, campoCpf, campoTelefone,campoNome, botaoCriar,btnVoltar,btnAll,btnDelete);

	        Scene scene = new Scene(gridPane, 700, 500);
	        scene.getStylesheets().add(cssFile);
	        stage.setScene(scene);
	    }
	}
