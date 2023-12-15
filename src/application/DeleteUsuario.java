package application;

import java.sql.SQLException;

import DAO.BibliotecarioDao;
import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bibliotecario;
public class DeleteUsuario {
	private Controller controller;
	String cssFile = getClass().getResource("style.css").toExternalForm();

    public DeleteUsuario(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Label labelTexto=new Label("Deletar Usuario");
        GridPane.setConstraints(labelTexto, 1,1);
        labelTexto.getStyleClass().add("texto-Delete");

        Label labelEmail = new Label("Email:");
        GridPane.setConstraints(labelEmail, 0, 1);
        labelEmail.getStyleClass().add("label-Delete");
        labelEmail.setId("delete-email");

        TextField campoEmail = new TextField();
        GridPane.setConstraints(campoEmail, 1, 0);
        campoEmail.getStyleClass().add("campo-Delete");

        Button botaoDelete = new Button("Deletar");
        botaoDelete.getStyleClass().add("botao-Delete");
        botaoDelete.setOnAction(e -> {
            String email = campoEmail.getText();

            if (!campoEmail.getText().isEmpty()) {
                try {
                	
                    BibliotecarioDao usuarioDao=new BibliotecarioDao();
                    Bibliotecario usuario=usuarioDao.getOneByemail(email);
                    usuarioDao.delete(usuario.getId());
                    gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
                	Label labelInvalid=new Label("Usuario deletado com sucesso");
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
        btnVoltar.setOnAction(e -> controller.mostrarTelaClientes(stage));
        GridPane.setConstraints(btnVoltar, 0, 1);
        
        gridPane.getChildren().addAll(labelTexto,labelEmail,campoEmail,botaoDelete, btnVoltar);

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
        
        Label labelTexto=new Label("Deletar Usuario");
        GridPane.setConstraints(labelTexto, 1,1);
        labelTexto.getStyleClass().add("texto-Delete");

        Label labelEmail = new Label("Email:");
        GridPane.setConstraints(labelEmail, 0, 1);
        labelEmail.getStyleClass().add("label-Delete");
        labelEmail.setId("delete-email");

        TextField campoEmail = new TextField();
        GridPane.setConstraints(campoEmail, 1, 0);
        campoEmail.getStyleClass().add("campo-Delete");

        Button botaoDelete = new Button("Deletar");
        botaoDelete.getStyleClass().add("botao-Delete");
        botaoDelete.setOnAction(e -> {
            String email = campoEmail.getText();

            if (!campoEmail.getText().isEmpty()) {
                try {
                	
                    BibliotecarioDao usuarioDao=new BibliotecarioDao();
                    Bibliotecario usuario=usuarioDao.getOneByemail(email);
                    usuarioDao.delete(usuario.getId());
                    gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
                	Label labelInvalid=new Label("Usuario deletado com sucesso");
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
        btnVoltar.setOnAction(e -> controller.mostrarTelaClientes(stage));
        GridPane.setConstraints(btnVoltar, 0, 1);
        
        gridPane.getChildren().addAll(labelTexto,labelEmail,campoEmail,botaoDelete, btnVoltar);

        Scene scene = new Scene(gridPane, 700, 500);
        scene.getStylesheets().add(cssFile);
        stage.setScene(scene);   
    }
}
