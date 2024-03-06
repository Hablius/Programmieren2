package eigenerRechner;
import javafx.application.Application;
import javafx.stage.Stage;

public class Rechner extends Application{
    private Model model;
    private View view;
    private ModelController controller;



    @Override
    public void start(Stage primaryStage) {
        model = new Model();
        view = new View(primaryStage, model);
        controller = new ModelController(model, view);
        view.start();


    }
    public static void main(String[] args) {
        launch();
    }
}
