package opdracht_U_10;

import java.util.ArrayList;
import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

public class Field extends Graphic {
	public static int gridSize;
	public enum Slot {EMPTY, FOOD, SNAKE};
	private static ArrayList<ArrayList<Slot>> slots;
	public Player player;
	
	private boolean showGrid;
	
	public Field(int gridSize, int nFood) {
		Field.gridSize = gridSize;
		clearGrid();
		
		player = new Player();
		placeFood(nFood);
		showGrid = true;
	}
	
	@Override
	public void draw() {
		//Verwijder de snake van het vorige scherm
		for (int x = 0; x < gridSize; x++) {
			for (int y = 0; y < gridSize; y++) {
				if (getSlot(x, y) == Slot.SNAKE) {
					setSlot(x, y, Slot.EMPTY);
				}
			}
		}
		//en teken hem opnieuw
		for (int i = -1; i < player.getLength(); i++) {
			setSlot(player.getPosition(i), Slot.SNAKE);
		}
		
		// loop over slots, teken colored quad als food of snake
		float res = (float)Snake.screenWidth / (float)gridSize;
		for (float x = 0; x < gridSize; x++) {
			for (float y = 0; y < gridSize; y++) {
				switch(getSlot((int)x, (int)y)) {
				case EMPTY:
					glColor3f(0.1f, 0.1f, 0.1f);
					break;
				case FOOD:
					glColor3f(0.0f, 1.0f, 0.0f);
					break;
				case SNAKE:
					glColor3f(player.red, player.green, player.blue);
					break;
				default:
					glColor3f(1.0f, 1.0f, 1.0f);
					break;
				}
				glBegin(GL_QUADS);
				glVertex2f(x*res, y*res);
				glVertex2f(x*res, y*res+res);
				glVertex2f(x*res+res,y*res+res);
				glVertex2f(x*res+res, y*res);
				glEnd();
			}
		}
		
		//outline
		glLineWidth(1.0f);
		glColor3f(0.8f, 0.8f, 0.8f);
		glBegin(GL_LINE_LOOP);
			glVertex2i(1, 0);
			glVertex2i(0, Snake.screenHeight);
			glVertex2i(Snake.screenWidth, Snake.screenHeight);
			glVertex2i(Snake.screenWidth, 1);
		glEnd();
		
		//grid
		if (showGrid) {
			for (float x = 0; x < gridSize; x++) {
				glBegin(GL_LINES);
					glVertex2f(x * res, 0.0f);
					glVertex2f(x * res, Snake.screenHeight);
				glEnd();
			}
			for (float y = 0; y < gridSize; y++) {
				glBegin(GL_LINES);
					glVertex2f(0, y * res);
					glVertex2f(Snake.screenWidth, y * res);
				glEnd();
			}
		}
	}
	
	@Override
	public void update() {
		player.update();
		if (Snake.isDead())
			return;
		
		switch (getSlot(player.getHead())) {
		case EMPTY:
			break;
		case FOOD: //Speler head is op een slot met food
			player.grow();
			placeFood(1);
			break;
		case SNAKE: //Speler head is op een slot met snake, dus een collision
			System.out.println("Game over! Score: " + player.score);
			player.setColor(1.0f, 0.0f, 0.0f);
			Snake.kill();
			break;
		default:
			break;
		
		}
	}
	
	public static Slot getSlot(int x, int y) {
		return slots.get(x).get(y);
	}
	
	public static Slot getSlot(Position pos) {
		return getSlot(pos.x, pos.y);
	}
	
	public static void setSlot(int x, int y, Slot slot) {
		try {
			slots.get(x).set(y, slot);
		} catch (Exception e) {
			
		}
	}
	
	public static void setSlot(Position pos, Slot slot) {
		setSlot(pos.x, pos.y, slot);
	}
	
	public void print() {
		String s = "";
		for (int x = 0; x < gridSize; x++) {
			s += x;
			for (int y = 0; y < gridSize; y++) {
				switch(getSlot(x, y)) {
				case EMPTY:
					s += " E ";
					break;
				case FOOD:
					s += " F ";
					break;
				case SNAKE:
					s += " S ";
					break;
				default:
					s += "   ";
					break;
				}
			}
			s += "\n";
		}
		System.out.println(s);
	}
	
	public void clearGrid() {
		slots = new ArrayList<ArrayList<Slot>>();
		for (int x = 0; x < gridSize; x++) {
			for (int y = 0; y < gridSize; y++) {
				slots.add(new ArrayList<Slot>());
				slots.get(x).add(Slot.EMPTY);
				setSlot(x, y, Slot.EMPTY);
			}
		}
	}
	
	public void placeFood(int amount) {
		Random rand = new Random();
		for (int i = 0; i < amount; i++) {
			int x, y;
			do {
				x = rand.nextInt(gridSize);
				y = rand.nextInt(gridSize);
			} while (getSlot(x, y) != Slot.EMPTY);
			setSlot(x, y, Slot.FOOD);
		}
	}
	
	public void hideGrid() {
		showGrid = false;
	}
	public void showGrid() {
		showGrid = true;
	}
}
