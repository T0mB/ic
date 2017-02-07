package opdr9_3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {

	private JLabel l1 = new JLabel("                    ");
	private double getal1 =0.0;
	private double getal2 =0.0;
	private String actie ="";
	private String[] knoppen = { "7", "8", "9", "/", "4", "5", "6", "*", "1",
			"2", "3", "+", "C", "0", "=", "-" };
	private LinkedHashMap<String, JButton> button = new LinkedHashMap<String, JButton>();
	

	public Frame() {

		setLayout(new FlowLayout());
		
		add(l1);
		l1.setPreferredSize(new Dimension(390, 20));
		for (int i = 0; i < 16; i++) {
			button.put(knoppen[i], new JButton(knoppen[i]));
			add(button.get(knoppen[i]));
			button.get(knoppen[i]).setPreferredSize(new Dimension(90, 65));
			button.get(knoppen[i]).addActionListener(this);
		}
		setSize(410, 410);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button.get("1")) {
			l1.setText(l1.getText() + "1");
		}
		if (e.getSource() == button.get("2")) {
			l1.setText(l1.getText() + "2");
		}
		if (e.getSource() == button.get("3")) {
			l1.setText(l1.getText() + "3");
		}
		if (e.getSource() == button.get("4")) {
			l1.setText(l1.getText() + "4");
		}
		if (e.getSource() == button.get("5")) {
			l1.setText(l1.getText() + "5");
		}
		if (e.getSource() == button.get("6")) {
			l1.setText(l1.getText() + "6");
		}
		if (e.getSource() == button.get("7")) {
			l1.setText(l1.getText() + "7");
		}
		if (e.getSource() == button.get("8")) {
			l1.setText(l1.getText() + "8");
		}
		if (e.getSource() == button.get("9")) {
			l1.setText(l1.getText() + "9");
		}
		if (e.getSource() == button.get("0")) {
			l1.setText(l1.getText() + "0");
		}
		if (e.getSource() == button.get("/")) {
			actie = "/";
			getal1 = Double.parseDouble(l1.getText());
			l1.setText("                        ");
		}
		if (e.getSource() == button.get("*")) {
			actie = "*";
			getal1 = Double.parseDouble(l1.getText());
			l1.setText("                        ");
		}
		if (e.getSource() == button.get("+")) {
			actie = "+";
			getal1 = Double.parseDouble(l1.getText());
			l1.setText("                        ");
		}
		if (e.getSource() == button.get("-")) {
			actie = "-";
			getal1 = Double.parseDouble(l1.getText());
			l1.setText("                        ");
		}
		if (e.getSource() == button.get("C")) {
			l1.setText("                        ");
		}
		if (e.getSource() == button.get("=")) {
			getal2 = Double.parseDouble(l1.getText());
			
			double result = 0;
			if (actie.equals("/"))
				result = getal1 / getal2;
			if (actie.equals("*"))
				result = getal1 * getal2;
			if (actie.equals("+"))
				result = getal1 + getal2;
			if (actie.equals("-"))
				result = getal1 - getal2;
			
			
			
			l1.setText("                        " + (result));
		}
		
		

	}
}
