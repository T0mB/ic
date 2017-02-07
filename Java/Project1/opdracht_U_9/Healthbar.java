package opdracht_U_9;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Healthbar extends Graphic{
	static enum Style {BAR_COLOR};//,BAR_LENGTH, BAR_LENGTH_COLOR, BLOCKS};
	private int health, maxHealth;
	private Style style;
	
	public Healthbar(float x, float y, int width, int height, int health, int maxHealth, Style style) {
		super(x, y, width, height);
		this.health = health;
		this.maxHealth = maxHealth;
		this.style = style;
		setColor(0.0f, 1.0f, 0.0f);
	}
	public void draw () {
		if (style == Style.BAR_COLOR) {
			blue = 0.0f;
			red = 1 - ((float)health / (float)maxHealth);
			green = (float)health / (float)maxHealth;
			glColor3f(red, green, blue); 
			glBegin(GL_QUADS);
				glVertex2f(x, y); // top left
				glVertex2f(x + width, y); // top right
				glVertex2f(x + width, y + height); // bottom right
				glVertex2f(x, y + height); // bottom left
			glEnd();
		}
	}
	public void hit(int damage) {
		health -= damage;
		System.out.println("Health: " + health);
	}
	public void heal(int amount) {
		health += amount;
	}
	public int getHealth() {
		return health;
	}
}
