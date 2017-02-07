package opdr5_3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Myframe3 extends JFrame implements ActionListener{
	private JButton b;
	private JPanel p;
	private JTextField tf, tf2;
	private JLabel l1, l2;
	
	
	public Myframe3() {
		setLayout(new FlowLayout());
		p = new JPanel(); add(p);
		p.setPreferredSize(new Dimension(500, 350));
		p.setBackground(Color.WHITE);
		l1 = new JLabel("Aantal rijen"); add(l1);
		tf = new JTextField(7); add(tf);
		l2 = new JLabel("Aantal kolommen"); add(l2);
		tf2 = new JTextField(7); add(tf2);
		b = new JButton("Press me"); add(b);
		b.addActionListener(this);
		setSize(540, 450); setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
	
		
		
		
		
		Graphics g = p.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 350);
		g.setColor(Color.BLACK);
		
		int aantalRijen = Integer.parseInt(tf.getText());
		int aantalKolommen = Integer.parseInt(tf2.getText());
		
		int x = 10, y = 20;
		for (int kolom = 0 ; kolom < aantalKolommen ; kolom++ ) {
			for ( int rij = 0 ; rij < aantalRijen ; rij++) {
				g.drawOval(x, y, 20, 20);
				
				x = x + 20 + 15;
				}
			x = 10; y = y + 20 + 15;
			}
		}
	}


