package opdr3_2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame2 extends JFrame implements ActionListener{
	private JTextField tf;
	private JButton jb, jb2;
	
	public MyFrame2 (){
		setLayout (new FlowLayout());
		tf = new JTextField("", 20); add (tf);
				
		jb = new JButton ("Knop 1"); add (jb);
		jb.addActionListener(this);
		
		jb2 = new JButton ("Knop 2"); add (jb2);
		jb2.addActionListener(this);
		
		setSize(300,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == jb){
			tf.setText("Knop 1");	
		}
		if (event.getSource() == jb2){
			tf.setText("Knop 2");
		}
		
	}

}
