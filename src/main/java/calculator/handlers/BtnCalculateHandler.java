package calculator.handlers;

import calculator.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BtnCalculateHandler implements EventHandler<ActionEvent> {
    private TextField textField;
    private Model model;

    public BtnCalculateHandler(TextField textField, Model model) {
        this.textField = textField;
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        int result = this.model.calculate();
        this.textField.setText(String.valueOf(result));
    }
}