package entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import util.Assets;
import util.Font;

public class PennyGroup extends Entity {
	
	private static final float WIDTH = Assets.pennyGroup.getRegionWidth();
	private static final float HEIGHT = Assets.pennyGroup.getRegionHeight();
	
	Font font;
	
	int extra;
	boolean blinking, renderExtra;
	long startTime;

	public PennyGroup(float x, float y, Font font) {
		super(x, y, WIDTH, HEIGHT);
		
		this.font = font;
		extra = (int) Math.ceil(Math.random() * 3);
	}
	
	public int getExtra() {
		return extra;
	}
	
	public void blink() {
		blinking = true;
		startTime = System.currentTimeMillis();
	}

	@Override
	public void update(float delta) {
		if(blinking) {
			if((System.currentTimeMillis() - startTime) % 200 > 100) renderExtra = true;
			else renderExtra = false;
			
			if(System.currentTimeMillis() - startTime >= 1500) {
				blinking = false;
				renderExtra = false;
				pos.set(-50, -50);
			}
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		if(!blinking) batch.draw(Assets.pennyGroup, pos.x, pos.y);
		
		if(renderExtra) {
			font.setColor(Color.WHITE);
			font.write("+" + extra, pos.x, pos.y, batch);
		}
	}
}
