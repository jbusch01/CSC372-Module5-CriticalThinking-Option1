import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class ProductRecursion extends JFrame {
    private JPanel inputPanel;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private int fieldCount = 0;
    private final int MAX_FIELDS = 5;

    public ProductRecursion() {
        setTitle("Enter 5 Whole Numbers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        addNewInputField();

        JScrollPane scrollPane = new JScrollPane(inputPanel);
        add(scrollPane);
    }

    private void addNewInputField() {
        if (fieldCount >= MAX_FIELDS) return;

        JTextField inputField = new JTextField();
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        inputField.requestFocusInWindow();

        inputField.addActionListener(e -> {
            String text = inputField.getText().trim();

            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a whole number.");
                return;
            }

            try {
                int value = Integer.parseInt(text);
                numbers.add(value);
                inputField.setEditable(false);
                fieldCount++;

                if (fieldCount == MAX_FIELDS) {
                    int product = multiply(numbers, 0);
                    JOptionPane.showMessageDialog(this, "Product: " + product);
                } else {
                    addNewInputField();
                }
                SwingUtilities.invokeLater(() -> {
                    inputPanel.revalidate();
                    inputPanel.repaint();
                    Component[] components = inputPanel.getComponents();
                    if (components.length > 0 && components[components.length - 1] instanceof JTextField) {
                        ((JTextField) components[components.length - 1]).requestFocusInWindow();
                    }
                });
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a whole number (no commas or decimals).");
            }
        });

        inputPanel.add(inputField);
    }   

    private int multiply(ArrayList<Integer> numbers, int index) {
        if (index == numbers.size()) return 1;
        return numbers.get(index) * multiply(numbers, index + 1);
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductRecursion app = new ProductRecursion();
            app.setVisible(true);
        });
    }
}