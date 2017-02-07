package oef2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {
	
	private JPanel p;
	private JButton b;
	private JTextField tf;
	
	public MyFrame(){
		setLayout(new FlowLayout());
		p = new JPanel();
		p.setPreferredSize(new Dimension(300,300));
		p.setBackground(Color.WHITE); add(p);
		tf = new JTextField(4); add (tf);
		b = new JButton("Klik"); add(b);
		b.addActionListener(this);
		setSize(350,390);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
	public void actionPerformed(ActionEvent event){
		p.removeAll();
		Graphics g = p.getGraphics();
		String cijfer = tf.getText();
		int aantal = Integer.parseInt(cijfer);
		int x = 10;
		int y = 10;
		int aantalPerRegel = 5;
		
		for(int i = 0; i < aantal; i++){
			if(i % aantalPerRegel == 0){
				x = 10;
				y += 30;
			}
			x += 30;
			g.drawRect(x, y, 30, 30);
			
		}
		
	}

}






