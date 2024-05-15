package DataTest;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;


public class ListTestingController {
    private ListTestingModel model;
    private ListTestingView view;

    private final DecimalFormat timeFormatter = new DecimalFormat("0.000");

    public ListTestingController(ListTestingModel model, ListTestingView view) {
        this.model = model;
        this.view = view;

        view.btnGo.setOnAction(this::setUpTest);
    }

    private void setUpTest(ActionEvent e) {
        // Get selections from View
        Integer amountOfData = view.cmbNumElements.getValue();
        ListTestingModel.LIST_TYPES listType = view.cmbListType.getValue();
        ListTestingModel.WHERE_CHOICES whereChoice = view.cmbWhere.getValue();

        float runTime = model.runTest(amountOfData, listType, whereChoice);

        view.lblResult.setText("Time: " + timeFormatter.format(runTime) + " seconds");

        // Trigger garbage collection
        System.gc();
    }

}

