package opdracht_U_10;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Graphic {
	protected float x = 0, y = 0;
	protected int width = 25, height = width;
	protected float red = 1.0f, green = 1.0f, blue = 1.0f;
	protected float vx = 0.0f, vy = 0.0f;
	public Graphic() {}
	public Graphic(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public Graphic(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void draw() {
		glColor3f(red, green, blue);
		glBegin(GL_QUADS);
			glVertex2f(x, y); // top left
			glVertex2f(x + width, y); // top right
			glVertex2f(x + width, y + height); // bottom right
			glVertex2f(x, y + height); // bottom left
		glEnd();
	}
	public void update() {
		//float oldX = getX(), oldY = getY();
		//boolean valid = true;
		setX(getX() + getVX());
		setY(getY() + getVY());
		
		float x = getX(), y = getY(), vx = getVX(), vy = getVY();
		int w = getWidth(), h = getHeight(), scrW = Snake.screenWidth, scrH = Snake.screenHeight;

		// Collision
		if (x < 0 && vx < 0) { //Left side
			setX(0);
			setVX(vx * -1);
		}
		if (x + w >= scrW - 1 && vx > 0) { //Right side
			setX(scrW - w - 1);
			setVX(vx * -1);
		}
		if (y < 0 && vy < 0) { //Top side
			setY(0);
			setVY(vy * -1);
		}
		if (y + h > scrH && vy > 0) { //Bottom side
			setY(scrH - h - 1);
			setVY(vy * -1);
		}
	}
	public void setColor(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	public float getX() { return x; }
	public float getY() { return y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public void setX(float x) { this.x = x;	}
	public void setY(float y) {	this.y = y;	}
	public void setPos(float x, float y) {
		setX(x);
		setY(y);
	}
	public float getVX() { return vx; }
	public float getVY() { return vy; }
	public void setVX(float vx) { this.vx = vx; };
	public void setVY(float vy) { this.vy = vy; };
}
