package opdr4_4;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;


@SuppressWarnings("serial")
public class Myframe extends JFrame implements ActionListener {
	private JButton b1, b2;
	private JLabel l1;
	
	public Myframe(){
		setLayout(new FlowLayout());
		
		l1 = new JLabel("Maak uw keuze"); add(l1);
		l1.setPreferredSize(new Dimension(200, 150));
		l1.setBackground(Color.WHITE);
		l1.setOpaque(true);
		
		b1 = new JButton("Open"); add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Gesloten"); add(b2);
		b2.addActionListener(this);
	
		setSize(250,250);;
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		
	
		if (e.getSource() == b1){
			l1.setForeground(Color.BLUE);
			l1.setText("Heden Open");
			}
		
		if (e.getSource() == b2){
			l1.setForeground(Color.RED);
			l1.setText("Morgen Gesloten");
		}
		
		
	}
	
	

}








