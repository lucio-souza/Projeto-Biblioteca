package application;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Criar instâncias de View e Controller
        ViewLogin viewLogin = new ViewLogin(primaryStage);
        ViewPrincipal viewPrincipal = new ViewPrincipal(primaryStage);
        Controller controller = new Controller(viewLogin, viewPrincipal);

        // Iniciar a aplicação
        controller.iniciar();
    }
}
