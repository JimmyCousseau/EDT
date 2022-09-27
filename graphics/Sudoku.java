import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.util.HashMap;

public class Sudoku extends JFrame{
    
    public Sudoku(String title) {

        super(title);

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(l);

        /* ImageIcon img = new ImageIcon("tips.gif"); */
        JButton bouton = new JButton("Mon bouton");
        JButton icon = new JButton("Hello");
        HashMap<String, JTextField> tab = new HashMap<String, JTextField>();
        JPanel p = new JPanel(new GridLayout(9, 9));
        setContentPane(p);
        for (int i = 0; i < 81; i++) {
            tab.put(Integer.toString(i), new JTextField());
            p.add(tab.get(Integer.toString(i)));
        }
        setContentPane(p);
    }

    public static void main(String[] args) {
        Sudoku frame = new Sudoku("Sudoku");
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
