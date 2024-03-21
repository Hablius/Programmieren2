package calculator;

public class Model {

    private String operator;
    private String aValue;
    private String bValue;

    public Model() {

    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }

    private static int clear() {
        return 0;
    }

    private static int equals(int a, int b) {
        return a;
    }

    private static int numbers(int a, int b) {
        return a;
    }

    private static int calculate(int a, int b, String operator) {
        return switch(operator) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default -> 0;
        };
    }

    public void addValue(int btnValue) {
        if (this.operator == null || this.operator.isEmpty()) {
            this.aValue = this.aValue + btnValue;
        } else {
            this.bValue = this.bValue + btnValue;
        }
    }

    public int calculate(){
        int a = Integer.parseInt(this.aValue);
        int b = Integer.parseInt(this.bValue);
        return calculate(a, b, this.operator);
    }
    public void updateOperator(String operator){
        this.operator = operator;
    }
}

