package calculator.handlers;

import calculator.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BtnClearHandler implements EventHandler<ActionEvent> {

    private TextField textField;
    private Model model;

    public BtnClearHandler(TextField textField, Model model) {
        this.textField = textField;
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        this.textField.setText("");
       // this.model.clear();
    }
}
