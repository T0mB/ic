package hamster;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.*;

import javazoom.jl.player.Player;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class MyHamsterFrame extends JFrame implements ActionListener {

	private JPanel p;
	private JTextField tf;
	private JButton b;

	public MyHamsterFrame() {
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

	public void tekenHamsters(int aantalHamsters, Graphics g) {
		try {
			BufferedImage image = ImageIO.read(new File(
					"C:/Users/Tom/Pictures/hamster_front.jpg"));

			int x = 10;
			int y = 10;
			int aantalPerRegel = 5;
			for (int i = 0; i < aantalHamsters; i++) {
				if (i > 0 && i % aantalPerRegel == 0) {
					x = 10;
					y += 105;

				}
				
				g.drawImage(image, x, y, 100, 100, Color.WHITE, null);
				x += 105;
			}
		}

		catch (IOException ex) {
			Logger.getLogger(MyHamsterFrame.class.getName()).log(Level.SEVERE,
					null, ex);

		}
	}
	
	public void playAudio() {
	    String file = "C:/Users/Tom/Downloads/paul birken  return of the string.mp3";
	    try { 
	        FileInputStream fis = new FileInputStream(file);
	        Player playMP3 = new Player(fis);
	        playMP3.play();
	    } catch(Exception e) { 
	        e.printStackTrace();
	    }
	}

	public void actionPerformed(ActionEvent e) {
		Graphics g = p.getGraphics();
		p.update(g);
		String s = tf.getText();
		int cijfer = Integer.parseInt(s);
		tekenHamsters(cijfer, g);
		playAudio();

	}

}
