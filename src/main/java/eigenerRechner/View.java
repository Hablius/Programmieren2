package eigenerRechner;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class View {
    final private Model model;
    final private Stage stage;


    // Define the fields in the GUI
    protected TextField txtCalc;
    public Button numbers[] = new Button[10];
    protected Button btnPlus;
    protected Button btnClear;
    protected Button btnEquals;

    protected View(Stage stage, Model model) {
        this.stage = stage;
        this.model = model;

        BorderPane root = new BorderPane();
        txtCalc = new TextField();
        txtCalc.setDisable(true);
        root.setTop(txtCalc);

        GridPane buttons = new GridPane();
        root.setCenter(buttons);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Button(Integer.toString(i));
        }

        // special add for button 0
        buttons.add(numbers[0], 0, 3, 3, 1);

        // add all other digits
        for (int i = 1; i < numbers.length; i++) {
            buttons.add(numbers[i], (i-1) % 3, 2 - (i-1) / 3);
        }

        btnPlus = new Button("+");
        buttons.add(btnPlus, 3, 0);

        btnClear = new Button("C");
        buttons.add(btnClear, 3, 1);

        btnEquals = new Button("=");
        buttons.add(btnEquals, 3, 2, 1, 2);

        // Configure grid columns and rows to resize to available space
        // See "GridPane" in the JavaFX API, section "Percentage Sizing"
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPercentWidth(25);
        buttons.getColumnConstraints().addAll(cc, cc, cc, cc);
        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(25);
        buttons.getRowConstraints().addAll(rc, rc, rc, rc);

        // Border Pane styling
        root.getStyleClass().add("pane");

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("eigenerRechner.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Calculator");

    }

    public void start() {
        stage.show();
    }
}
