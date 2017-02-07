package opdr5_5;



import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class Circles extends JFrame implements ActionListener {
	
	private JButton Start, Stop;
	private JPanel Panel;
	private Timer t;
	
	public Circles(){
		setLayout(new FlowLayout());
		Panel = new JPanel(); add(Panel);
		Panel.setPreferredSize(new Dimension(400, 400));
		Start = new JButton("Start"); add(Start);
		Start.addActionListener(this);
		Stop = new JButton("Stop"); add(Stop);
		Stop.addActionListener(this);
		
		t = new Timer(1000, this);
		t.start();
		
		setSize(700, 700);
		setVisible(true);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
					
		
			
			
		  }
	
	public void paint(Graphics graphics)
	  {	      
	      int r= (int)Math.round((Math.random()*255));
	      int g= (int)Math.round((Math.random()*255));
	      int b= (int)Math.round((Math.random()*255));

	    	
	      int X_Coordinate = (int)Math.round((Math.random()*500));
	      int Y_Coordinate = (int)Math.round((Math.random()*500));

	      graphics.setColor(new Color(r,g,b));
	      graphics.fillOval(X_Coordinate,Y_Coordinate,40,40);
	      
	   
	  }

	
	
	
	public void actionPerformed(ActionEvent e){
			
			if(e.getSource() == t){
				
					repaint();
				
				
				}
			if(e.getSource() == Stop){
			t.stop();
			}
			
			if(e.getSource() == Start){
				t.start();
				repaint();
			}
				
				
			}
		


	


		

}
