import java.util.Scanner;

class ProductRecursion {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 whole numbers to multiply:");

        for (int i = 0; i < numbers.length; i++) {
            while (true) {
                System.out.println("Number " + (i + 1) + ": ");
                if (scnr.hasNextInt()) {
                    numbers[i] = scnr.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a whole number (no decimals or commas).");
                    scnr.next();
                }
            }
        }

        int product = multiply(numbers, 0);
        System.out.println("The total of all numbers multiplied together is: " + product);

        scnr.close();

    }
    

    public static int multiply(int[] numbers, int index) {
        if (index == numbers.length) {
            return 1;
        }

        return numbers[index] * multiply(numbers, index + 1);
    }
}