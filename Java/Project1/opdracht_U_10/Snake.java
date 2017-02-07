package opdracht_U_10;

import static org.lwjgl.opengl.GL11.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import opdracht_U_10.Player.Direction;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

public class Snake implements ActionListener {
	//Settings
	final static public int screenWidth = 800, screenHeight = screenWidth;
	final private int spelsnelheid = 100; // in ms
	final static public int gridResolutie = 32; // hoeveel hokjes breed en hoog is het speelveld
	final static public int aantalFood = 5;
	
	private boolean lf_KEY_R = false; // was KEY_R down the previous frame?
	private boolean lf_KEY_SPACE = false; // was KEY_SPACE down the previous frame?
	
	private Field field;
	public static enum State {INGAME, PAUSED, DEAD};
	private static State state;
	
	private static Timer timer;
	public Snake() {
		init();
		while (!Display.isCloseRequested()) {
			// Clear screen
			glClear(GL_COLOR_BUFFER_BIT);
			
			// Input
			input();
			
			// Logic
			// Wordt geupdate als de timer afgaat, dus gebeurt in de actionlistener
			
			// Render
			render();
			
			// Refresh
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		System.exit(0);
	}
	
	private void init() {
		// Window
		try {
			Display.setDisplayMode(new DisplayMode(screenWidth, screenHeight));
			Display.setTitle("Snake");
			Display.create();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, screenWidth, screenHeight, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		// Game
		initGame();
	}
	
	private void initGame() {
		state = State.PAUSED;
		field = new Field(gridResolutie, aantalFood);
		field.hideGrid();
		
		timer = new Timer(spelsnelheid, this);
		
		System.out.println("Game finished initializing");
	}
	
	private void render() {
		field.draw();
	}
	
	private void update() {
		field.update();
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
			if (state == State.PAUSED) {
				state = State.INGAME;
				timer.start();
				System.out.println("Game unpaused");
			} else if (state == State.INGAME) {
				state = State.PAUSED;
				timer.stop();
				System.out.println("Game paused");
			}
			lf_KEY_SPACE = true;
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			lf_KEY_SPACE = false;
		}
		if (state == State.INGAME) {
			// Player controls
			if (Keyboard.isKeyDown(Keyboard.KEY_W)){
				field.player.setDirection(Direction.NORTH);
			} else if (Keyboard.isKeyDown(Keyboard.KEY_S)){
				field.player.setDirection(Direction.SOUTH);
			}else if (Keyboard.isKeyDown(Keyboard.KEY_A)){
				field.player.setDirection(Direction.EAST);
			}else if (Keyboard.isKeyDown(Keyboard.KEY_D)){
				field.player.setDirection(Direction.WEST);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == timer) {
			update();
		}
	}
	
	public static void pause() {
		timer.stop();
		state = State.PAUSED;
	}
	
	public static void kill() {
		timer.stop();
		state = State.DEAD;
	}
	
	public static boolean isDead() {
		if (state == State.DEAD)
			return true;
		return false;
	}
}
