package OneTimePad;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CipherView {
    private TextArea inputArea = new TextArea();  // Eingabe für Nachricht
    private TextArea outputArea = new TextArea();  // Ausgabe
    private Button encryptButton = new Button("Encrypt");
    private Button decryptButton = new Button("Decrypt");
    private Button fileButton = new Button("Load Pad File");
    private Label statusLabel = new Label();  // Statusanzeige
    private Stage stage;

    public CipherView(Stage stage) {
        this.stage = stage;
        VBox root = new VBox(10);  // Vertikales Layout
        root.getChildren().addAll(inputArea, encryptButton, decryptButton, fileButton, statusLabel, outputArea);

        Scene scene = new Scene(root, 700, 500);  // Größe des GUI
        scene.getStylesheets().add(getClass().getResource("OneTimePad.css").toExternalForm());  // Stylesheet laden
        stage.setTitle("One-Time-Pad Encryption App");
        stage.setScene(scene);  // Szene zuweisen
    }

    public void show() {
        stage.show();  // GUI anzeigen
    }

    public Button getEncryptButton() {
        return encryptButton;  // Verschlüsselungsschaltfläche
    }

    public Button getDecryptButton() {
        return decryptButton;  // Entschlüsselungsschaltfläche
    }

    public Button getFileButton() {
        return fileButton;  // Schaltfläche zum Laden einer Datei
    }

    public String getInputText() {
        return inputArea.getText();  // Eingabetext erhalten
    }

    public void setOutputText(String text) {
        outputArea.setText(text);  // Ausgabe festlegen
    }

    public void setStatus(String text) {
        statusLabel.setText(text);  // Statusanzeige festlegen
    }

    public Stage getStage() {
        return stage;  // Aktuelle Bühne
    }
}