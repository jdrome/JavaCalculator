import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaCalculator implements ActionListener {
    
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton[] addButton, subButton, mulButton, divButton;
    JButton[] decButton, equButton, delButton, clrButton;
    JPanel panel; // Holds all our buttons

    Font myFont = new Font("Nanum Pen Script", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator; // This will be for our operations like addition, subtraction, etc.
    
    JavaCalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null); // no layout for now

        textField = new JTextField();
        textField.setBounds(60, 25, 300, 50);
        textField.setFont(myFont);

        frame.add(textField); // adds textField to frame
        frame.setVisible(true);
    }
    public static void main (String[] args) {
        JavaCalculator calculator = new JavaCalculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}