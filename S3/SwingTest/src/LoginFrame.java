import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginFrame extends JFrame implements ActionListener {
	
	
	JButton changePage = new JButton("Change Page");

	LoginFrame() {
		
		changePage.addActionListener(this);
		
		this.add(changePage);
		
		this.setTitle("Login Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 500, 500);
		this.setLayout(new GridLayout(1, 1));
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == changePage) {
			this.dispose();
			new ActuFrame();
		}
		
	}
	
	
}
