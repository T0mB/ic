package opdracht_U_9;

public class Ball extends Graphic{
	private float maxSpeed = 10.0f;
	public Ball() {
		super();
	}
	public Ball(int x, int y) {
		super(x, y);
	}
	@Override
	public void setVX(float vx) {
		if (vx > maxSpeed) {
			this.vx = maxSpeed;
		} else {
			this.vx = vx;
		}
	}
	@Override
	public void setVY(float vy) {
		if (vy > maxSpeed) {
			this.vy = maxSpeed;
		} else {
			this.vy = vy;
		}
	}
}
