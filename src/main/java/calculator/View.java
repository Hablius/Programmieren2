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

    protected Button btnsNumber[] = new Button[10];
    protected GridPane calculatorGrid = new GridPane();
    protected TextField txtCalc = new TextField();
    protected VBox operatorButtons = new VBox();

    public View(Stage primaryStage, Model model) {
        this.stage = primaryStage;
        this.model = model;

        BorderPane root = new BorderPane();
        root.setTop(txtCalc);


        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnTimes = new Button("*");
        Button btnDivide = new Button("/");


        operatorButtons.getChildren().addAll(btnPlus, btnMinus, btnTimes, btnDivide);
        root.setRight(operatorButtons);

        btnsNumber[0] = new Button("0");
        btnsNumber[1] = new Button("1");
        btnsNumber[2] = new Button("2");
        btnsNumber[3] = new Button("3");
        btnsNumber[4] = new Button("4");
        btnsNumber[5] = new Button("5");
        btnsNumber[6] = new Button("6");
        btnsNumber[7] = new Button("7");
        btnsNumber[8] = new Button("8");
        btnsNumber[9] = new Button("9");
        Button btnClear = new Button("C");
        Button btnEquals = new Button("=");
        calculatorGrid.add(btnsNumber[1], 0, 0);
        calculatorGrid.add(btnsNumber[2], 1, 0);
        calculatorGrid.add(btnsNumber[3], 2, 0);
        calculatorGrid.add(btnsNumber[4], 0, 1);
        calculatorGrid.add(btnsNumber[5], 1, 1);
        calculatorGrid.add(btnsNumber[6], 2, 1);
        calculatorGrid.add(btnsNumber[7], 0, 2);
        calculatorGrid.add(btnsNumber[8], 1, 2);
        calculatorGrid.add(btnsNumber[9], 2, 2);
        calculatorGrid.add(btnClear, 0, 3);
        calculatorGrid.add(btnsNumber[0], 1, 3);
        calculatorGrid.add(btnEquals, 2, 3);
        root.setCenter(calculatorGrid);
        root.setTop(txtCalc);

        Scene scene = new Scene(root);
        stage.setTitle("Calculator");
        scene.getStylesheets().add(getClass().getResource("calculator.css").toExternalForm());
        stage.setScene(scene);

    }

    public void start() {
        stage.show();
    }
}
