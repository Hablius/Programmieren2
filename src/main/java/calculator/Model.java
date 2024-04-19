package calculator;

public class Model {
    private String operator = "";
    private String aValue = "";
    private String bValue = "";

    public void addValue(int btnValue) {
        if (operator.isEmpty()) {
            aValue += Integer.toString(btnValue);
        } else {
            bValue += Integer.toString(btnValue);
        }
    }

    public int calculate() {
        int a = Integer.parseInt(aValue);
        int b = Integer.parseInt(bValue);
        int result = switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
        resetAfterOperation(result);
        return result;
    }

    public void clear() {
        aValue = "";
        bValue = "";
        operator = "";
    }

    public void updateOperator(String operator) {
        this.operator = operator;
    }

    private void resetAfterOperation(int result) {
        aValue = Integer.toString(result);
        bValue = "";
        operator = "";
    }

    // Neue Methoden zum Überprüfen, ob Werte gesetzt sind
    public boolean isReadyForCalculation() {
        return !aValue.isEmpty() && !bValue.isEmpty();
    }
}
