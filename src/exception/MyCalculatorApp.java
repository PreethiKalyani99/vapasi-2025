package exception;

public class MyCalculatorApp {
    public static void main (String[] args) {
        Calculator calculator = new Calculator();
        double result = calculator.calculateDouble(5);
        System.out.println(result);
        calculator.calculateDouble(-2);
    }
}
