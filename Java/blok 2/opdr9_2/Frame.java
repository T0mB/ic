package opdr9_2;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	private JLabel l1, l2, l3, l4;
	private JTextField tf1, tf2;
	private JButton b1, b2;
	private JPanel p;
	private ArrayList<String> woord = new ArrayList<String>(); 

	private int poging = 0;
	private String antwoord;

	public Frame() {
		setLayout(new FlowLayout());
		l1 = new JLabel("Voer woord in");
		add(l1);
		tf1 = new JTextField(14);
		add(tf1);
		b1 = new JButton("Speler1");
		add(b1);
		b1.addActionListener(this);
		p = new JPanel();
		add(p);
		p.setPreferredSize(new Dimension(300, 300));
		p.setBackground(Color.WHITE);
		l2 = new JLabel("Geef letter");
		add(l2);
		tf2 = new JTextField(3);
		add(tf2);
		b2 = new JButton("Speler2");
		add(b2);
		b2.addActionListener(this);
		l3 = new JLabel("Geraden: ");
		add(l3);
		l4 = new JLabel(" ");
		add(l4);

		setSize(370, 420);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == b1 || event.getSource() == tf1) {
			woord.clear();
			antwoord = tf1.getText().toLowerCase();
			if (antwoord.length() < 3 || antwoord.length() > 8) {
				antwoord = "";
			} else {
				for (int i = 0; i < antwoord.length(); i++) {
					woord.add(" ");
				}
				poging = 0;
				tf1.setText("");
				tf1.setEnabled(false);
				b1.setEnabled(false);
				tf2.setEnabled(true);
				b2.setEnabled(true);
				l3.setText("geraden: ");
				
				
			}
		} else if (event.getSource() == b2 || event.getSource() == tf2) {
			String letter = tf2.getText();
			if (letter.length() != 1) {
				return;
			}
			
			tf2.setText("");
			String str = antwoord;
			while (str.contains(letter)) {
				int index = str.indexOf(letter);
				woord.set(index, letter);
				l3.setText("geraden: " + ALtoString(woord));
				str = str.replaceFirst(letter, " ");
			}
			if (!antwoord.contains(letter))
				poging++;

			if (ALtoString(woord).equals(antwoord)) {
				tf1.setEnabled(true);
				b1.setEnabled(true);
				tf2.setEnabled(false);
				b2.setEnabled(false);
				l3.setText("Gewonnen");
			}
		

		Graphics g = p.getGraphics();

		if (poging > 0) {
			g.drawLine(100, 180, 120, 180);
			g.drawLine(110, 180, 110, 150);
		}
		if (poging > 1) {
			g.drawLine(110, 145, 110, 125);
		}
		if (poging > 2) {
			g.drawLine(110, 120, 110, 100);
		}
		if (poging > 3) {
			g.drawLine(115, 100, 135, 100);
		}
		if (poging > 4) {
			g.drawLine(140, 100, 160, 100);
		}
		if (poging > 5) {
			g.drawLine(160, 105, 160, 125);
		}
		if (poging > 6) {
			g.drawOval(153, 130, 15, 15);
		}
		if (poging > 7) {
			g.drawLine(160, 145, 160, 170);
		}
		if (poging > 8) {
			g.drawLine(150, 150, 170, 150);
		}
		if (poging > 9) {
			g.drawLine(160, 171, 150, 185);
			g.drawLine(160, 171, 170, 185);

		}
		}
	}

	private String ALtoString(ArrayList<String> woord) {
		String str = "";
		for (int i = 0; i < woord.size(); i++) {
			str += woord.get(i);
		}
		return str;

	}

}
