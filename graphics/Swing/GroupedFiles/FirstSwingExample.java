package GroupedFiles;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class FirstSwingExample extends JFrame {

    FirstSwingExample() {
        JLabel label = new JLabel();
        label.setFont(new Font("Comic Sans", Font.BOLD, 12));

        JTextField textField = new JTextField();
        textField.setBounds(0, 0, 150, 30);

    
        JButton b = new JButton("click");//creating instance of JButton  
        b.setBounds(130, 100, 100, 40);//x axis, y axis, width, height
        b.addActionListener(e -> this.printSomething(textField.getText()));

        this.add(textField);
        this.add(b);//adding button in JFrame  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);//400 width and 500 height  
        this.setLayout(null);//using no layout managers  
        this.setVisible(true);//making the frame visible  
        this.setBackground(new Color(255, 255, 255));
    }
    
    public void printSomething(String text) {
        System.out.println(text);
    }
}
