package application;
import java.sql.SQLException;
import DAO.EmprestimoDao;
import controller.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
	
public class ViewLivros {
		private Controller controller;
		String cssFile = getClass().getResource("style.css").toExternalForm();
		
		public ViewLivros(Stage stage) {
			GridPane gridPane = new GridPane();
	        gridPane.setVgap(10);
	        gridPane.setHgap(10);
	        
	        Label labelTexto=new Label("Emprestimos");
	    	GridPane.setConstraints(labelTexto, 0,1);
	    	labelTexto.setId("Titulo-Emprestimo");

	    	Label labelCpf = new Label("CPF:");
	    	GridPane.setConstraints(labelCpf, 1, 4);
	    	labelCpf.getStyleClass().add("label-emprestimo");

	    	Label labelTitulo = new Label("titulo:");
	    	GridPane.setConstraints(labelTitulo, 1, 5);
	    	labelTitulo.getStyleClass().add("label-emprestimo");

	    	TextField campoCpf = new TextField();
	    	GridPane.setConstraints(campoCpf, 2, 4);
	    	campoCpf.getStyleClass().add("campo-emprestimo");

	    	TextField campoTitulo = new TextField();
	    	GridPane.setConstraints(campoTitulo, 2, 5);
	    	campoTitulo.getStyleClass().add("campo-emprestimo");

	    	Button botaoEmprestar= new Button("Fazer Emprestimos");
	    	botaoEmprestar.setId("botao-Emprestimo");
	        botaoEmprestar.setOnAction(e -> {
	            if(!campoCpf.getText().isEmpty() && !campoTitulo.getText().isEmpty()) {
	            	    String cpf = campoCpf.getText();
	            	    String Titulo=campoTitulo.getText();
	            	    boolean verificador=controller.FazerEmprestimo(cpf, Titulo);
	            	    if(verificador==true) {
	            	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                    	Label labelInvalid=new Label("Emprestimo realizado com sucesso");
	                        labelInvalid.getStyleClass().add("erro-Emprestimo");
	                        labelInvalid.setId("sucesso-emprestimo");
	                        GridPane.setConstraints(labelInvalid, 0, 0);
	                        gridPane.getChildren().add(labelInvalid);
	            	    }else {
	            	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                    	Label labelInvalid=new Label("Emprestimo negado");
	                        labelInvalid.getStyleClass().add("erro-Emprestimo");
	                        GridPane.setConstraints(labelInvalid, 0, 0);
	                        gridPane.getChildren().add(labelInvalid);
	            	    }
	            }else {
	            	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	            	Label labelInvalid=new Label("Erro:campos em branco");
	                labelInvalid.getStyleClass().add("erro-Emprestimo");
	                GridPane.setConstraints(labelInvalid, 0, 0);
	                gridPane.getChildren().add(labelInvalid);
	            }

	        });
	        GridPane.setConstraints(botaoEmprestar, 0, 1);
	        
	        Button btnVoltar = new Button("Voltar");
	        btnVoltar.getStyleClass().add("botao-voltar");
	        btnVoltar.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnVoltar, 0, 1);
	        
	        Button btnAll= new Button("Mostrar Emprestimos");
	    	btnAll.setId("botao-Mostrar-Emprestimos");
	        btnAll.setOnAction(e -> {
	        	EmprestimoDao emprestimos=new EmprestimoDao();
	        	try {
					System.out.println(emprestimos.getAll().toString());
	        	}catch (SQLException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
	        });
	        GridPane.setConstraints(btnAll, 0, 2);

	        gridPane.getChildren().addAll(labelTexto,labelCpf, labelTitulo, campoCpf, campoTitulo, botaoEmprestar,btnVoltar,btnAll);

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

	    	Label labelTexto=new Label("Emprestimos");
	    	GridPane.setConstraints(labelTexto, 0,1);
	    	labelTexto.setId("Titulo-Emprestimo");

	    	Label labelCpf = new Label("CPF:");
	    	GridPane.setConstraints(labelCpf, 1, 4);
	    	labelCpf.getStyleClass().add("label-emprestimo");

	    	Label labelTitulo = new Label("titulo:");
	    	GridPane.setConstraints(labelTitulo, 1, 5);
	    	labelTitulo.getStyleClass().add("label-emprestimo");

	    	TextField campoCpf = new TextField();
	    	GridPane.setConstraints(campoCpf, 2, 4);
	    	campoCpf.getStyleClass().add("campo-emprestimo");

	    	TextField campoTitulo = new TextField();
	    	GridPane.setConstraints(campoTitulo, 2, 5);
	    	campoTitulo.getStyleClass().add("campo-emprestimo");

	    	Button botaoEmprestar= new Button("Fazer Emprestimos");
	    	botaoEmprestar.setId("botao-Emprestimo");
	    	botaoEmprestar.setOnAction(e -> {
	    		if(!campoCpf.getText().isEmpty() && !campoTitulo.getText().isEmpty()) {
	        	    String cpf = campoCpf.getText();
	        	    String Titulo=campoTitulo.getText();
	        	    boolean verificador=controller.FazerEmprestimo(cpf, Titulo);
	        	    if(verificador==true) {
	        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                	Label labelInvalid=new Label("Emprestimo realizado com sucesso");
	                    labelInvalid.getStyleClass().add("erro-Emprestimo");
	                    GridPane.setConstraints(labelInvalid, 0, 0);
	                    gridPane.getChildren().add(labelInvalid);
	        	    }else {
	        	    	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	                	Label labelInvalid=new Label("Emprestimo negado");
	                    labelInvalid.getStyleClass().add("erro-Emprestimo");
	                    GridPane.setConstraints(labelInvalid, 0, 0);
	                    gridPane.getChildren().add(labelInvalid);
	        	    }
	        }else {
	        	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
	        	Label labelInvalid=new Label("Erro:campos em branco");
	            labelInvalid.getStyleClass().add("erro-Emprestimo");
	            GridPane.setConstraints(labelInvalid, 0, 0);
	            gridPane.getChildren().add(labelInvalid);
	        }

	    	});
	    	GridPane.setConstraints(botaoEmprestar, 0, 1);
	        
	        Button btnVoltar = new Button("Voltar");
	        btnVoltar.getStyleClass().add("botao-voltar");
	        btnVoltar.setOnAction(e -> controller.VoltarTela());
	        GridPane.setConstraints(btnVoltar, 0, 1);
	        
	        Button btnAll= new Button("Mostrar Emprestimos");
	    	btnAll.setId("botao-Mostrar-Emprestimos");
	        btnAll.setOnAction(e -> {
	        	EmprestimoDao emprestimos=new EmprestimoDao();
	        	try {
					System.out.println(emprestimos.getAll().toString());
	        	}catch (SQLException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
	        });
	        
	        GridPane.setConstraints(btnAll, 0, 2);

	        gridPane.getChildren().addAll(labelTexto,labelCpf, labelTitulo, campoCpf, campoTitulo, botaoEmprestar,btnVoltar,btnAll);

	        Scene scene = new Scene(gridPane, 700, 500);
	        scene.getStylesheets().add(cssFile);
	        stage.setScene(scene);
	    }
	}
