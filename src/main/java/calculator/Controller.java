package calculator;

import calculator.handlers.BtnNumberHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private Model model;
    private View view;

    // option hard coded for now
    private int width = 4;
    private int high = 4;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.initButtonHandlers();
    }

    private void initButtonHandlers() {

        for (int index = 0; index < this.view.btnsNumber.length; index++) {
            Button btn = this.view.btnsNumber[index];
            btn.setOnAction(new BtnNumberHandler(this.view.txtCalc, this.model, index));
        }


    }

    private void newCalculator() {
        //view.numbers(width, high);
    }
}
