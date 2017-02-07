package opdracht_u_5;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {

	private JPanel pan;
	private JLabel lab;
	private JButton lin;
	private JButton rec;
	private JButton schiet;
	private JButton sta;
	private JButton sto;
	private Timer t;
	private int timer = 0;
	
	AffineTransform at;

	int doelwitX;
	int doelwitY;
	Rectangle rekt;
	Graphics2D g2d;
	
	public MyFrame() {
		
		setLayout(new FlowLayout());
		setSize(540,540);
		
	    t = new Timer(1000, this);
	    t.addActionListener(this);
	    
		
		pan = new JPanel();
	    pan.setPreferredSize(new Dimension(400, 400));
	    pan.setBackground(Color.WHITE); 
	    pan.setLayout(new FlowLayout());
	    pan.add(lab = new JLabel(""));
		add(pan);
		
		lin = new JButton("draai naar links");
		add(lin);
		lin.addActionListener(this);
		
		
		rec = new JButton("draai naar rechts");
		add(rec);
		rec.addActionListener(this);
		
		schiet = new JButton("schiet");
		add(schiet);
		//schiet.addActionListener(this);
		
		sta = new JButton("start");
		add(sta);
		sta.addActionListener(this);
		
		sto = new JButton("stop");
		add(sto);
		sto.addActionListener(this);
		
		at = new AffineTransform();
		
		
		doelwitX = (int)(Math.random()*370) + 10;
		doelwitY = (int)(Math.random()*380) + -100;
		
		rekt = new Rectangle(200, 370, 10, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}



	public void actionPerformed(ActionEvent e) {
		g2d = (Graphics2D) pan.getGraphics();	
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.black);
		
		if(e.getSource() == sta){
			t.start();
			g2d.setColor(Color.black);
		}
		
		if(e.getSource() == sto){
			lab.setText("");
			timer = 0;
			t.stop();
			g2d.setColor(Color.WHITE);
			g2d.fill(new Rectangle(0, 0, 500, 400));
		}
		
		if(e.getSource() == rec){
			draai(5);
			g2d.setTransform(at);
			g2d.setColor(Color.black);
			g2d.draw(rekt); 
			
		}
		
		if(e.getSource() == lin){
			draai(-5);
			g2d.setTransform(at);			
			g2d.setColor(Color.black);
			g2d.draw(rekt); 
			
		}
	
		if(e.getSource() == schiet){

		}
		
		if(e.getSource()== t){
			timer = timer + 1;
			
			if(timer == 60){
				lab.setText("time's up");
				schiet.setEnabled(false);
			}
		}
		draw();
	}
	private void draw() {
		pan.getGraphics().clearRect(0, 0, 400, 400);
		g2d.draw(rekt);
		((Graphics2D) pan.getGraphics()).draw(new Ellipse2D.Double(doelwitX, doelwitY, 40, 40));
	}
	private void draai(float rad) {
		at.rotate(Math.toRadians(rad), rekt.getCenterX(), rekt.getCenterY());
	}
}
