package PetShop;

import javafx.application.Application;
import javafx.stage.Stage;

public class PetController {
    private PetView view;
    private PetModel model;

    public PetController(PetModel model, PetView view){
        this.model = model;
        this.view = view;

    }

}
