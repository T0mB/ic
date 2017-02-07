package opdracht_U_5v2_WIP;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


	public class Target {

		private static final int dia = 30;
		int tx = 250;//(int)(Math.random()*370) + 10; de X cordinaat is nu tijdelijk vast voor het testen
		int ty = (int)(Math.random()*380) + -100;
		int p1y = ty+20;// de cordinaten van de spawnen als de target geraakt wordt
		int p2y = ty;
		int p3y = ty-20;
		int p1x = tx;
		int p2x = tx+20;
		int p3x = tx-20;
		
		private Game game;

		public Target(Game game) {
			this.game = game;
		}


		public void paint(Graphics2D g) {
			g.fillOval(tx, ty, dia, dia);
			if(collision()) g.setColor(Color.GREEN);
			if(collision()) g.fillOval(p1x, p1y, 10, 10);
			if(collision()) g.fillOval(p2x, p2y, 10, 10);
			if(collision()) g.fillOval(p3x, p3y, 10, 10);
		}
		
		
		
		private boolean collision() { // collison detectie
			return game.k1.getBounds().intersects(getBounds());
		}		
		
			
		

		public Rectangle getBounds() {// de border van het object
			return new Rectangle(tx, ty, dia, dia);
	}
	}
