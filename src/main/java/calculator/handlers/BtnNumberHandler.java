package calculator.handlers;

import calculator.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BtnNumberHandler implements EventHandler<ActionEvent> {
    private TextField textField;
    private Model model;
    private int btnValue;

    public BtnNumberHandler(TextField textField, Model model, int btnValue) {
        this.textField = textField;
        this.model = model;
        this.btnValue = btnValue;
    }

    @Override
    public void handle(ActionEvent event) {
        String currentTextValue = this.textField.getText();
        this.textField.setText(currentTextValue + btnValue);
        this.model.addValue(btnValue);
    }
}