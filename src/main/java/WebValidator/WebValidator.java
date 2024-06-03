package WebValidator;

import javafx.application.Application;
import javafx.stage.Stage;

public class WebValidator extends Application {
    private WebValidatorView view;
    private WebValidatorController controller;
    private WebValidatorModel model;

    @Override
    public void start(Stage primaryStage) throws Exception {
        model = new WebValidatorModel();
        view = new WebValidatorView(primaryStage, model);
        controller = new WebValidatorController(model, view);

        view.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
