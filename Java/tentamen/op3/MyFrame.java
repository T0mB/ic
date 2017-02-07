package op3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {
	private JPanel p1;
	private JLabel l1;
	private JTextField tf1;
	private JButton b1;
	
	public MyFrame(){
		setLayout(new FlowLayout());
		p1 = new JPanel(); add(p1);
		p1.setPreferredSize(new Dimension(550,550));
		p1.setBackground(Color.WHITE);
		l1 = new JLabel("aantal"); add(l1);
		tf1 = new JTextField(5); add(tf1);
		b1 = new JButton("Lees en Teken"); add(b1);
		b1.addActionListener(this);
		setSize(600, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent event){
		
		Graphics g = p1.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 550, 550);
		g.setColor(Color.BLACK);
		
		String s = tf1.getText();
		int aantal = 0;
		if (!s.equals("")){
			aantal = Integer.parseInt(s);			
			}
		
		if (event.getSource() == b1){
			int grootte = 500/aantal;
			int x = 250 - grootte/2, y = 250 - grootte/2;
			int breedte = grootte;
			for (int regel = 1; regel <= aantal; regel++) {
			g.drawRect(x, y, breedte, breedte);
			x = x - grootte/2;
			y = y - grootte/2;
			breedte = breedte + grootte;

			}
		}
			
			
			
			

	}
	
	
	
}
