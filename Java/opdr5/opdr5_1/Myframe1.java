package opdr5_1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Myframe1 extends JFrame implements ActionListener
{
private JButton b;
private JPanel p;
	
	public Myframe1() {
		setLayout(new FlowLayout());
		p = new JPanel(); add(p);
		p.setPreferredSize(new Dimension(250, 100));
		p.setBackground(Color.WHITE);
		b = new JButton("go"); add(b);
		b.addActionListener(this);
		setSize(280, 180);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Graphics g = p.getGraphics();
		int x = 10, y = 50;
		for ( int i = 0 ; i <= 45 ; i++) {
			g.drawString("" + i * 5, x, y);
			x = x + 20; // dwz: xnieuw = xoud + 20;
			}
	}
}