package eigenerRechner;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class View {
        protected Stage stage;
        protected Model model;

        protected TextField Anzeige = new TextField();

        protected MenuItem menuItemAbout = new MenuItem("About");

        protected BorderPane root = new BorderPane();

        protected GridPane calculatorGrid = new GridPane();
        protected Button[][] buttons;
        protected TextField txtCalc = new TextField();
        protected VBox operatorButtons = new VBox();


        public View(Stage primaryStage, Model model) {
            this.stage = primaryStage;
            this.model = model;

            BorderPane root = new BorderPane();
            root.setTop(Anzeige);


            Button btnPlus = new Button("+");
            Button btnMinus = new Button("-");
            Button btnTimes = new Button("*");
            Button btnDivide = new Button("/");
            Button btnClear = new Button("C");
            Button btnEquals = new Button("=");
            operatorButtons.getChildren().addAll(btnPlus, btnMinus, btnTimes, btnDivide, btnClear, btnEquals);
            root.setRight(operatorButtons);

            Button btn1 = new Button("1");
            Button btn2 = new Button("2");
            Button btn3 = new Button("3");
            Button btn4 = new Button("4");
            Button btn5 = new Button("5");
            Button btn6 = new Button("6");
            Button btn7 = new Button("7");
            Button btn8 = new Button("8");
            Button btn9 = new Button("9");
            calculatorGrid.add(btn1, 0, 0);
            calculatorGrid.add(btn2, 1, 0);
            calculatorGrid.add(btn3, 2, 0);
            calculatorGrid.add(btn4, 0, 1);
            calculatorGrid.add(btn5, 1, 1);
            calculatorGrid.add(btn6, 2, 1);
            calculatorGrid.add(btn7, 0, 2);
            calculatorGrid.add(btn8, 1, 2);
            calculatorGrid.add(btn9, 2, 2);
            root.setCenter(calculatorGrid);
            root.setTop(txtCalc);

            Scene scene = new Scene(root);
            stage.setTitle("Calculator");
            scene.getStylesheets().add(getClass().getResource("eigenerRechner.css").toExternalForm());
            stage.setScene(scene);

        }

    public void start() {
        stage.show();
    }

    protected void numbers(int width, int high){
            calculatorGrid.getChildren().clear();
            buttons = new Button[width][high];
            for (int row = 0; row < high; row++) {
                for (int col = 0; col < width; col++) {
                    buttons[col][row] = new Button(Integer.toString(row * width + col));
                    calculatorGrid.add(buttons[col][row], col, row);
                }
            }
    }



}
