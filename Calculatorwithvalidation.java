import java.util.Scanner;

public class CalculatorWithValidation {

    // Method to validate if input is a valid number
    public static boolean isValidNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter first number (or 'exit' to quit): ");
            String input1 = scanner.nextLine();
            if (input1.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator");
                break;
            }

            if (!isValidNumber(input1)) {
                System.out.println("number format exception please enter valid number.");
                continue;
            }
             System.out.print("Enter second number: ");
            String input2 = scanner.nextLine();

            if (!isValidNumber(input2)) {
                System.out.println("number format exception please enter valid number.");
                continue;
            }


            System.out.print("Enter operator (+, -, *, /): ");
            String operator = scanner.nextLine();
            if (!operator.matches("[+\\-*/]")) {
                System.out.println("Invalid operator! Please enter one of +, -, *, /.");
                continue;
            }

            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double result = 0;
            boolean validOperation = true;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;

                default:
                    // Should not reach here because of earlier validation
                    validOperation = false;
                    System.out.println("Unknown error.");
            }

            if (validOperation) {
                System.out.printf("Result: %.4f\n", result);
            }
        }

        scanner.close();
    }
}
