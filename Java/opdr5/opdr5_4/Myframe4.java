package opdr5_4;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
@SuppressWarnings("serial")
public class Myframe4 extends JFrame implements ActionListener{
	private JButton b;
	private JPanel p;
	public Myframe4() {
		setLayout(new FlowLayout());
		p = new JPanel(); add(p);
		p.setPreferredSize(new Dimension(150, 150));
		p.setBackground(Color.WHITE);
		b = new JButton("Press me"); add(b);
		b.addActionListener(this);
		setSize(200, 250); setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	public void actionPerformed(ActionEvent e) {
	
		
	
	if(e.getSource() == b){
		Graphics g = p.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 350);
		g.setColor(Color.BLACK);
		int x = 10, y = 20;
		for (int regel = 1 ; regel <= 4 ; regel++ ) {
			for ( int hori = 1 ; hori <= 6 ; hori++) {
				
				g.drawRect(10, 10, 10, 10);
				x = x + 15 + 15;
				g.drawRect(10, 20, 10, 10);
				x = x + 15 +15;
				g.drawRect(20,20, 10, 10);
				x = x + 15 +15;
				g.drawRect(10, 30, 10, 10);
				x = x +15 +15;
				g.drawRect(20, 30, 10, 10);
				x = x +15 +15;
				g.drawRect(30, 30, 10, 10);
				x = x +15 +15;
				g.drawRect(10, 40, 10, 10);
				x = x +15 +15;
				g.drawRect(20, 40, 10, 10);
				x = x +15 +15;
				g.drawRect(30, 40, 10, 10);
				x = x +15 +15;
				g.drawRect(40, 40, 10, 10);
				x = x +15 +15;
				}
			x = 10; y = y + 15 + 15;
			}
		
		}
		
	}
}
