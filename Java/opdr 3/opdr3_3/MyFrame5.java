package opdr3_3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame5 extends JFrame implements ActionListener{
	private JButton jb1;
	private JPanel p;

	public MyFrame5(){
		setLayout(new FlowLayout());
		p = new JPanel();
		p.setPreferredSize(new Dimension(300,300));
		p.setBackground(Color.WHITE); add(p);
		jb1 = new JButton("Teken"); add(jb1);
		jb1.addActionListener(this);
		setSize(300,400); setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}




public void actionPerformed(ActionEvent event){
	Graphics g = p.getGraphics();
	g.drawLine(33, 44, 66, 10);
	g.drawRect(20, 20, 90, 90);
	g.drawArc(30, 40, 200, 300, 10, 20);
	g.fillOval(40, 40, 40, 40);
	
}
}