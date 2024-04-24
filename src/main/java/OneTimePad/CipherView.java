package OneTimePad;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CipherView {
    private TextArea inputArea = new TextArea();
    private TextArea outputArea = new TextArea();
    private Button encryptButton = new Button("Encrypt");
    private Button decryptButton = new Button("Decrypt");
    private Button fileButton = new Button("Load Pad File");
    private Label statusLabel = new Label();
    private Stage stage;

    public CipherView(Stage stage) {
        this.stage = stage;
        VBox root = new VBox(10);
        root.getChildren().addAll(inputArea, encryptButton, decryptButton, fileButton, statusLabel, outputArea);


        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(getClass().getResource("OneTimePad.css").toExternalForm());
        stage.setTitle("One-Time-Pad Encryption App");
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }

    public Button getEncryptButton() {
        return encryptButton;
    }

    public Button getDecryptButton() {
        return decryptButton;
    }

    public Button getFileButton() {
        return fileButton;
    }

    public String getInputText() {
        return inputArea.getText();
    }

    public void setOutputText(String text) {
        outputArea.setText(text);
    }

    public void setStatus(String text) {
        statusLabel.setText(text);
    }

    public Stage getStage() {
        return stage;
    }
}
