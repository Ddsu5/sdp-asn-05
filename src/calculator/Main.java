package calculator;

public class Main {
    public static void main(String[] args) {
        double firstNumber = 12;
        double secondNumber = 4;
        Calculator calculator = new Calculator(new AddStrategy());

        System.out.println("Same Calculator object, different strategies:");
        System.out.println("12 + 4 = " + calculator.calculate(firstNumber, secondNumber));

        calculator.setStrategy(new SubtractStrategy());
        System.out.println("12 - 4 = " + calculator.calculate(firstNumber, secondNumber));

        calculator.setStrategy(new MultiplyStrategy());
        System.out.println("12 * 4 = " + calculator.calculate(firstNumber, secondNumber));
    }
}
