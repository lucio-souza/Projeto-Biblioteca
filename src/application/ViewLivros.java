package application;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import DAO.LivroDao;
import controller.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Livro;
	
public class ViewLivros {
		private Controller controller;
		String cssFile = getClass().getResource("style.css").toExternalForm();
		
		public ViewLivros(Stage stage) {
			GridPane gridPane = new GridPane();
	        gridPane.setVgap(10);
	        gridPane.setHgap(10);
	        
	        Label labelTexto=new Label("Livros");
	    	GridPane.setConstraints(labelTexto, 0,1);
	    	labelTexto.setId("Titulo-Livros");

	    	Label labelTitulo = new Label("titulo:");
	    	GridPane.setConstraints(labelTitulo, 1, 3);
	    	labelTitulo.getStyleClass().add("label-Livros");
	    	labelTitulo.setId("label-Titulo");
	    	
	    	Label labelDt= new Label("Publicacao(yyyy-MM-dd):");
	    	GridPane.setConstraints(labelDt, 1, 4);
	    	labelDt.getStyleClass().add("label-Livros");
	    	labelDt.setId("label-Dt");
	    	
	    	Label labelGenero= new Label("Genero:");
	    	GridPane.setConstraints(labelGenero, 1, 5);
	    	labelGenero.getStyleClass().add("label-Livros");
	    	labelGenero.setId("label-Genero");
	    	
	    	Label labelAutor= new Label("Autor:");
	    	GridPane.setConstraints(labelAutor, 1, 6);
	    	labelAutor.getStyleClass().add("label-Livros");
	    	labelAutor.setId("label-Autor");
	    	
	    	TextField campoTitulo = new TextField();
	    	GridPane.setConstraints(campoTitulo, 2, 3);
	    	campoTitulo.getStyleClass().add("campo-Livros");
	    	
	    	TextField campoDt = new TextField();
	    	GridPane.setConstraints(campoDt, 2, 4);
	    	campoDt.getStyleClass().add("campo-Livros");
	    	
	    	TextField campoGenero = new TextField();
	    	GridPane.setConstraints(campoGenero, 2, 5);
	    	campoGenero.getStyleClass().add("campo-Livros");
	    	
	    	TextField campoAutor = new TextField();
	    	GridPane.setConstraints(campoAutor, 2, 6);
	    	campoAutor.getStyleClass().add("campo-Livros");

	    	Button botaoCriar= new Button("Criar Livro");
	    	botaoCriar.setId("criar-Livro");
	    	botaoCriar.setOnAction(e -> {
	    		if(!campoTitulo.getText().isEmpty() && !campoDt.getText().isEmpty() && !campoAutor.getText().isEmpty() && !campoGenero.getText().isEmpty()){	
	        	   try {
	        		String autor = campoAutor.getText();
	        	    String Titulo=campoTitulo.getText();
	        	    String genero=campoGenero.getText();
	        	    String DtString=campoDt.getText();
	        	    LocalDate Dt=LocalDate.parse(DtString);
	        	    boolean verificador=controller.CriarLivro(Titulo, autor, genero, Dt);
	        	    if(verificador==true) {
	        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                	Label labelInvalid=new Label("Livro criado com sucesso");
	                    labelInvalid.getStyleClass().add("Sucesso-Livro");
	                    GridPane.setConstraints(labelInvalid, 0, 0);
	                    gridPane.getChildren().add(labelInvalid);
	        	    }else {
	        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                	Label labelInvalid=new Label("Erro ao criar Livro");
	                    labelInvalid.getStyleClass().add("erro-Livro");
	                    GridPane.setConstraints(labelInvalid, 0, 0);
	                    gridPane.getChildren().add(labelInvalid);
	        	    }
	        }catch(DateTimeParseException ex){
	        	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
            	Label labelInvalid=new Label("Data Invalida");
                labelInvalid.getStyleClass().add("erro-Livro");
                GridPane.setConstraints(labelInvalid, 0, 0);
                gridPane.getChildren().add(labelInvalid);
	        }
	    	}else {
	        	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	        	Label labelInvalid=new Label("Erro:campos em branco");
	            labelInvalid.getStyleClass().add("erro-Livro");
	            GridPane.setConstraints(labelInvalid, 0, 0);
	            gridPane.getChildren().add(labelInvalid);
	    		}
	    	});
	    	GridPane.setConstraints(botaoCriar, 0, 1);
	        
	        Button btnVoltar = new Button("Voltar");
	        btnVoltar.getStyleClass().add("botao-voltar");
	        btnVoltar.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnVoltar, 0, 1);
	        
	        Button btnAll= new Button("Mostrar Livros");
	    	btnAll.setId("botao-Mostrar-Livros");
	        btnAll.setOnAction(e -> {
	        	try {
	        		LivroDao livro=new LivroDao();
	        		for(Livro livros:livro.getAll()) {
	        			System.out.println(livros.toString());
	        		}
	        	}catch (SQLException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
	        });
	        
	        GridPane.setConstraints(btnAll, 0, 2);
	        
	        Button btnDelete = new Button("Delete");
	        btnDelete.setId("deletar-Livro");
	        btnDelete.setOnAction(e -> controller.mostrarTelaDeleteLivro(stage));
	        GridPane.setConstraints(btnDelete, 0, 1);

	        gridPane.getChildren().addAll(labelTexto, labelTitulo,labelDt,labelGenero,labelAutor, campoTitulo,campoAutor,campoDt,campoGenero, botaoCriar,btnVoltar,btnAll,btnDelete);

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

	    	Label labelTexto=new Label("Livros");
	    	GridPane.setConstraints(labelTexto, 0,1);
	    	labelTexto.setId("Titulo-Livros");

	    	Label labelTitulo = new Label("titulo:");
	    	GridPane.setConstraints(labelTitulo, 1, 3);
	    	labelTitulo.getStyleClass().add("label-Livros");
	    	labelTitulo.setId("label-Titulo");
	    	
	    	Label labelDt= new Label("Publicacao(yyyy-MM-dd):");
	    	GridPane.setConstraints(labelDt, 1, 4);
	    	labelDt.getStyleClass().add("label-Livros");
	    	labelDt.setId("label-Dt");
	    	
	    	Label labelGenero= new Label("Genero:");
	    	GridPane.setConstraints(labelGenero, 1, 5);
	    	labelGenero.getStyleClass().add("label-Livros");
	    	labelGenero.setId("label-Genero");
	    	
	    	Label labelAutor= new Label("Autor:");
	    	GridPane.setConstraints(labelAutor, 1, 6);
	    	labelAutor.getStyleClass().add("label-Livros");
	    	labelAutor.setId("label-Autor");
	    	
	    	TextField campoTitulo = new TextField();
	    	GridPane.setConstraints(campoTitulo, 2, 3);
	    	campoTitulo.getStyleClass().add("campo-Livros");
	    	
	    	TextField campoDt = new TextField();
	    	GridPane.setConstraints(campoDt, 2, 4);
	    	campoDt.getStyleClass().add("campo-Livros");
	    	
	    	TextField campoGenero = new TextField();
	    	GridPane.setConstraints(campoGenero, 2, 5);
	    	campoGenero.getStyleClass().add("campo-Livros");
	    	
	    	TextField campoAutor = new TextField();
	    	GridPane.setConstraints(campoAutor, 2, 6);
	    	campoAutor.getStyleClass().add("campo-Livros");

	    	Button botaoCriar= new Button("Criar Livro");
	    	botaoCriar.setId("criar-Livro");
	    	botaoCriar.setOnAction(e -> {
	    		if(!campoTitulo.getText().isEmpty() && !campoDt.getText().isEmpty() && !campoAutor.getText().isEmpty() && !campoGenero.getText().isEmpty()) {
	    			try {
		        		String autor = campoAutor.getText();
		        	    String Titulo=campoTitulo.getText();
		        	    String genero=campoGenero.getText();
		        	    String DtString=campoDt.getText();
		        	    LocalDate Dt=LocalDate.parse(DtString);
		        	    boolean verificador=controller.CriarLivro(Titulo, autor, genero, Dt);
		        	    if(verificador==true) {
		        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
		                	Label labelInvalid=new Label("Livro criado com sucesso");
		                    labelInvalid.getStyleClass().add("Sucesso-Livro");
		                    GridPane.setConstraints(labelInvalid, 0, 0);
		                    gridPane.getChildren().add(labelInvalid);
		        	    }else {
		        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
		                	Label labelInvalid=new Label("Erro ao criar Livro");
		                    labelInvalid.getStyleClass().add("erro-Livro");
		                    GridPane.setConstraints(labelInvalid, 0, 0);
		                    gridPane.getChildren().add(labelInvalid);
		        	    }
		        }catch(DateTimeParseException ex){
		        	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	            	Label labelInvalid=new Label("Data Invalida");
	                labelInvalid.getStyleClass().add("erro-Livro");
	                GridPane.setConstraints(labelInvalid, 0, 0);
	                gridPane.getChildren().add(labelInvalid);
		        }
		    	}else {
		        	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
		        	Label labelInvalid=new Label("Erro:campos em branco");
		            labelInvalid.getStyleClass().add("erro-Livro");
		            GridPane.setConstraints(labelInvalid, 0, 0);
		            gridPane.getChildren().add(labelInvalid);
		    		}
		    	});
	    	GridPane.setConstraints(botaoCriar, 0, 1);
	        
	        Button btnVoltar = new Button("Voltar");
	        btnVoltar.getStyleClass().add("botao-voltar");
	        btnVoltar.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnVoltar, 0, 1);
	        
	        Button btnAll= new Button("Mostrar Livros");
	    	btnAll.setId("botao-Mostrar-Livros");
	        btnAll.setOnAction(e -> {
	        	try {
	        		LivroDao livro=new LivroDao();
	        		for(Livro livros:livro.getAll()) {
	        			System.out.println(livros.toString());
	        		}
	        	}catch (SQLException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
	        });
	        
	        GridPane.setConstraints(btnAll, 0, 2);
	        
	        Button btnDelete = new Button("Delete");
	        btnDelete.setId("deletar-Livro");
	        btnDelete.setOnAction(e -> controller.mostrarTelaDeleteLivro(stage));
	        GridPane.setConstraints(btnDelete, 0, 1);

	        gridPane.getChildren().addAll(labelTexto, labelTitulo,labelDt,labelGenero,labelAutor, campoTitulo,campoAutor,campoDt,campoGenero, botaoCriar,btnVoltar,btnAll,btnDelete);

	        Scene scene = new Scene(gridPane, 700, 500);
	        scene.getStylesheets().add(cssFile);
	        stage.setScene(scene);
	    }
	}
