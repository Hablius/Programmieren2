package PetManagement;

import javafx.stage.Stage;
import java.io.IOException;

public class PetController {
    private PetModel model;
    private PetView view;

    public PetController(PetModel model, PetView view) {
        this.model = model;
        this.view = view;
    }
    public void initializeEventHandlers() {
        view.getBtnLoad().setOnAction(e -> handleLoad());
        view.getBtnSave().setOnAction(e -> handleSave());
    }
    private void handleLoad() {
        try {
            model.loadPets();
            view.setNumPets(model.getPets().size());
            view.setInfo("Haustiere geladen");
        } catch (IOException e) {
            view.setInfo("Fehler beim Laden der Haustiere");
        }
    }
        private void handleSave() {
            try {
                model.savePets();
                view.setInfo("Haustiere gespeichert");
            } catch (IOException e) {
                view.setInfo("Fehler beim Speichern der Haustiere");
            }
        }
}
