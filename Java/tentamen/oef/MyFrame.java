package oef;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {
	
	private JLabel l1, l2;
	private JTextField tf1, tf2;
	private JButton b1;
	
	public MyFrame(){
		setLayout(new FlowLayout());
		l1 = new JLabel("getal?"); add(l1);
		tf1 = new JTextField(7); add(tf1);
		b1 = new JButton("Check Getal"); add(b1);
		b1.addActionListener(this);
		l2 = new JLabel("Antwoord"); add(l2);
		tf2 = new JTextField(20); add(tf2);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		
		String s = tf1.getText();
		int getal = Integer.parseInt(s);
		String tekst = "";
		
	
		if(getal < 1){
			tekst = "te klein";
			
			if(getal < 0){
				tekst = "negatief";
			}
		}
		else{
			tekst = "juist";
		}
		tf2.setText(tekst);
	}
	
}
