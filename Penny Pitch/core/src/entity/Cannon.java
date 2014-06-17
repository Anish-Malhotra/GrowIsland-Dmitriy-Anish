package entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import util.Assets;
import util.InputHandler;

public class Cannon extends Entity {
	
	private static final float WIDTH = Assets.cannon.getRegionWidth();
	private static final float HEIGHT = Assets.cannon.getRegionHeight();
	
	InputHandler input;
	
	Sprite sprite;
	Vector2 mouse;
	float angle = 0;

	public Cannon(float x, float y, InputHandler input) {
		super(x, y, WIDTH, HEIGHT);
		this.input = input;
		
		mouse = new Vector2(input.getX(), input.getY());
		
		sprite = new Sprite(Assets.cannon);
		sprite.setOrigin(8, bounds.height / 2);
	}

	@Override
	public void update(float delta) {
		mouse.set(input.getX(), input.getY());
		angle = mouse.sub(sprite.getOriginX(), sprite.getOriginY()).angle();
		
		if(angle > 90 && angle < 180) angle = 90;
		if(angle < 0 || angle > 180) angle = 0;
		
		sprite.setRotation(angle);
	}

	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}
	
	public float getAngle() {
		return angle;
	}
	
	public float getOriginX() {
		return sprite.getOriginX();
	}
	
	public float getOriginY() {
		return sprite.getOriginY();
	}
	
	public void dispose() {
		sprite.getTexture().dispose();
	}
}
