package opdr5_2;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

@SuppressWarnings("serial")
public class Myframe2 extends JFrame implements ActionListener{
	
	private JButton b;
	private JPanel p;
	private JTextField tf;

		public Myframe2() {
			setLayout(new FlowLayout());
			p = new JPanel(); add(p);
			p.setPreferredSize(new Dimension(500, 450));
			p.setBackground(Color.WHITE);
			tf = new JTextField(20); add(tf);
			b = new JButton("Press me"); add(b);
			b.addActionListener(this);
			
			setSize(540, 540);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		
		
		public void actionPerformed(ActionEvent e) {
			String s = tf.getText();
			if (s.equals("")) {
				s = "Java";
				}
			
			
			Graphics g = p.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.BLACK);
			int x = 10, y = 50;
			for ( int i = 1 ; i <= 10 ; i = i + 1) {
				g.drawString(s, x, y);
				x = x + 7* s.length() + 15; // dwz: xnieuw = xoud + 7*lengte +15;
				
			Graphics2D g2d = (Graphics2D)g;
			AffineTransform at = new AffineTransform();
			at.setToRotation(Math.PI / 6.0);
			g2d.setTransform(at);
			
			    }
			}
}




