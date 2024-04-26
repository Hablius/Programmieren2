package PetManagement;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetView {
    private Stage stage;
    //model instanzieren
    private Label lblNumPets = new Label();
    private Label lblInfo = new Label();
    private Button btnLoad = new Button("Load Pets");
    private Button btnSave = new Button("Save Pets");

    public PetView(Stage stage) {
        this.stage = stage;
        //model hinzufügen
        VBox root = new VBox(10, lblNumPets, lblInfo, btnLoad, btnSave);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Pet Management");
        stage.setScene(scene);
    }

    public Button getBtnLoad() {
        return btnLoad;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public void setNumPets(int numPets) {
        lblNumPets.setText("Number of pets: " + numPets);
    }

    public void setInfo(String info) {
        lblInfo.setText(info);
    }

    public void start() {
        stage.show();
    }
}
