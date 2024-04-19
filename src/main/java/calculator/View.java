package calculator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    protected Stage stage;
    protected Model model;

    protected Button[] btnsNumber = new Button[10];
    protected GridPane calculatorGrid = new GridPane();
    protected TextField txtCalc = new TextField();
    protected VBox operatorButtons = new VBox();
    protected Button btnPlus = new Button("+");
    protected Button btnMinus = new Button("-");
    protected Button btnTimes = new Button("*");
    protected Button btnDivide = new Button("/");
    protected Button btnClear = new Button("C");
    protected Button btnEquals = new Button("=");

    public View(Stage primaryStage, Model model) {
        this.stage = primaryStage;
        this.model = model;
        BorderPane root = new BorderPane();
        txtCalc.setEditable(false);
        txtCalc.getStyleClass().add("text-field");
        root.setTop(txtCalc);

        for (int i = 0; i < 10; i++) {
            btnsNumber[i] = new Button(String.valueOf(i));
            btnsNumber[i].getStyleClass().add("number-button");
            int row = (i == 0) ? 3 : (i - 1) / 3;
            int col = (i == 0) ? 1 : (i - 1) % 3;
            calculatorGrid.add(btnsNumber[i], col, row);
        }

        operatorButtons.getChildren().addAll(btnPlus, btnMinus, btnTimes, btnDivide);
        operatorButtons.getStyleClass().add("operator-buttons");
        root.setRight(operatorButtons);

        calculatorGrid.add(btnClear, 0, 3);
        calculatorGrid.add(btnEquals, 2, 3);
        root.setCenter(calculatorGrid);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("calculator.css").toExternalForm());
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public void start() {
        stage.show();
    }
}
