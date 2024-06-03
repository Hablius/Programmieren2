package WebValidator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class WebValidatorView {
    private WebValidatorModel model;
    private Stage stage;

    protected Label lblIpAddress = new Label("Web address:");
    protected TextField txtIpAddress = new TextField();
    protected Label lblPort = new Label("Port:");
    protected TextField txtPort = new TextField();
    protected Button btnConnect = new Button("Connect");
    protected Label lblMessage = new Label(); // Label to display error messages

    protected WebValidatorView(Stage stage, WebValidatorModel model) {
        this.stage = stage;
        this.model = model;

        stage.setTitle("Web Address Validator");

        HBox inputBox = new HBox();
        Region spacer1 = new Region();
        Region spacer2 = new Region();
        inputBox.getChildren().addAll(lblIpAddress, txtIpAddress, spacer1, lblPort, txtPort, spacer2, btnConnect);

        VBox root = new VBox();
        root.getChildren().addAll(inputBox, lblMessage);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("WebValidator.css").toExternalForm());
        stage.setScene(scene);
    }

    public void start() {
        stage.show();
    }

    public Stage getStage() {
        return stage;
    }
}
