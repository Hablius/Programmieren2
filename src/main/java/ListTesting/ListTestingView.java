package ListTesting;

import ListTesting.ListTestingModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListTestingView {
    private Stage stage;
    private ListTestingModel model;

    protected final Integer[] DATA_AMOUNTS = {10000, 30000, 100000, 300000, 1000000};
    private Label lblNumElements = new Label("Amount of data");
    protected ComboBox<Integer> cmbNumElements = new ComboBox<>();
    private Label lblListType = new Label("List type");
    protected ComboBox<ListTestingModel.LIST_TYPES> cmbListType = new ComboBox<>();
    private Label lblWhereToAdd = new Label("Add elements at");
    protected ComboBox<ListTestingModel.WHERE_CHOICES> cmbWhere = new ComboBox<>();
    protected Button btnGo = new Button("Run test");
    protected Label lblResult = new Label();

    public ListTestingView(Stage stage, ListTestingModel model) {
        this.stage = stage;
        this.model = model;

        cmbNumElements.getItems().setAll(DATA_AMOUNTS);
        cmbNumElements.setValue(DATA_AMOUNTS[0]);

        cmbListType.getItems().setAll(ListTestingModel.LIST_TYPES.values());
        cmbListType.setValue(ListTestingModel.LIST_TYPES.ArrayList);

        cmbWhere.getItems().setAll(ListTestingModel.WHERE_CHOICES.values());
        cmbWhere.setValue(ListTestingModel.WHERE_CHOICES.Start);

        GridPane grid = new GridPane();
        grid.addRow(0, lblNumElements, cmbNumElements);
        grid.addRow(1, lblListType, cmbListType);
        grid.addRow(2, lblWhereToAdd, cmbWhere);

        VBox root = new VBox(grid, btnGo, lblResult);
        root.getStyleClass().add("vbox");

        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("List Testing Application");

        btnGo.setOnAction(e -> runTest());
    }

    private void runTest() {
        Integer amountOfData = cmbNumElements.getValue();
        ListTestingModel.LIST_TYPES listType = cmbListType.getValue();
        ListTestingModel.WHERE_CHOICES whereChoice = cmbWhere.getValue();

        float runTime = model.runTest(amountOfData, listType, whereChoice);
        lblResult.setText("Time: " + runTime + " seconds");
    }

    public void start() {
        stage.show();
    }
}
