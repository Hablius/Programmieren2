package OneTimePad;

import javafx.stage.FileChooser;

public class CipherController {
    private CipherView view;
    private CipherModel model;

    public CipherController(CipherView view) {
        this.view = view;
        setupHandlers();
    }

    private void setupHandlers() {
        view.getEncryptButton().setOnAction(event -> encryptMessage());
        view.getDecryptButton().setOnAction(event -> decryptMessage());
        view.getFileButton().setOnAction(event -> loadPadFile());
    }

    private void encryptMessage() {
        try {
            String encrypted = model.encrypt(view.getInputText());
            view.setOutputText(encrypted);
        } catch (Exception e) {
            view.setStatus("Error: " + e.getMessage());
        }
    }

    private void decryptMessage() {
        try {
            String decrypted = model.decrypt(view.getInputText());
            view.setOutputText(decrypted);
        } catch (Exception e) {
            view.setStatus("Error: " + e.getMessage());
        }
    }

    private void loadPadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open One-Time Pad File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        var file = fileChooser.showOpenDialog(view.getStage());
        if (file != null) {
            try {
                model = new CipherModel(file.getAbsolutePath());
                view.setStatus("Pad loaded successfully.");
            } catch (Exception e) {
                view.setStatus("Failed to load pad: " + e.getMessage());
            }
        }
    }
}
