package  Utils;

import java.util.Scanner;

public class IntegerOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        int validInputs = 0;
        int retries = 0;

        while (validInputs < numbers.length && retries < 5) {
            System.out.printf("Enter number %d: ", validInputs + 1);
            String input = scanner.nextLine().trim();

            try {
                numbers[validInputs] = Integer.parseInt(input);
                validInputs++;
                retries = 0; // Reset retries on successful input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                retries++;
            }
        }

        if (validInputs == numbers.length) {
            // Choose two numbers for comparison (modify these lines to select desired numbers)
            int firstNumber = numbers[0];
            int secondNumber = numbers[1];
            int max = Integer.max(firstNumber, secondNumber);

            System.out.printf("The maximum between %d and %d is: %d\n", firstNumber, secondNumber, max);
        } else {
            System.out.println("Failed to get 3 valid numbers after 5 retries.");
        }
    }
}
