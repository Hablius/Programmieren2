package calculator;

import javafx.application.Application;
import javafx.stage.Stage;

public class MVC extends Application {
    private Model model;
    private View view;
    private Controller controller;

    @Override
    public void start(Stage primaryStage) {
        model = new Model();
        view = new View(primaryStage, model);
        controller = new Controller(model, view);
        view.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
