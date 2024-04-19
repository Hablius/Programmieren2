package calculator;

import calculator.handlers.*;
import javafx.scene.control.Button;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        initButtonHandlers();
    }

    private void initButtonHandlers() {
        for (int index = 0; index < 10; index++) {
            Button btn = this.view.btnsNumber[index];
            btn.setOnAction(new BtnNumberHandler(this.view.txtCalc, this.model, index));
        }

        this.view.btnPlus.setOnAction(new BtnOperatorHandler(this.view.txtCalc, this.model, "+"));
        this.view.btnMinus.setOnAction(new BtnOperatorHandler(this.view.txtCalc, this.model, "-"));
        this.view.btnTimes.setOnAction(new BtnOperatorHandler(this.view.txtCalc, this.model, "*"));
        this.view.btnDivide.setOnAction(new BtnOperatorHandler(this.view.txtCalc, this.model, "/"));
        this.view.btnClear.setOnAction(new BtnClearHandler(this.view.txtCalc, this.model));

        this.view.btnEquals.setOnAction(event -> {
            if (this.model.isReadyForCalculation()) {
                int result = this.model.calculate();
                this.view.txtCalc.setText(String.valueOf(result));
            }
        });
    }
}
