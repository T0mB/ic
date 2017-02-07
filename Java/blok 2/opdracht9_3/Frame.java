package opdracht9_3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	private JLabel lab;
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
	private String functie = "";
	private double eerste = 0;
	private double tweede = 0;
	public Frame() {
		JPanel hulp = new JPanel();
		hulp.setLayout(new GridLayout(4, 4, 5, 5));
		hulp.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(hulp, BorderLayout.CENTER);
		JPanel hulp1 = new JPanel();
		add(hulp1, BorderLayout.NORTH);
		lab = new JLabel("               ");
		b1 = new JButton("0");
		b1.addActionListener(this);
		b2 = new JButton("1");
		b2.addActionListener(this);
		b3 = new JButton("2");
		b3.addActionListener(this);
		b4 = new JButton("3");
		b4.addActionListener(this);
		b5 = new JButton("4");
		b5.addActionListener(this);
		b6 = new JButton("5");
		b6.addActionListener(this);
		b7 = new JButton("6");
		b7.addActionListener(this);
		b8 = new JButton("7");
		b8.addActionListener(this);
		b9 = new JButton("8");
		b9.addActionListener(this);
		b10 = new JButton("9");
		b10.addActionListener(this);
		b11 = new JButton("C");
		b11.addActionListener(this);
		b12 = new JButton("/");
		b12.addActionListener(this);
		b13 = new JButton("*");
		b13.addActionListener(this);
		b14 = new JButton("+");
		b14.addActionListener(this);
		b15 = new JButton("-");
		b15.addActionListener(this);
		b16 = new JButton("=");	
		b16.addActionListener(this);
		hulp1.add(lab);
		hulp.add(b8);
		hulp.add(b9);
		hulp.add(b10);
		hulp.add(b12);
		hulp.add(b5);
		hulp.add(b6);
		hulp.add(b7);
		hulp.add(b13);
		hulp.add(b2);
		hulp.add(b3);
		hulp.add(b4);
		hulp.add(b14);
		hulp.add(b11);
		hulp.add(b1);
		hulp.add(b16);
		hulp.add(b15);
		pack();
		setSize(210, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			lab.setText(lab.getText() + "0");
		}
		if (e.getSource() == b2) {
			lab.setText(lab.getText() + "1");
		}
		if (e.getSource() == b3) {
			lab.setText(lab.getText() + "2");
		}
		if (e.getSource() == b4) {
			lab.setText(lab.getText() + "3");
		}
		if (e.getSource() == b5) {
			lab.setText(lab.getText() + "4");
		}
		if (e.getSource() == b6) {
			lab.setText(lab.getText() + "5");
		}
		if (e.getSource() == b7) {
			lab.setText(lab.getText() + "6");
		}
		if (e.getSource() == b8) {
			lab.setText(lab.getText() + "7");
		}
		if (e.getSource() == b9) {
			lab.setText(lab.getText() + "8");
		}
		if (e.getSource() == b10) {
			lab.setText(lab.getText() + "9");
		}
		if (e.getSource() == b11) {
			lab.setText("                        ");
			                      
		}
		if (e.getSource() == b12) {
			
			
			
			functie = "/";
			eerste = Double.parseDouble(lab.getText());
			lab.setText("          ");
		}
		if (e.getSource() == b13) {
			functie = "*";
			eerste = Double.parseDouble(lab.getText());
			lab.setText("                        ");
		}
		if (e.getSource() == b14) {
			functie = "+";
			eerste = Double.parseDouble(lab.getText());
			lab.setText("  ");
		}
		if (e.getSource() == b15) {
			functie = "-";
			eerste = Double.parseDouble(lab.getText());
			lab.setText("  ");
		
		}
		if (e.getSource() == b16) {
			                     
			
			tweede = Double.parseDouble(lab.getText());
			double antwoord = 0.0;
			if (functie.equals("/"))
				antwoord = eerste / tweede;
			if (functie.equals("*"))
				antwoord = eerste * tweede;
			if (functie.equals("+"))
				antwoord = eerste + tweede;
			if (functie.equals("-"))
				antwoord = eerste - tweede;
			NumberFormat num = NumberFormat.getInstance();
			num.setMinimumFractionDigits(2);
			num.setMaximumFractionDigits(5);
			lab.setText("                        " + num.format(antwoord));
		}
	}
}