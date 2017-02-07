package opdracht_U_5v2_WIP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;



import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel {

	int a = 270;//positie kanon
	int b = 450;
	
	
	Kogel k1 = new Kogel(this);
	Target t1 = new Target(this);
	

	private void shoot() {
		k1.shoot();
		if(k1.collision()) return;//zou de method moeten stoppen maar werkt niet dus zit er een workaround in de Kogel.class
	
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.red);
		Rectangle rekt = new Rectangle(a, b, 10, 40);
		g2d.fill(rekt);

		k1.paint(g2d);// tekent de kogel
		t1.paint(g2d);// tekent de target

	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Pop");
		Game game = new Game();
		frame.add(game);
		frame.setSize(540, 540);
		frame.getContentPane().setBackground(Color.GREEN);//werkt niet
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {	//de animatie-loop voor de kogel
			game.shoot();
			game.repaint();
			Thread.sleep(10);	// 1 miliseconde delay in de loop
		}
	}
}