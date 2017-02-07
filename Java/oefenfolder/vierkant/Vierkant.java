package vierkant;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Vierkant extends JFrame implements ActionListener {

	private JPanel p;
	private JTextField tf;
	private JButton b;

	public Vierkant() {
		setLayout(new FlowLayout());
		p = new JPanel();
		p.setPreferredSize(new Dimension(400, 400));
		p.setBackground(Color.WHITE);
		add(p);
		tf = new JTextField("", 15);
		add(tf);
		b = new JButton("Klik");
		add(b);
		b.addActionListener(this);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		Graphics g = p.getGraphics();
		p.update(g);
		String s = tf.getText();
		int cijfer = Integer.parseInt(s);
		int x = 10;
		int y = 10;
		int aantalPerRegel = 5;
		for (int i = 0; i < cijfer; i++) {
			if (i > 0 && i % aantalPerRegel == 0) {
				x = 10;
				y += 30;

			}

			x += 30;
			g.drawRect(x, y, 60, 60);

		}
	}

}
