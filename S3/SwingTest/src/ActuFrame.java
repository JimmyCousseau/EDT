import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ActuFrame {
	
	JFrame frame = new JFrame("Actualité");
	JPanel panel = new JPanel();
	JLabel label = new JLabel("<html><p>Bienvenue sur la page de l'actualité de la semaine</p></html>");
	
	ActuFrame() {
		
		label.setFont(new Font("Comic Sans", Font.BOLD, 20));
		label.setForeground(Color.WHITE);
		
		panel.add(label);
		panel.add(new JButton("1"));
		panel.add(new JButton("hello"));
		
		panel.setLayout(new FlowLayout());
		panel.setVisible(true);
		panel.setBackground(Color.BLACK);
		
		frame.add(panel);
		
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout());
		frame.setVisible(true);
	}
}
