package PetManagement;

import javafx.application.Application;
import javafx.stage.Stage;

public class PetMain extends Application {
    private PetModel model;
    private PetView view;
    private PetController controller;

    @Override
    public void init() {
        model = new PetModel();
        try {
            model.loadPets();
        } catch (Exception e) {
            System.out.println("Fehler beim Laden der Haustiere: " + e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) {
        view = new PetView(primaryStage);
        controller = new PetController(model, view);
        view.setNumPets(model.getPets().size());
        controller.initializeEventHandlers();
        primaryStage.show();
    }

    @Override
    public void stop() {
        try {
            model.savePets();
        } catch (Exception e) {
            System.out.println("Fehler beim Speichern der Haustiere: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
