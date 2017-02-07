package opdr3_1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame3 extends JFrame implements ActionListener{
	private JButton jb;
	private JLabel lab;

	public MyFrame3(){
		setLayout(new GridLayout(2, 1));
		getContentPane().setBackground(Color.WHITE);
		lab = new JLabel("?"); add(lab);
		jb = new JButton("Press me"); add(jb);
		jb.addActionListener(this);
		setSize(300,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event){
		lab.setText("Knop is 1 maal ingedrukt");
	}
}