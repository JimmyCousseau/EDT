package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FirstFrame extends JFrame implements ActionListener {

	ImageIcon thisIcon = new ImageIcon("src/images/balon.png");
	JLabel label = new JLabel("Hola");
	JMenuBar menuBar1 = new JMenuBar();
	JMenu options = new JMenu("Options");
	JPanel panel = new JPanel();
	JPanel content1 = new JPanel();
	JPanel content2 = new JPanel();
	JButton changeContentFrame = new JButton("Hola");

	public FirstFrame() {
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setIconImage(thisIcon.getImage());
		this.setTitle("Mi primer práctica");
		this.setMinimumSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		options.add(new JMenuItem("Parametros"));
		menuBar1.setBackground(Color.WHITE);
		menuBar1.add(options);

		label.setIcon(thisIcon);

		panel.setBackground(Color.YELLOW);
		panel.add(label);
		panel.add(changeContentFrame);

		content1.setLayout(new BorderLayout());

		content1.add(menuBar1, BorderLayout.NORTH);
		content1.add(panel, BorderLayout.CENTER);

		this.setContentPane(content1);
		this.setJMenuBar(menuBar1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == changeContentFrame) {
			System.out.println("Heey");
			this.setContentPane(content2);
			this.revalidate();
		}

	}

	// @Override
	// public void paintComponent(Graphics g) {
	// g.drawImage(dibu, 0, 0, this);
	// g.setColor(Color.CYAN);
	// g.fillOval(500, 40, 50, 50);
	// for (int i=0; i<360; i=i+45) {
	// int x = (int) (Math.cos(Math.toRadians(i) * 50));
	// int y = (int) (Math.sin(Math.toRadians(i) * 50));
	// }
	// }
}
