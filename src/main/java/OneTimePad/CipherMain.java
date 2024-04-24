package OneTimePad;

import javafx.application.Application;
import javafx.stage.Stage;

public class CipherMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        CipherView view = new CipherView(primaryStage);
        new CipherController(view);
        view.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
