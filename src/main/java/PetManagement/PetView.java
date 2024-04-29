package PetManagement;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetView {
    private final Stage stage;
    private final Label lblNumPets = new Label();
    private final Label lblInfo = new Label();
    private final Button btnLoad = new Button("Load Pets");
    private final Button btnSave = new Button("Save Pets");

    public PetView(Stage stage) {
        this.stage = stage;
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
}
