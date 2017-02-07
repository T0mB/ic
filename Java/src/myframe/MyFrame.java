package myframe;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	private JLabel lab;
	
	public MyFrame(){
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.WHITE);
		lab = new JLabel("Hello World!");
		add(lab);
		lab.setForeground(Color.RED);
		setSize(250,160);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
