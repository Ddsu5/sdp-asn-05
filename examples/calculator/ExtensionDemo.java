package calculator;

public class ExtensionDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new DivideStrategy());
        System.out.println("12 / 4 = " + calculator.calculate(12, 4));
        calculator.setStrategy(new AddStrategy());
        System.out.println("12 + 4 = " + calculator.calculate(12, 4));

        calculator.setStrategy(new DivideStrategy());
        try {
            calculator.calculate(12, 0);
            throw new AssertionError("Division by zero must be rejected");
        } catch (IllegalArgumentException expected) {
            System.out.println(expected.getMessage());
        }
    }
}
