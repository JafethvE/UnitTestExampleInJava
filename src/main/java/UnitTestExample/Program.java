package UnitTestExample;

import java.util.Scanner;

public class Program {

    private final Calculator calculator = new Calculator();

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }

    private void run() {
        Operation operation;

        String filePath = System.getProperty("user.dir") + "\\numbers.txt";

        try {
            FileReader.createEmptyFile(filePath);
        } catch (Exception e) {
            System.out.println("Something went wrong while creating the numbers.txt file.");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Welcome to our little calculator. Make sure to have filled in the numbers.text file that comes with this piece of software.");
        System.out.println("Please choose from the following operations:");
        System.out.println("Addition");
        System.out.println("Subtraction");
        System.out.println("Multiplication");
        System.out.println("Average\n");

        String input = scanner.nextLine();

        try {
            operation = Operation.valueOf(input.toUpperCase());
        } catch (Exception e) {
            System.out.println(input + "is not a valid operation, please choose a valid operation.");
            return;
        }

        switch (operation) {
            case ADDITION:
                System.out.println("The sum of the numbers you gave in the text file is " + calculator.add(filePath));
                break;
            case SUBTRACTION:
                System.out.println("The result of the subtraction of the numbers in the text file is " + calculator.subtract(filePath));
                break;
            case MULTIPLICATION:
                System.out.println("The result of the multiplication of the numbers in the text file is " + calculator.multiply(filePath));
                break;
            case AVERAGE:
                System.out.println("The average of the numbers you gave in the text file is " + calculator.average(filePath));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }

        try {
            FileReader.deleteFile(filePath);
        } catch (Exception e) {
            System.out.println("Something went wrong while deleting the numbers.txt file.");
            System.out.println(e.getMessage());
        }
    }
}
