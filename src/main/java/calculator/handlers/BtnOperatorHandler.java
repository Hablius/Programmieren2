package calculator.handlers;

import calculator.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BtnOperatorHandler implements EventHandler<ActionEvent> {

    private TextField textField;
    private Model model;
    private int btnValue;

    public BtnOperatorHandler(TextField textField, Model model, int btnValue) {
        this.textField = textField;
        this.model = model;
        this.btnValue = btnValue;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
