package opdracht_U_9;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

public class Pong {
	final static public int screenWidth = 800, screenHeight = 600;
	public List<Player> players = new ArrayList<Player>();
	public List<Ball> balls = new ArrayList<Ball>();
	
	private boolean lf_KEY_R = false; // was KEY_R down the previous frame?
	private boolean lf_KEY_SPACE = false; // was KEY_SPACE down the previous frame?
	
	private static enum State {INGAME, PAUSED, HIT};
	
	private float playerSpeedIncr = 0.1f;
	private int nBalls = 1;
	
	private State state;
	public Pong () {
		init();
		while (!Display.isCloseRequested()) {
			// Clear screen
			glClear(GL_COLOR_BUFFER_BIT);
			
			// Input
			input();
			
			// Logic
			if (state == State.INGAME) {
				// Update
				update();
			}
			
			// Render
			render();
			
			// Refresh
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	private void init() {
		// Window
		try {
			Display.setDisplayMode(new DisplayMode(screenWidth, screenHeight));
			Display.setTitle("Pong!");
			Display.create();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		// Game
		initGame();
	}
	
	private void initGame() {
		state = State.PAUSED;
		players.clear();
		balls.clear();
		
		//Players
		players.add(new Player());
		players.add(new Player());
		initPlayers();
		
		// Ball
		for (int index = 0; index < nBalls; index++) {
			balls.add(new Ball());
		}
		initBalls();

		System.out.println("Game finished initializing");
	}
	
	private void render() {
		for (Player p : players) { p.draw(); }
		for (Ball b : balls) { b.draw(); }
	}
	
	private void update() {
		for (Player p : players) {
			p.update(); //Movement & screen collision
			
			//Player-Ball collision
			for (Ball b : balls) {
				if (b.getVX() < 0) {
					if ((b.getX() > p.getX() && b.getX() < p.getX() + p.getWidth()) &&
						(b.getY() + b.getHeight() > p.getY() && b.getY() < p.getY() + p.getHeight())) {
						b.setVX(b.getVX() * -1.15f);
						b.setVY(b.getVY() * 1.08f);
						players.get(0).addSpeed(playerSpeedIncr);
						players.get(1).addSpeed(playerSpeedIncr);
					}
				} else if (b.getVX() > 0) {
					if ((b.getX() + b.getWidth() > p.getX() && b.getX() + b.getWidth() < p.getX() + p.getWidth()) &&
						(b.getY() + b.getHeight() > p.getY() && b.getY() < p.getY() + p.getHeight())){
						b.setVX(b.getVX() * -1.15f);
						b.setVY(b.getVY() * 1.08f);
						players.get(0).addSpeed(playerSpeedIncr);
						players.get(1).addSpeed(playerSpeedIncr);
					}
				}
			}
		}
		for (Ball b : balls) {
			b.update();
			
			//Ball-screen collision(left/right)
			if (b.getX() <= 0) {
				b.setVX(0);
				b.setVY(0);
				players.get(0).setSpeed(3);
				players.get(1).setSpeed(3);
				players.get(0).getHB().hit(25);
				state = State.HIT;
				b.setColor(1.0f, 0.0f, 0.0f);
				
				if (players.get(0).getHB().getHealth() <= 0) {
					players.get(0).kill();
				}
			}
			if (b.getX() + b.getWidth() >= screenWidth - 1) {
				b.setVX(0);
				b.setVY(0);
				players.get(0).setSpeed(3);
				players.get(1).setSpeed(3);
				players.get(1).getHB().hit(25);
				state = State.HIT;
				b.setColor(1.0f, 0.0f, 0.0f);
				if (players.get(1).getHB().getHealth() <= 0) {
					players.get(1).kill();
				}
			}
		}
	}
	
	private void input() {
		// Exit
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Display.destroy();
			System.exit(0);
		}
		// Reset
		if (Keyboard.isKeyDown(Keyboard.KEY_R) && !lf_KEY_R) {
			initGame();
			lf_KEY_R = true;
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_R)) {
			lf_KEY_R = false;
		}
		// Pause(and Hit)
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && !lf_KEY_SPACE) {
			if (state == State.PAUSED || state == State.HIT) {
				if (state == State.HIT) {
					if (!(players.get(0).isDead() || players.get(1).isDead())) {
						initBalls();
						initPlayers();
						state = State.PAUSED;
					}
				} else {
					state = State.INGAME;
				}
				System.out.println("Game unpaused");
			} else if (state == State.INGAME) {
				state = State.PAUSED;
				System.out.println("Game paused");
			}
			lf_KEY_SPACE = true;
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			lf_KEY_SPACE = false;
		}
		if (state == State.INGAME) {
			// Player 1 controls
			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				players.get(0).setVY(-players.get(0).getSpeed());
			} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
					players.get(0).setVY(players.get(0).getSpeed());
			} else {
				players.get(0).setVY(0);
			}
			// Player 2 controls
			if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				players.get(1).setVY(-players.get(1).getSpeed());
			} else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
					players.get(1).setVY(players.get(1).getSpeed());
			} else {
				players.get(1).setVY(0);
			}
		}
	}
	
	public void initBalls() {
		for (Ball b : balls) {
			b.setPos((screenWidth - players.get(0).getWidth()) / 2, (screenHeight - balls.get(0).getHeight()) / 2);
			b.setColor(0.0f, 0.0f, 1.0f);
			Random random = new Random();
			float f = 0.0f;
			while (f > -5.0f && f < 5.0f) { // Horizontal speed, range: 5.0-7.5
				f = (random.nextFloat() - 0.5f) * 15;
			}
			b.setVX(f);
			
			f = 0.0f;
			while (f > -1.0f && f < 1.0f) { // Vertical speed, range: 1.0-3.0
				f = (random.nextFloat() - 0.5f) * 6;
			}
			b.setVY(f);

			System.out.println("Ball vx=" + b.getVX() + ", vy=" + b.getVY());
		}
	}
	
	public void initPlayers() {
		// Player 1
		players.get(0).setPos(25, (screenHeight - players.get(0).getHeight()) / 2);
		players.get(0).getHB().setX(25 + players.get(0).getWidth());
		
		// Player 2
		players.get(1).setPos(screenWidth - players.get(1).getWidth() - 25, (screenHeight - players.get(1).getHeight()) / 2);
		players.get(1).getHB().setX(screenWidth - players.get(1).getWidth() - 25 - players.get(1).getHB().getWidth());
				
	}
}
