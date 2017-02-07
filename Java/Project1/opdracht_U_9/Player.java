package opdracht_U_9;

public class Player extends Graphic{
	private Healthbar hb;
	private boolean isDead;
	private float speed;
	private float maxSpeed = 4.0f;
	public Player() {
		this(0, 0);
		speed = 3.0f;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		if (speed < maxSpeed) {
			this.speed = speed;
		} else {
			this.speed = maxSpeed;
		}
	}
	public void addSpeed(float amount) {
		if (speed + amount < maxSpeed) {
			this.speed += amount;
		} else {
			this.speed = maxSpeed;
		}
	}
	public Player(int x, int y) {
		super(x, y, 20, 100);
		setColor(0.0f, 1.0f, 0.0f);
		this.hb = new Healthbar(x, 10, 100, 25, 100, 100, Healthbar.Style.BAR_COLOR);
		isDead = false;
	}
	public void draw() {
		super.draw();

		hb.draw();
	}
	public Healthbar getHB() {
		return hb;
	}
	public void kill() {
		this.isDead = true;
		
		System.out.println("A Player Died!");
	}
	public boolean isDead() {
		return isDead;
	}
}
