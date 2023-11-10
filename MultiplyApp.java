package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplyApp {
    private JFrame frame;
    private JTextField num1Field;
    private JTextField num2Field;
    private JButton multiplyButton;
    private JTextArea resultArea;

    public MultiplyApp() {
        frame = new JFrame("Multiply Two Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel num1Label = new JLabel("Number 1: ");
        num1Field = new JTextField(10);

        JLabel num2Label = new JLabel("Number 2: ");
        num2Field = new JTextField(10);

        multiplyButton = new JButton("Multiply");

        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplyNumbers();
            }
        });

        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(multiplyButton);
        frame.add(resultArea);

        frame.pack();
        frame.setVisible(true);
    }

    private void multiplyNumbers() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = num1 * num2;
            resultArea.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MultiplyApp();
            }
        });
    }
}
