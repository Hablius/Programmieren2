package DataTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class TestView extends Application {
    private TableView<TestResult> resultsTable = new TableView<>();
    private ObservableList<TestResult> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        setupTable();
        Scene scene = new Scene(new VBox(resultsTable), 400, 300);
        stage.setTitle("Data Structure Performance Test");
        stage.setScene(scene);
        stage.show();

        // Hier könnte der TestController instanziiert und gestartet werden

    }

    private void setupTable() {
        TableColumn<TestResult, String> structureColumn = new TableColumn<>("Data Structure");
        structureColumn.setCellValueFactory(new PropertyValueFactory<>("structure"));

        TableColumn<TestResult, Long> timeColumn = new TableColumn<>("Operation Time (ns)");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        resultsTable.getColumns().add(structureColumn);
        resultsTable.getColumns().add(timeColumn);
        resultsTable.setItems(data);
    }

    public void displayResults(String structure, long time) {
        data.add(new TestResult(structure, time));
    }

    public static class TestResult {
        private final String structure;
        private final long time;

        public TestResult(String structure, long time) {
            this.structure = structure;
            this.time = time;
        }

        public String getStructure() {
            return structure;
        }

        public long getTime() {
            return time;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
