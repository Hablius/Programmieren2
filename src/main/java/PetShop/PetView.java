package PetShop;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetView {
    private Stage stage;
    private PetModel model;
    private PetController controller;

    TextField txtName = new TextField();
    ComboBox<Pet.Species> cmbSpecies = new ComboBox<>();
    ComboBox<Pet.Gender> cmbGender = new ComboBox<>();
    Label lblDataID = new Label();
    Label lblDataName = new Label();
    Label lblDataSpecies = new Label();
    Label lblDataGender = new Label();
    Button btnSave = new Button("Save");
    Button btnDelete = new Button("Delete");
    Button btnNext = new Button("Next");
    Button btnPrevious = new Button("Previous");

    public PetView(Stage stage, PetModel model) {
        this.stage = stage;
        this.model = model;

        VBox root = new VBox();
        root.getChildren().addAll(createDataEntryPane(), createControlPane(), createDataDisplayPane());
        Scene scene = new Scene(root);
        stage.setTitle("Pet Management System");
        stage.setScene(scene);
        stage.show();
    }

    public void setController(PetController controller) {
        this.controller = controller;
        btnSave.setOnAction(controller::addPet);
        btnDelete.setOnAction(controller::deletePet);
        btnNext.setOnAction(controller::nextPet);
        btnPrevious.setOnAction(controller::previousPet);
    }

    // Getters for controller to access user input
    public Pet.Species getSpecies() {
        return cmbSpecies.getValue();
    }

    public Pet.Gender getGender() {
        return cmbGender.getValue();
    }

    public String getName() {
        return txtName.getText();
    }

    private GridPane createDataEntryPane() {
        GridPane pane = new GridPane();
        pane.add(new Label("Name"), 0, 0);
        pane.add(txtName, 1, 0);
        pane.add(new Label("Species"), 0, 1);
        pane.add(cmbSpecies, 1, 1);
        pane.add(new Label("Gender"), 0, 2);
        pane.add(cmbGender, 1, 2);
        cmbSpecies.getItems().addAll(Pet.Species.values());
        cmbGender.getItems().addAll(Pet.Gender.values());
        return pane;
    }

    private GridPane createControlPane() {
        GridPane pane = new GridPane();
        pane.add(btnSave, 0, 0);
        pane.add(btnDelete, 1, 0);
        pane.add(btnNext, 2, 0);
        pane.add(btnPrevious, 3, 0);
        return pane;
    }

    private GridPane createDataDisplayPane() {
        GridPane pane = new GridPane();
        pane.add(new Label("ID"), 0, 0);
        pane.add(lblDataID, 1, 0);
        pane.add(new Label("Name"), 0, 1);
        pane.add(lblDataName, 1, 1);
        pane.add(new Label("Species"), 0, 2);
        pane.add(lblDataSpecies, 1, 2);
        pane.add(new Label("Gender"), 0, 3);
        pane.add(lblDataGender, 1, 3);
        return pane;
    }

    public void updateView() {
        Pet currentPet = model.getCurrentPet();
        if (currentPet != null) {
            lblDataID.setText(String.valueOf(currentPet.getID()));
            lblDataName.setText(currentPet.getName());
            lblDataSpecies.setText(currentPet.getSpecies().toString());
            lblDataGender.setText(currentPet.getGender().toString());
        } else {
            lblDataID.setText("");
            lblDataName.setText("");
            lblDataSpecies.setText("");
            lblDataGender.setText("");
        }
    }
}
