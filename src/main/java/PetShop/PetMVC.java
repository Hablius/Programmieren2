package PetShop;

import javafx.application.Application;
import javafx.stage.Stage;

public class PetMVC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        PetModel model = new PetModel();
        PetView view = new PetView(primaryStage, model);
        PetController controller = new PetController(model, view);
        view.setController(controller);
    }
}
