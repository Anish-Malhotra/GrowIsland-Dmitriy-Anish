package util.ui;

import com.badlogic.gdx.math.Rectangle;

public abstract class Option {
	
	String option;
	Rectangle bounds;
	
	public Option(String option) {
		this.option = option;
		bounds = new Rectangle();
	}
	
	public void setBounds(float x, float y, float width, float height) {
		bounds.set(x, y, width, height);
	}
	
	public float getX() {
		return bounds.x;
	}
	
	public float getY() {
		return bounds.y;
	}
	
	public abstract void execute();
}
