package application;

import java.sql.SQLException;


import DAO.LivroDao;
import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Livro;

public class DeleteLivro {
	private Controller controller;
	String cssFile = getClass().getResource("style.css").toExternalForm();

    public DeleteLivro(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Label labelTexto=new Label("Deletar Livro");
        GridPane.setConstraints(labelTexto, 1,1);
        labelTexto.getStyleClass().add("texto-Delete");

        Label labelTitulo = new Label("Titulo:");
        GridPane.setConstraints(labelTitulo, 0, 1);
        labelTitulo.getStyleClass().add("label-Delete");
        labelTitulo.setId("delete-Titulo");

        TextField campoTitulo = new TextField();
        GridPane.setConstraints(campoTitulo, 1, 0);
        campoTitulo.getStyleClass().add("campo-Delete");

        Button botaoDelete = new Button("Deletar");
        botaoDelete.getStyleClass().add("botao-Delete");
        botaoDelete.setOnAction(e -> {
            String titulo = campoTitulo.getText();

            if (!campoTitulo.getText().isEmpty()) {
                try {
                	LivroDao livroDao=new LivroDao();
                    Livro livro=LivroDao.getOneByTitulo(titulo);
                    livroDao.delete(livro.getId());
                    gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
                	Label labelInvalid=new Label("Livro deletado com sucesso");
                    labelInvalid.setId("sucesso-Delete");
                    GridPane.setConstraints(labelInvalid, 0, 0);
                    gridPane.getChildren().add(labelInvalid);
                } catch (SQLException ex) {
                	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
                	Label labelInvalid=new Label("Erro ao excluir");
                    labelInvalid.getStyleClass().add("erro-Delete");
                    GridPane.setConstraints(labelInvalid, 0, 0);
                    gridPane.getChildren().add(labelInvalid);
                }
            } else {
            	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
            	Label labelVazia=new Label("O campo de senha não pode esta vazio");
                labelVazia.getStyleClass().add("erro-Delete");
                GridPane.setConstraints(labelVazia, 0, 0);
                gridPane.getChildren().add(labelVazia);
            }
        });
        GridPane.setConstraints(botaoDelete, 0, 2);
        
        Button btnVoltar = new Button("Voltar");
        btnVoltar.getStyleClass().add("voltar-Delete");
        btnVoltar.setOnAction(e -> controller.mostraTelaLivros(stage));
        GridPane.setConstraints(btnVoltar, 0, 1);
        
        gridPane.getChildren().addAll(labelTexto,labelTitulo,campoTitulo,botaoDelete, btnVoltar);

        Scene scene = new Scene(gridPane, 700, 500);
        scene.getStylesheets().add(cssFile);
        stage.setScene(scene);
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void mostrar(Stage stage) {
        stage.setTitle("Tela de Delete");

        // Criar GridPane e adicionar elementos
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Label labelTexto=new Label("Deletar Livro");
        GridPane.setConstraints(labelTexto, 1,1);
        labelTexto.getStyleClass().add("texto-Delete");

        Label labelTitulo = new Label("Titulo:");
        GridPane.setConstraints(labelTitulo, 0, 1);
        labelTitulo.getStyleClass().add("label-Delete");
        labelTitulo.setId("delete-Titulo");

        TextField campoTitulo = new TextField();
        GridPane.setConstraints(campoTitulo, 1, 0);
        campoTitulo.getStyleClass().add("campo-Delete");

        Button botaoDelete = new Button("Deletar");
        botaoDelete.getStyleClass().add("botao-Delete");
        botaoDelete.setOnAction(e -> {
            String titulo = campoTitulo.getText();

            if (!campoTitulo.getText().isEmpty()) {
                try {
                	LivroDao livroDao=new LivroDao();
                    Livro livro=LivroDao.getOneByTitulo(titulo);
                    livroDao.delete(livro.getId());
                    gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
                	Label labelInvalid=new Label("Livro deletado com sucesso");
                    labelInvalid.setId("sucesso-Delete");
                    GridPane.setConstraints(labelInvalid, 0, 0);
                    gridPane.getChildren().add(labelInvalid);
                } catch (SQLException ex) {
                	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
                	Label labelInvalid=new Label("Erro ao excluir");
                    labelInvalid.getStyleClass().add("erro-Delete");
                    GridPane.setConstraints(labelInvalid, 0, 0);
                    gridPane.getChildren().add(labelInvalid);
                }
            } else {
            	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
            	Label labelVazia=new Label("O campo de senha não pode esta vazio");
                labelVazia.getStyleClass().add("erro-Delete");
                GridPane.setConstraints(labelVazia, 0, 0);
                gridPane.getChildren().add(labelVazia);
            }
        });
        GridPane.setConstraints(botaoDelete, 0, 2);
        
        Button btnVoltar = new Button("Voltar");
        btnVoltar.getStyleClass().add("voltar-Delete");
        btnVoltar.setOnAction(e -> controller.mostraTelaLivros(stage));
        GridPane.setConstraints(btnVoltar, 0, 1);
        
        gridPane.getChildren().addAll(labelTexto,labelTitulo,campoTitulo,botaoDelete, btnVoltar);

        Scene scene = new Scene(gridPane, 700, 500);
        scene.getStylesheets().add(cssFile);
        stage.setScene(scene);   
    }
}
