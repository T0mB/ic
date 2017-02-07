package opdr4_2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Myframe extends JFrame implements ActionListener {
	
	private JLabel l1, l2;
	private JButton b1, b2, b3, b4;
	private JTextField tf1;
	private String code = "331";
	
	public Myframe(){
		setLayout(new FlowLayout());
		
		l1 = new JLabel("Raad de geheime code"); add(l1);
		b1 = new JButton("1"); add(b1);
		b1.addActionListener(this);
		b2 = new JButton("2"); add(b2);
		b2.addActionListener(this);
		b3 = new JButton("3"); add(b3);
		b3.addActionListener(this);
		tf1 = new JTextField(7); add(tf1);
		l2 = new JLabel("uitvoer"); add(l2);
		b4 = new JButton("clear"); add (b4);
		b4.addActionListener(this);
		
		
		setSize(200,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		String antwoord = tf1.getText();
		if (e.getSource() == b1){
			tf1.setText(antwoord + "1");
		}
		
		if (e.getSource() == b2){
			tf1.setText(antwoord +"2");
		}
		
		if (e.getSource() == b3){
			tf1.setText(antwoord + "3");
		}
		
		antwoord = tf1.getText();
		
		if (antwoord.equals(code)){
			tf1.setText("Gewonnen");
			}
		
		if (e.getSource() == b4){
			tf1.setText("");
		}
	}

}






