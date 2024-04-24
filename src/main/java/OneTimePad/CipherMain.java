package OneTimePad;

import javafx.application.Application;
import javafx.stage.Stage;

public class CipherMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        CipherView view = new CipherView(primaryStage);  // View instanziieren
        new CipherController(view);  // Controller mit View verbinden
        view.show();  // GUI anzeigen
    }

    public static void main(String[] args) {
        launch(args);  // Startet die Anwendung
    }
}
