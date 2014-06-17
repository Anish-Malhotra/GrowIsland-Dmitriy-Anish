package entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import util.Assets;

public class Pole extends Entity {
	
	private static int WIDTH = Assets.pole.getRegionHeight();
	private static int HEIGHT = Assets.pole.getRegionWidth();
	
	private float barY = 2;

	public Pole(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void update(float delta) {}
	
	public void updateBar(float barY) {
		this.barY = barY;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(Assets.pole, pos.x, pos.y, WIDTH / 2, WIDTH / 2, WIDTH, HEIGHT, 1, 1, 0, true);
		batch.draw(Assets.poleBar, pos.x + 1, barY);
	}
	
	public float getBarY() {
		return barY;
	}
}
