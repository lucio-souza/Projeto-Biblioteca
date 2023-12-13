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
                    controller.realizarAutenticacao(email, senha);
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: A senha deve ser um número inteiro.");
                }
            } else {
                System.out.println("Erro: O campo de senha não pode estar vazio.");
            }
        });
        GridPane.setConstraints(botaoLogin, 13, 17);

        gridPane.getChildren().addAll(labelEmail, labelSenha, campoEmail, campoSenha, botaoLogin);

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

        // Adicionar labels, campos de texto e botão ao gridPane
        Label labelEmail = new Label("Email:");
        GridPane.setConstraints(labelEmail, 11, 14);

        Label labelSenha = new Label("Senha:");
        GridPane.setConstraints(labelSenha, 11, 15);

        TextField campoEmail = new TextField();
        GridPane.setConstraints(campoEmail, 12, 14);

        PasswordField campoSenha = new PasswordField();
        GridPane.setConstraints(campoSenha, 12, 15);

        Button botaoLogin = new Button("Login");

        botaoLogin.getStyleClass().add("botao");
        botaoLogin.setOnAction(e -> {
            String email = campoEmail.getText();

            if (!campoSenha.getText().isEmpty()) {
                try {
                    int senha = Integer.parseInt(campoSenha.getText());
                    controller.realizarAutenticacao(email, senha);
                } catch (NumberFormatException ex) {
                    System.out.println("Erro: A senha deve ser um número inteiro.");
                }
            } else {
                System.out.println("Erro: O campo de senha não pode estar vazio.");
            }
        });
        GridPane.setConstraints(botaoLogin, 13, 17);

        gridPane.getChildren().addAll(labelEmail, labelSenha, campoEmail, campoSenha, botaoLogin);

        // Criar a Scene e associá-la ao Stage
        Scene scene = new Scene(gridPane, 700, 500);
        scene.getStylesheets().add(cssFile);
        // Configurar a Scene no Stage
        stage.setScene(scene);

        // Exibir o Stage
        stage.show();
    }
}
