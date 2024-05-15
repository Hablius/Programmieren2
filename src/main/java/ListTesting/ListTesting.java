package ListTesting;

import javafx.application.Application;
import javafx.stage.Stage;

public class ListTesting extends Application {
    private ListTestingView view;
    private ListTestingModel model;

    @Override
    public void start(Stage stage) throws Exception {
        model = new ListTestingModel();
        view = new ListTestingView(stage, model);
        view.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
