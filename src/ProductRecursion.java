import javax.swing.JOptionPane;

class ProductRecursion {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        
        for (int i = 0; i < numbers.length; i++) {
            while (true) {
                String input = JOptionPane.showInputDialog(null, "Enter whole number #" + (i + 1) + ": ");

                if (input == null || input.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Input cannot be blank. Please enter a whole number (no commas, decimals, or spaces).");
                    continue;
                }

                try {
                    numbers[i] = Integer.parseInt(input.trim());
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a whole number (no commas, decimals, or spaces).");
                }
            }
        }

        int product = multiply(numbers, 0);
        JOptionPane.showMessageDialog(null, "The total of all numbers multiplied together is: " + product + "!");

    }
    

    public static int multiply(int[] numbers, int index) {
        if (index == numbers.length) {
            return 1;
        }

        return numbers[index] * multiply(numbers, index + 1);
    }
}