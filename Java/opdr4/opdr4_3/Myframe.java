package opdr4_3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Myframe extends JFrame implements ActionListener {
	
	private JButton b1, b2, b3;
	private JTextField tf1, tf2, tf3;
	
	
	
	public Myframe(){
		setLayout(new FlowLayout());
		
		b1 = new JButton("Werp steen 1"); add(b1);
		b1.addActionListener(this);
		tf1 = new JTextField(10); add(tf1);
		b2 = new JButton("Werp steen 2"); add(b2);
		b2.addActionListener(this);
		tf2 = new JTextField(10); add(tf2);
		b3 = new JButton("Bereken de winst"); add(b3);
		b3.addActionListener(this);
		tf3 = new JTextField(10); add(tf3);
		
		setSize (200, 250);
		setVisible (true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	 
	
	
	public void actionPerformed(ActionEvent event){
		
		int playerpick = geworpenGetal();
		if (event.getSource() == b1){
			playerpick = geworpenGetal();
			tf1.setText(String.valueOf(geworpenGetal()));
			
		}
		int playerpick2 = geworpenGetal();
		if (event.getSource() == b2){
			playerpick2 = geworpenGetal();
			tf2.setText(String.valueOf(geworpenGetal()));
		}
		if (event.getSource() == b3){
			
			if (playerpick > playerpick2){
				tf3.setText("Gewonnen");
			}
			else tf3.setText("Verloren");
		}
		
	}
	private int geworpenGetal() {
		 return 1 + (int)(6 * Math.random()); 
		 }


	

}
