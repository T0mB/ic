package opdracht_U_10;

import java.util.ArrayList;
import java.util.Random;

public class Player {
	public float red, green, blue;
	public enum Direction {NORTH, SOUTH, WEST, EAST};
	private Position head;
	private ArrayList<Position> tail;
	private Direction facing;
	
	public int score;
	
	public Player() {
		Random rand = new Random();
		head = new Position(rand.nextInt(Field.gridSize), rand.nextInt(Field.gridSize));
	
		int dLeft = 0, dRight = 0, dUp = 0, dDown = 0;
		
		dLeft = head.x;
		dRight = Field.gridSize - head.x;
		dUp = head.y;
		dDown = Field.gridSize - head.y;
		
		//zorg ervoor dat je altijd naar het midden beweegt in het begin(voorkom dat je gelijk een muur ingaat)
		if (dLeft < dRight && dLeft < dUp && dLeft < dDown) {
			facing = Direction.WEST;
		}
		if (dRight < dLeft && dRight < dUp && dRight < dDown) {
			facing = Direction.EAST;
		}
		if (dUp < dLeft && dUp < dRight && dUp < dDown) {
			facing = Direction.SOUTH;
		}
		if (dDown < dLeft && dDown < dUp && dDown < dRight) {
			facing = Direction.NORTH;
		}
		
		tail = new ArrayList<Position>();
		
		//Zorgt dat de staart altijd in een hoek op de facing staat, zodat hij bij de start niet uit het scherm steekt
		switch (facing) {
		case NORTH:
			tail.add(new Position(head.x - 1, head.y));
			tail.add(new Position(head.x - 2, head.y));
			break;
		case SOUTH:
			tail.add(new Position(head.x + 1, head.y));
			tail.add(new Position(head.x + 2, head.y));
			break;
		case EAST:
			tail.add(new Position(head.x, head.y - 1));
			tail.add(new Position(head.x, head.y - 2));
			break;
		case WEST:
			tail.add(new Position(head.x, head.y + 1));
			tail.add(new Position(head.x, head.y + 2));
			break;
		default:
			break;
		}
		
		grow();
		
		red = 0.0f;
		green = 0.0f;
		blue = 1.0f;
		
		score = 0;
	}
	
	public void update() {
		move(facing);
	}
	
	public int getLength() {
		return tail.size();
	}
	
	public Position getPosition(int index) {
		if (index == -1) {
			return head;
		} else {
			return tail.get(index);
		}
	}
	
	public Direction getDirection() {
		return facing;
	}
	
	public void move(Direction dir) {
		tail.add(0, new Position(head.x, head.y));
		tail.remove(tail.size() - 1);
		switch (dir) {
		case NORTH:
			head.y--;
			break;
		case SOUTH:
			head.y++;
			break;
		case EAST:
			head.x--;
			break;
		case WEST:
			head.x++;
			break;
		default:
			break;
		}
		// Collision met randen van het scherm
		if (head.x < 0 || head.x >= Snake.gridResolutie || head.y < 0 || head.y >= Snake.gridResolutie) {
			System.out.println("Game over! Score: " + score);
			setColor(1.0f, 0.0f, 0.0f);
			Snake.kill();
		}
	}
	
	public void setDirection(Direction dir) {
		this.facing = dir;
	}
	
	public Position getHead() {
		return head;
	}
	
	public void grow() {
		Position tail_end = tail.get(tail.size() - 1);
		Position tail_end_2 = tail.get(tail.size() - 2);
		
		int dx = 0, dy = 0;
		dx = tail_end.x - tail_end_2.x;
		dy = tail_end.y - tail_end_2.y;
		
		Position new_end = new Position(tail_end.x + dx, tail_end.y + dy);
		tail.add(new_end);
		score++;
	}
	
	public void setColor(float red, float green, float blue) {
		this.red = red;
		this.blue = blue;
		this.green = green;
	}
}
