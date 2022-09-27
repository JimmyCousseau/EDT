package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class FirstFrame implements ActionListener {
	private JPanel contenedor;
	private JPanel contenedor2;
	private JMenuBar menuBar;
	private JMenu firstMenu;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem exit;
	private JFrame ventana;
	private JButton button;
	private JLabel label;
	private ImageIcon img;
	private JRadioButton rbtn1;
	private JRadioButton rbtn2;
	private ButtonGroup btnGrp;

	public FirstFrame() {
		ventana = new JFrame();
		menuBar = new JMenuBar();
		firstMenu = new JMenu("First Menu");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Guardar");
		exit = new JMenuItem("Exit");
		contenedor = new JPanel();
		contenedor2 = new JPanel();
		button = new JButton("Test");
		label = new JLabel("Hola");
		img = new ImageIcon("src/images/balon.png");
		rbtn1 = new JRadioButton("Hola", true);
		rbtn2 = new JRadioButton("Adios");
		btnGrp = new ButtonGroup();

		ventana.setSize(700, 600);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventana.setTitle("Tema 2 - First Frame");
		ventana.setLayout(new BorderLayout());
		ventana.setMinimumSize(new Dimension(700, 600));

		abrir.addActionListener(this);
		guardar.addActionListener(this);
		exit.addActionListener(this);
		button.addActionListener(this);

		label.setIcon(img);

		firstMenu.add(abrir);
		firstMenu.add(guardar);
		firstMenu.add(exit);

		menuBar.add(firstMenu);

		btnGrp.add(rbtn1);
		btnGrp.add(rbtn2);

		contenedor2.setLayout(new GridLayout(3, 1));
		contenedor2.setBackground(Color.white);
		contenedor2.add(label);
		contenedor2.add(rbtn1);
		contenedor2.add(rbtn2);

		contenedor.setLayout(new BorderLayout());
		contenedor.setBackground(Color.BLUE);

		contenedor.add(contenedor2, BorderLayout.CENTER);
		contenedor.add(button, BorderLayout.SOUTH);
		contenedor.setBounds(10, 10, 10, 10);

		ventana.setJMenuBar(menuBar);
		ventana.setContentPane(contenedor);
		ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			ventana.dispose();
		} else if (e.getSource() == button) {
			contenedor.setBackground(Color.black);

		}

	}
}
