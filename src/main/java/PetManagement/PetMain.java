package PetManagement;

import javafx.application.Application;
import javafx.stage.Stage;

public class PetMain extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PetView view = new PetView(stage);
        view.start();
    }
}

