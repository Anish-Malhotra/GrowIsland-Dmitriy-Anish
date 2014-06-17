package entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import util.Assets;

public class Penny extends Entity {
	
	private final static float WIDTH = Assets.penny.getRegionWidth();
	private final static float HEIGHT = Assets.penny.getRegionHeight();
	
	private final float GRAVITY = -9.8F;
	
	public Penny(float x, float y, float dx, float dy) {
		super(x, y, WIDTH, HEIGHT);
		
		velocity.set(dx, dy);
		acceleration.set(0, GRAVITY);
	}
	
	@Override
	public void update(float delta) {
		velocity.add(acceleration);
		pos.add(velocity.x * delta, velocity.y * delta);
		
		super.updateBounds();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(Assets.penny, pos.x, pos.y);
	}
}
