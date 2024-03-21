package PetShop;

import javafx.css.Stylesheet;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PetView {

    private Stage stage;
    private PetModel model;

    public PetView (Stage stage, PetModel model){
        this.stage = stage;
        this.model = model;

        VBox root = new VBox();
        root.getChildren().add(DataEntry());
        root.getChildren().add(DataControll());
        root.getChildren().add(Data());

        Scene scene = new Scene(root);
        stage.setTitle("Pet Shop");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("PetShop.css").toExternalForm());
        stage.show();
    }
    public void start () {
        stage.show();
    }
    private Pane DataEntry(){
        GridPane pane = new GridPane();
        pane.setId("ID");
        pane.add(new Label("enter controll ID"),0 , 0);
        return pane;
    }
    private Pane DataControll() {
        GridPane pane = new GridPane();
        pane.setId("controllArea");
        pane.add(new Label("Controll Area"),10, 10);
        return pane;
    }
    private Pane Data() {
        GridPane pane = new GridPane();
        pane.setId("DataDisplay");
        pane.add(new Label("Data"),10, 10);
        return pane;
    }
}
