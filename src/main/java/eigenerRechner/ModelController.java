package eigenerRechner;


public class ModelController {
    private Model model;
    private View view;

    // option hard coded for now
    private int width = 4;
    private int high = 4;

    public ModelController(Model model, View view) {
        this.model = model;
        this.view = view;

    }

    private void newCalculator(){
        view.numbers(width, high);
    }

}
