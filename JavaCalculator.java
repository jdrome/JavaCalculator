import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaCalculator implements ActionListener {
    
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel; // Holds all our buttons

    Font myFont = new Font("Nanum Pen Script", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator; // This will be for our operations like addition, subtraction, etc.
    
    JavaCalculator() {
        // Instantiate `Calculator` JFrame in constructor.
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null); // no layout for now

        // Instantiate textField in Constructor
        textField = new JTextField();
        textField.setBounds(60, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Instantiating Function Buttons to Frame
        // Note: All buttons except delButton and clrButton will go in JPanel. delButton and clrButton will sit in the frame independent of the other function and number buttons.
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        // Adds JButtons to functioButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        // `For` loop iterates through all function buttons and ActionListener, font, and focusable settings.
        for(int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); // Removes outliner on button
        }

        // Instantiates number buttons with `for` loop. Also instantiates settings for number burrons
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); // Instantiates number buttons here
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false); // Removes outliner on button
        }

        // Sets location for delButton and clrButton on Calculator frame
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        // Instantiates panel to hold buttons
        panel = new JPanel();
        panel.setBounds(60, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4, 10, 10)); // Creates grid layout

        // Adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add our different elements to our JFrame.
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main (String[] args) {
        JavaCalculator calculator = new JavaCalculator();
    }

    // This method listens for actions (clicks) and executies the appropriate calculator function
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add number buttons to textField
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i))); // When number button is clicked, add that button to calculator textField.
            }
        }

        // Add decimal button to textField
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        // Add add button functionality
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        // Add sub button functionality
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        // Add multiply button functionality
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        // Add div button functionality
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        // Add equal button functionality
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        
        // Add clear button functionality
        if(e.getSource() == clrButton) {
            textField.setText("");
        }
    }
}