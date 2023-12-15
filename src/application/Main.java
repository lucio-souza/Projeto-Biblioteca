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
        ViewLogin viewLogin = new ViewLogin(primaryStage);
        ViewPrincipal viewPrincipal = new ViewPrincipal(primaryStage);
        ViewEmprestimos viewEmprestimos=new ViewEmprestimos(primaryStage);
        ViewClientes viewClientes=new ViewClientes(primaryStage);
        ViewLivros viewLivros=new ViewLivros(primaryStage);
        ViewUsuario viewUsuario=new ViewUsuario(primaryStage);
        DeleteCliente deleteCliente=new DeleteCliente(primaryStage);
        DeleteLivro deleteLivro=new DeleteLivro(primaryStage);
        DeleteUsuario deleteUsuario=new DeleteUsuario(primaryStage);
        Controller controller = new Controller(viewLogin, viewPrincipal,viewEmprestimos,viewClientes,viewLivros,viewUsuario,deleteCliente,deleteLivro,deleteUsuario);

        controller.iniciar();
    }
}
