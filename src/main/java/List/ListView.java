package List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListView extends Application {
    private ListController controller;
    private SinglyLinkedList<String> list;
    private TextArea displayArea;

    @Override
    public void start(Stage primaryStage) {
        list = new SinglyLinkedList<>();
        controller = new ListController(list, this);

        primaryStage.setTitle("Singly Linked List");

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 400, 300);

        displayArea = new TextArea();
        displayArea.setEditable(false);

        TextField inputField = new TextField();
        inputField.setPromptText("Enter an element");

        Button addButton = new Button("Add Element");
        addButton.setOnAction(e -> {
            String input = inputField.getText();
            if (!input.isEmpty()) {
                controller.addElement(input);
                inputField.clear();
            }
        });

        Button removeButton = new Button("Remove Element");
        removeButton.setOnAction(e -> {
            String input = inputField.getText();
            if (!input.isEmpty()) {
                try {
                    int position = Integer.parseInt(input);
                    controller.removeElement(position);
                    inputField.clear();
                } catch (NumberFormatException ex) {
                    displayMessage("Invalid input for position. Please enter a number.");
                }
            }
        });

        Button displayButton = new Button("Display List");
        displayButton.setOnAction(e -> controller.displayList());

        vbox.getChildren().addAll(new Label("Singly Linked List"), inputField, addButton, removeButton, displayButton, displayArea);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void displayList(SinglyLinkedList<?> list) {
        StringBuilder sb = new StringBuilder("List contents:\n");
        for (int i = 0; i < list.size(); i++) {
            try {
                sb.append("Element at position ").append(i).append(": ").append(list.get(i)).append("\n");
            } catch (ListException e) {
                sb.append("Error accessing position ").append(i).append("\n");
            }
        }
        displayArea.setText(sb.toString());
    }

    public void displayMessage(String message) {
        displayArea.appendText(message + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
