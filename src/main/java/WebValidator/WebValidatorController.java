package WebValidator;

public class WebValidatorController {
    final private WebValidatorModel model;
    final private WebValidatorView view;

    private boolean webAddressValid = false;
    private boolean portValid = false;

    protected WebValidatorController(WebValidatorModel model, WebValidatorView view) {
        this.model = model;
        this.view = view;

        view.txtIpAddress.textProperty().addListener((observable, oldValue, newValue) -> {
            validateWebAddress(newValue);
        });

        view.txtPort.textProperty().addListener((observable, oldValue, newValue) -> {
            validatePortNumber(newValue);
        });

        view.btnConnect.setOnAction(e -> checkAndDisplayResults());
    }

    private void validateWebAddress(String newValue) {
        boolean valid = model.isValidWebAddress(newValue);

        view.txtIpAddress.getStyleClass().remove("valid");
        view.txtIpAddress.getStyleClass().remove("invalid");
        if (valid) {
            view.txtIpAddress.getStyleClass().add("valid");
        } else {
            view.txtIpAddress.getStyleClass().add("invalid");
        }

        webAddressValid = valid;

        enableDisableButton();
    }

    private void validatePortNumber(String newValue) {
        boolean valid = model.isValidPortNumber(newValue);

        view.txtPort.getStyleClass().remove("valid");
        view.txtPort.getStyleClass().remove("invalid");
        if (valid) {
            view.txtPort.getStyleClass().add("valid");
        } else {
            view.txtPort.getStyleClass().add("invalid");
        }

        portValid = valid;

        enableDisableButton();
    }

    private void enableDisableButton() {
        boolean valid = webAddressValid && portValid;
        view.btnConnect.setDisable(!valid);
    }

    private void checkAndDisplayResults() {
        String webAddress = view.txtIpAddress.getText();
        String port = view.txtPort.getText();

        if (model.isValidWebAddress(webAddress) && model.isValidPortNumber(port)) {
            view.lblMessage.setText("Connection successful");
            view.lblMessage.getStyleClass().remove("error");
            view.lblMessage.getStyleClass().add("success");
        } else {
            view.lblMessage.setText("Invalid web address or port number");
            view.lblMessage.getStyleClass().remove("success");
            view.lblMessage.getStyleClass().add("error");
        }
    }
}
