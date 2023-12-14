package application;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewLogin {
    private Controller controller;
	String cssFile = getClass().getResource("style.css").toExternalForm();

    public ViewLogin(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Label labelTexto=new Label("BIBLIOTECA");
        GridPane.setConstraints(labelTexto, 1,1);
        labelTexto.getStyleClass().add("label-Texto-login");

        Label labelEmail = new Label("Email:");
        GridPane.setConstraints(labelEmail, 12, 14);

        Label labelSenha = new Label("Senha:");
        GridPane.setConstraints(labelSenha, 12, 15);

        TextField campoEmail = new TextField();
        GridPane.setConstraints(campoEmail, 13, 14);

        PasswordField campoSenha = new PasswordField();
        GridPane.setConstraints(campoSenha, 13, 15);

        Button botaoLogin = new Button("Login");
        botaoLogin.getStyleClass().add("botao");
        botaoLogin.setOnAction(e -> {
            String email = campoEmail.getText();

            if (!campoSenha.getText().isEmpty()) {
                try {
                    int senha = Integer.parseInt(campoSenha.getText());
                    controller.realizarAutenticacao(email, senha,stage);
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: A senha deve ser um número inteiro.");
                }
            } else {
                Label labelErro=new Label("O campo de senha não pode esta vazio");
                GridPane.setConstraints(labelErro, 0, 0);
            }
        });
        GridPane.setConstraints(botaoLogin, 0, 1);

        gridPane.getChildren().addAll(labelTexto,labelEmail, labelSenha, campoEmail, campoSenha, botaoLogin);

        Scene scene = new Scene(gridPane, 700, 500);
        scene.getStylesheets().add(cssFile);
        stage.setScene(scene);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void mostrar(Stage stage) {
        stage.setTitle("Tela de Login");

        // Criar GridPane e adicionar elementos
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Label labelTexto=new Label("BIBLIOTECA");
        GridPane.setConstraints(labelTexto, 0,1);
        labelTexto.getStyleClass().add("label-Texto-login");;
        
        Label labelEmail = new Label("Email:");
        GridPane.setConstraints(labelEmail, 11, 14);
        labelEmail.getStyleClass().add("label-form-login");

        Label labelSenha = new Label("Senha:");
        GridPane.setConstraints(labelSenha, 11, 15);
        labelSenha.getStyleClass().add("label-form-login");

        TextField campoEmail = new TextField();
        GridPane.setConstraints(campoEmail, 12, 14);
        campoEmail.getStyleClass().add("campo-form-login");

        PasswordField campoSenha = new PasswordField();
        GridPane.setConstraints(campoSenha, 12, 15);
        campoSenha.getStyleClass().add("campo-form-login");
        
        Button botaoLogin = new Button("Login");
        botaoLogin.getStyleClass().add("botao-login");
        botaoLogin.setOnAction(e -> {
            String email = campoEmail.getText();

            if (!campoSenha.getText().isEmpty()) {
                try {
                    int senha = Integer.parseInt(campoSenha.getText());
                    controller.realizarAutenticacao(email, senha, stage);
                } catch (NumberFormatException ex) {
                	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
                	Label labelInvalid=new Label("A senha deve ser um número inteiro.");
                    labelInvalid.getStyleClass().add("label-erro-view");
                    GridPane.setConstraints(labelInvalid, 0, 0);
                    gridPane.getChildren().add(labelInvalid);
                }
            } else {
            	gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 0 && GridPane.getColumnIndex(node) == 0); 
            	Label labelVazia=new Label("O campo de senha não pode esta vazio");
                labelVazia.getStyleClass().add("label-erro-view");
                GridPane.setConstraints(labelVazia, 0, 0);
                gridPane.getChildren().add(labelVazia);
            }
        });
        GridPane.setConstraints(botaoLogin, 0,1);

        gridPane.getChildren().addAll(labelTexto,labelEmail, labelSenha, campoEmail, campoSenha, botaoLogin);

        // Criar a Scene e associá-la ao Stage
        Scene scene = new Scene(gridPane, 700, 500);
        scene.getStylesheets().add(cssFile);
        // Configurar a Scene no Stage
        stage.setScene(scene);

        // Exibir o Stage
        stage.show();    
        
    }
}