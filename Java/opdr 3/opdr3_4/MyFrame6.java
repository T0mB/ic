package opdr3_4;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
@SuppressWarnings("serial")
public class MyFrame6 extends JFrame implements ActionListener{
	
	private JTextField tfA, tfB, tfC;
	private JButton but;
	
	public MyFrame6() {
		setLayout (new FlowLayout());
		

		tfA = new JTextField(7); add(tfA);
		
		
		tfB = new JTextField (7); add(tfB);
		
		but = new JButton ("Bereken"); add(but);
		but.addActionListener(this);
		
		tfC = new JTextField(7); add(tfC);
		tfC.setEditable(false);
		tfC.setBackground(Color.WHITE);
		add(tfC);
		
		setSize(150, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
	public void actionPerformed(ActionEvent e){
		String sL = tfA.getText();
		int lengte = Integer.parseInt(sL);
		String sB = tfB.getText();
		int breedte = Integer.parseInt(sB);		
		int oppervlakte = lengte * breedte;
		tfC.setText("" + oppervlakte);
	}
	
	
	
}
