package opdr4_1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Myframe extends JFrame implements ActionListener	 {
	private JLabel lab1, lab2;
	private JTextField tf1;
	private JButton but1;
	
	public Myframe(){
		setLayout(new FlowLayout());
		
		lab1 = new JLabel("Tik maand nummer in"); add(lab1);
		tf1 = new JTextField(7); add(tf1);
		but1 = new JButton("Lees in"); add(but1);
		but1.addActionListener(this);
		lab2 = new JLabel("Uitvoer"); add(lab2);
		
		setSize(150,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
			
		}
	
	
	
	public void actionPerformed(ActionEvent e){
	
		int maand = Integer.parseInt(tf1.getText());
		String s = "";
		System.out.println(maand);
		
		switch(maand){
		case 1: s ="Januari"; break;
		case 2: s ="Februari"; break;
		case 3: s ="Maart"; break;
		case 4: s ="April"; break;
		case 5: s ="Mei"; break;
		case 6: s ="Juni"; break;
		case 7: s ="Juli"; break;
		case 8: s ="Augustus"; break;
		case 9: s ="September"; break;
		case 10: s ="Oktober"; break;
		case 11: s ="November"; break;
		case 12: s ="December"; break;
		default: s ="ongeldig"; break;
			
		}
		lab2.setText(s);
	
		
	}

}






