package calculator.handlers;

import calculator.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BtnOperatorHandler implements EventHandler<ActionEvent> {
    private TextField textField;
    private Model model;
    private String operator;

    public BtnOperatorHandler(TextField textField, Model model, String operator) {
        this.textField = textField;
        this.model = model;
        this.operator = operator;
    }

    @Override
    public void handle(ActionEvent event) {
        this.textField.appendText(" " + operator + " ");
        this.model.updateOperator(operator);
    }
}