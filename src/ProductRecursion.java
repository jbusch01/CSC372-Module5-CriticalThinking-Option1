import java.util.Scanner;

class ProductRecursion {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 whole numbers you wish to multiply:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Number " + (i + 1) + ": ");
            numbers[i] = scnr.nextInt();
        }

        int product = multiply(numbers, 0);
        System.out.println("The total of all numbers multiplied together is: " + product);

    }

    public static int multiply(int[] numbers, int index) {
        if (index == numbers.length) {
            return 1;
        }
        return numbers[index] * multiply(numbers, index + 1);
    }
}