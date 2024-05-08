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
    
    JavaCalculator() {

    }
    public static void main (String[] args) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}