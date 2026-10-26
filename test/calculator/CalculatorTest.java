package calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new AddStrategy());
        check(16, calculator.calculate(12, 4));
        calculator.setStrategy(new SubtractStrategy());
        check(8, calculator.calculate(12, 4));
        check(-8, calculator.calculate(4, 12));
        calculator.setStrategy(new MultiplyStrategy());
        check(-12, calculator.calculate(-3, 4));
        check(0, calculator.calculate(0, 4));
        calculator.setStrategy(new AddStrategy());
        check(0.75, calculator.calculate(0.25, 0.5));
        rejectsNull(() -> new Calculator(null));
        rejectsNull(() -> calculator.setStrategy(null));
        // A rejected replacement must leave the previous strategy usable.
        check(7, calculator.calculate(3, 4));
        System.out.println("PASS: 9 checks (switching, operand order, negatives, zero, decimals, null safety)");
    }

    private static void check(double expected, double actual) {
        if (Double.isNaN(actual) || Math.abs(expected - actual) > 0.000001) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }

    private static void rejectsNull(Runnable action) {
        try {
            action.run();
        } catch (NullPointerException expected) {
            return;
        }
        throw new AssertionError("A null strategy must be rejected");
    }
}
