package opdr9_1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {

	private JButton[] button = new JButton[9];
	private int poging = 0;
	private String winnaar;
	

	public Frame() {

		setLayout(new GridLayout(3, 3));
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		knoppen();

	}

	public void knoppen() {
		poging = 0;
		for (int i = 0; i < 9; ++i) {
			button[i] = new JButton("");
			button[i].addActionListener(this);
			add(button[i]);
		}
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button[0] && poging % 2 == 0) {
			button[0].setText("x");
			poging++;
			button[0].setEnabled (false);

		} else if (e.getSource() == button[0] && poging % 2 != 0) {
			button[0].setText("o");
			poging++;
			button[0].setEnabled (false);
		}

		if (e.getSource() == button[1] && poging % 2 == 0) {
			button[1].setText("x");
			poging++;
			button[1].setEnabled (false);

		} else if (e.getSource() == button[1] && poging % 2 != 0) {
			button[1].setText("o");
			poging++;
			button[1].setEnabled (false);
		}

		if (e.getSource() == button[2] && poging % 2 == 0) {
			button[2].setText("x");
			poging++;
			button[2].setEnabled (false);

		} else if (e.getSource() == button[2] && poging % 2 != 0) {
			button[2].setText("o");
			poging++;
			button[2].setEnabled (false);
		}

		if (e.getSource() == button[3] && poging % 2 == 0) {
			button[3].setText("x");
			poging++;
			button[3].setEnabled (false);

		} else if (e.getSource() == button[3] && poging % 2 != 0) {
			button[3].setText("o");
			poging++;
			button[3].setEnabled (false);
		}

		if (e.getSource() == button[4] && poging % 2 == 0) {
			button[4].setText("x");
			poging++;
			button[4].setEnabled (false);

		} else if (e.getSource() == button[4] && poging % 2 != 0) {
			button[4].setText("o");
			poging++;
			button[4].setEnabled (false);
		}

		if (e.getSource() == button[5] && poging % 2 == 0) {
			button[5].setText("x");
			poging++;
			button[5].setEnabled (false);

		} else if (e.getSource() == button[5] && poging % 2 != 0) {
			button[5].setText("o");
			poging++;
			button[5].setEnabled (false);
		}

		if (e.getSource() == button[6] && poging % 2 == 0) {
			button[6].setText("x");
			poging++;
			button[6].setEnabled (false);

		} else if (e.getSource() == button[6] && poging % 2 != 0) {
			button[6].setText("o");
			poging++;
			button[6].setEnabled (false);
		}

		if (e.getSource() == button[7] && poging % 2 == 0) {
			button[7].setText("x");
			poging++;
			button[7].setEnabled (false);

		} else if (e.getSource() == button[7] && poging % 2 != 0) {
			button[7].setText("o");
			poging++;
			button[7].setEnabled (false);
		}

		if (e.getSource() == button[8] && poging % 2 == 0) {
			button[8].setText("x");
			poging++;
			button[8].setEnabled (false);

		} else if (e.getSource() == button[8] && poging % 2 != 0) {
			button[8].setText("o");
			poging++;
			button[8].setEnabled (false);
		}
		
		if (button[0].getText() != "" && button[0].getText() == button[1].getText() && button[1].getText() == button[2].getText()) {
			winnaar = button[0].getText();
			JOptionPane.showMessageDialog(null, "Gefeliciteerd! Speler " + winnaar + " wint.");
		}
		
		if (button[3].getText() != "" && button[3].getText() == button[4].getText() && button[4].getText() == button[5].getText()) {
			winnaar = button[3].getText();
			JOptionPane.showMessageDialog(null, "Gefeliciteerd! Speler " + winnaar + " wint.");
		}
		
		if (button[6].getText() != "" && button[6].getText() == button[7].getText() && button[7].getText() == button[8].getText()) {
			winnaar = button[6].getText();
			JOptionPane.showMessageDialog(null, "Gefeliciteerd! Speler " + winnaar + " wint.");
		}
		
		if (button[0].getText() != "" && button[0].getText() == button[3].getText() && button[3].getText() == button[6].getText()) {
			winnaar = button[0].getText();
			JOptionPane.showMessageDialog(null, "Gefeliciteerd! Speler " + winnaar + " wint.");
		}
		
		if (button[1].getText() != "" && button[1].getText() == button[4].getText() && button[4].getText() == button[7].getText()) {
			winnaar = button[1].getText();
			JOptionPane.showMessageDialog(null, "Gefeliciteerd! Speler " + winnaar + " wint.");
		}
		
		if (button[2].getText() != "" && button[2].getText() == button[5].getText() && button[5].getText() == button[8].getText()) {
			winnaar = button[2].getText();
			JOptionPane.showMessageDialog(null, "Gefeliciteerd! Speler " + winnaar + " wint.");
		}
		
		if (button[0].getText() != "" && button[0].getText() == button[4].getText() && button[4].getText() == button[8].getText()) {
			winnaar = button[0].getText();
			JOptionPane.showMessageDialog(null, "Gefeliciteerd! Speler " + winnaar + " wint.");
		}
		
		if (button[2].getText() != "" && button[2].getText() == button[4].getText() && button[4].getText() == button[6].getText()) {
			winnaar = button[2].getText();
			JOptionPane.showMessageDialog(null, "Gefeliciteerd! Speler " + winnaar + " wint.");
		}
		
		if(poging >8){
			JOptionPane.showMessageDialog(null, "gelijk");
		}

	}
	
	
	
	
}
















