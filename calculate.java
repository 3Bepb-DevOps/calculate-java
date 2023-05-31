import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в формате 'число оператор число':");
        String userInput = scanner.nextLine();
        try {
            System.out.println(calculate(userInput));
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }
    }

    public static int calculate(String input) throws IllegalArgumentException {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода!");
        }
        int operand1;
        try {
            operand1 = Integer.parseInt(tokens[0]);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Операнд 1 не является допустимым числом!");
        }
        int operand2;
        try {
            operand2 = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Операнд 2 не является допустимым числом!");
        }
        String operator = tokens[1];
        if (operand1 < 1 || operand1 > 10) {
            throw new IllegalArgumentException("Операнд 1 вне допустимого диапазона!");
        }
        if (operand2 < 1 || operand2 > 10) {
            throw new IllegalArgumentException("Операнд 2 вне допустимого диапазона!");
        }
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль недопустимо!");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Неверный оператор!");
        }
    }
}
