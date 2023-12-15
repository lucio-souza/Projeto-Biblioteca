package application;
import java.sql.SQLException;

import DAO.BibliotecarioDao;
import controller.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bibliotecario;
	
public class ViewUsuario {
		private Controller controller;
		String cssFile = getClass().getResource("style.css").toExternalForm();
		
		public ViewUsuario(Stage stage) {
			GridPane gridPane = new GridPane();
	        gridPane.setVgap(10);
	        gridPane.setHgap(10);
	        
	        Label labelTexto=new Label("Usuarios");
	    	GridPane.setConstraints(labelTexto, 0,1);
	    	labelTexto.setId("Titulo-Usuarios");

	    	Label labelEmail= new Label("Email:");
	    	GridPane.setConstraints(labelEmail, 1, 2);
	    	labelEmail.getStyleClass().add("label-Usuario");

	    	Label labelSenha= new Label("Senha:");
	    	GridPane.setConstraints(labelSenha, 1, 3);
	    	labelSenha.getStyleClass().add("label-Usuario");

	    	TextField campoEmail = new TextField();
	    	GridPane.setConstraints(campoEmail, 2, 2);
	    	campoEmail.getStyleClass().add("campo-Usuario");

	    	TextField campoSenha = new TextField();
	    	GridPane.setConstraints(campoSenha, 2, 3);
	    	campoSenha.getStyleClass().add("campo-Usuario");

	    	Button btnUsuario= new Button("Criar Usuario");
	    	btnUsuario.setId("criar-Usuario");
	        btnUsuario.setOnAction(e -> {
	            if(!campoEmail.getText().isEmpty() && !campoSenha.getText().isEmpty()) {
	            	    String email = campoEmail.getText();
	            	    int senha = Integer.parseInt(campoSenha.getText());
	            	    boolean verificador=controller.CriarUsuario(email, senha);
	            	    if(verificador==true) {
	            	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                    	Label labelInvalid=new Label("Usuario criado com sucesso");
	                        labelInvalid.getStyleClass().add("sucesso-Usuario");
	                        GridPane.setConstraints(labelInvalid, 0, 0);
	                        gridPane.getChildren().add(labelInvalid);
	            	    }else {
	            	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                    	Label labelInvalid=new Label("Erro ao criar Usuario");
	                        labelInvalid.getStyleClass().add("erro-Usuario");
	                        GridPane.setConstraints(labelInvalid, 0, 0);
	                        gridPane.getChildren().add(labelInvalid);
	            	    }
	            }else {
	            	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	            	Label labelInvalid=new Label("Erro:campos em branco");
	                labelInvalid.getStyleClass().add("erro-Usuario");
	                GridPane.setConstraints(labelInvalid, 0, 0);
	                gridPane.getChildren().add(labelInvalid);
	            }

	        });
	        GridPane.setConstraints(btnUsuario, 0, 1);
	        
	        Button btnVoltar = new Button("Voltar");
	        btnVoltar.getStyleClass().add("voltar-Usuario");
	        btnVoltar.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnVoltar, 0,1);
	        
	        Button btnAll= new Button("Mostrar Usuarios");
	    	btnAll.setId("Mostrar-Usuario");
	        btnAll.setOnAction(e -> {
	        	try {
	        		BibliotecarioDao usuario=new BibliotecarioDao();
	        		for(Bibliotecario usuarios:usuario.getAll()) {
	        			System.out.println(usuarios.toString());
	        		}
	        	}catch (SQLException e1) {
					e1.printStackTrace();
				}
	        });
	        GridPane.setConstraints(btnAll, 1, 0);
	        
	        Button btnDelete = new Button("Delete");
	        btnDelete.setId("deletar-Usuario");
	        btnDelete.setOnAction(e -> controller.mostrarTelaDeleteUsuario(stage));
	        GridPane.setConstraints(btnDelete, 1, 0);

	        gridPane.getChildren().addAll(labelTexto,labelEmail, labelSenha, campoEmail ,campoSenha, btnUsuario,btnAll,btnVoltar,btnDelete);

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

	    	Label labelTexto=new Label("Usuarios");
	    	GridPane.setConstraints(labelTexto, 0,1);
	    	labelTexto.setId("Titulo-Usuarios");

	    	Label labelEmail= new Label("Email:");
	    	GridPane.setConstraints(labelEmail, 1, 2);
	    	labelEmail.getStyleClass().add("label-Usuario");

	    	Label labelSenha= new Label("Senha:");
	    	GridPane.setConstraints(labelSenha, 1, 3);
	    	labelSenha.getStyleClass().add("label-Usuario");

	    	TextField campoEmail = new TextField();
	    	GridPane.setConstraints(campoEmail, 2, 2);
	    	campoEmail.getStyleClass().add("campo-Usuario");

	    	TextField campoSenha = new TextField();
	    	GridPane.setConstraints(campoSenha, 2, 3);
	    	campoSenha.getStyleClass().add("campo-Usuario");

	    	Button btnUsuario= new Button("Criar Usuario");
	    	btnUsuario.setId("criar-Usuario");
	        btnUsuario.setOnAction(e -> {
	            if(!campoEmail.getText().isEmpty() && !campoSenha.getText().isEmpty()) {
	            	    String email = campoEmail.getText();
	            	    int senha = Integer.parseInt(campoSenha.getText());
	            	    boolean verificador=controller.CriarUsuario(email, senha);
	            	    if(verificador==true) {
	            	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                    	Label labelInvalid=new Label("Usuario criado com sucesso");
	                        labelInvalid.getStyleClass().add("sucesso-Usuario");
	                        GridPane.setConstraints(labelInvalid, 0, 0);
	                        gridPane.getChildren().add(labelInvalid);
	            	    }else {
	            	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                    	Label labelInvalid=new Label("Erro ao criar Usuario");
	                        labelInvalid.getStyleClass().add("erro-Usuario");
	                        GridPane.setConstraints(labelInvalid, 0, 0);
	                        gridPane.getChildren().add(labelInvalid);
	            	    }
	            }else {
	            	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	            	Label labelInvalid=new Label("Erro:campos em branco");
	                labelInvalid.getStyleClass().add("erro-Usuario");
	                GridPane.setConstraints(labelInvalid, 0, 0);
	                gridPane.getChildren().add(labelInvalid);
	            }

	        });
	        GridPane.setConstraints(btnUsuario, 0, 1);
	        
	        Button btnVoltar = new Button("Voltar");
	        btnVoltar.getStyleClass().add("voltar-Usuario");
	        btnVoltar.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnVoltar, 0, 1);
	        
	        Button btnAll= new Button("Mostrar Usuarios");
	    	btnAll.setId("Mostrar-Usuario");
	        btnAll.setOnAction(e -> {
	        	try {
	        		BibliotecarioDao usuario=new BibliotecarioDao();
	        		for(Bibliotecario usuarios:usuario.getAll()) {
	        			System.out.println(usuarios.toString());
	        		}
	        	}catch (SQLException e1) {
					e1.printStackTrace();
				}
	        });
	        GridPane.setConstraints(btnAll, 1, 0);
	        
	        Button btnDelete = new Button("Delete");
	        btnDelete.setId("deletar-Usuario");
	        btnDelete.setOnAction(e -> controller.mostrarTelaDeleteUsuario(stage));
	        GridPane.setConstraints(btnDelete, 1, 0);

	        gridPane.getChildren().addAll(labelTexto,labelEmail, labelSenha, campoEmail ,campoSenha, btnUsuario,btnAll,btnVoltar,btnDelete);

	        Scene scene = new Scene(gridPane, 700, 500);
	        scene.getStylesheets().add(cssFile);
	        stage.setScene(scene);
	    }
	}