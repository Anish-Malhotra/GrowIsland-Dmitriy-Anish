package entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import util.Assets;
import util.InputHandler;

public class PowerBar extends Entity {
	
	public static final float WIDTH = Assets.powerOutline.getRegionWidth();
	public static final float HEIGHT = Assets.powerOutline.getRegionHeight();
	
	InputHandler input;
	
	int timeMouseDown;
	
	float power;
	float maxPower = 1000F;

	public PowerBar(float x, float y, InputHandler input) {
		super(x, y, WIDTH, HEIGHT);
		this.input = input;
	}

	@Override
	public void update(float delta) {
		if(input.isMouseDown()) {
			timeMouseDown++;
			power = 500 + ((float) Math.sin(timeMouseDown * 0.05F) * maxPower) * 0.5F;
		} else {
			power -= maxPower * delta;
			if(power < 0) power = 0;
			timeMouseDown = (int) ((power / maxPower) * 63) - 31;
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		Assets.powerMeter.setRegionWidth((int) ((power / maxPower) * WIDTH));
		
		batch.draw(Assets.powerOutline, pos.x, pos.y);
		batch.draw(Assets.powerMeter, pos.x, pos.y);
	}
	
	public float getPower() {
		return power;
	}
}
