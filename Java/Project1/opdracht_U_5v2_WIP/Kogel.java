package opdracht_U_5v2_WIP;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


	public class Kogel {

		private static final int dia = 30;// diameter kogels
		int mx = 270;
		int my = 450 + 10;
		private Game game;

		public Kogel(Game game) {
			this.game = game;
		}

		public void shoot() {
			mx = mx + 0;//placeholders die aangepast moeten worden als het kanon draait maar
			my = my - 1;
			if(collision()) my = game.t1.ty+20;// hot fix die de kogel laat stopen als hij het doel raakt
			if(collision()) mx = game.t1.tx+20;
		}

		public void paint(Graphics2D g) {
			if(collision()) g.setColor(Color.lightGray);
			g.fillOval(mx, my, 10, 10);
		}


		boolean collision() { // collision dectectie
			return game.t1.getBounds().intersects(getBounds());
		}

		public Rectangle getBounds() {// de border van het opject
			return new Rectangle(mx, my, dia, dia);
		}
		
		
		// de keyevent waar me je het kanon afschiet (incompleet)
		
//		public void keyPressed(KeyEvent e) {
		
	//		if (e.getKeyCode() == KeyEvent.VK_SPACE))
			

	//	}
	}
