package screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anish_dmitriy.pennypitch.PennyPitch;
import entity.Cannon;
import entity.Penny;
import entity.Pole;
import entity.PowerBar;
import util.InputHandler;
import util.Sounds;

public class TossScreen extends ScreenAdapter {
	
	PennyPitch game;
	
	SpriteBatch batch;
	InputHandler input;
	Sounds sound;
	
	Cannon cannon;
	Penny penny;
	Pole pole;
	PowerBar power;
	
	boolean isThrown;
	boolean alertNoPennies = false;
	
	public TossScreen(PennyPitch game) {
		this.game = game;
		
		batch = game.getSpriteBatch();
		input = game.getInput();
		sound = game.getSound();
		
		penny = game.getPenny();
		cannon = new Cannon(0, 0, input);
		pole = new Pole(PennyPitch.GAME_WIDTH - 11, 0);
		power = new PowerBar(5, 50, input);
	}
	
	long alertTime = System.currentTimeMillis();
	
	public void update(float delta) {
		if(!game.isGameOver()) cannon.update(delta);
		penny.update(delta);
		if(game.numPennies > 0) power.update(delta);
		
		float pY = penny.pos.y;
		if(pY < 2) pY = 2;
		if(pY > PennyPitch.GAME_HEIGHT - penny.getHeight() - 1) pY = PennyPitch.GAME_HEIGHT - penny.getHeight() - 1;
		if(isThrown) pole.updateBar(pY);
		
		if(penny.pos.x < -penny.bounds.width || penny.pos.x > PennyPitch.GAME_WIDTH || penny.pos.y < -penny.bounds.height) {
			penny.pos.set(-50, -50);
			isThrown = false;
			
			if(game.numPennies <= 0) {
				game.setGameOver(true);
			}
		}
		
		if(penny.getY() >= PennyPitch.GAME_HEIGHT - penny.getHeight()) {
			penny.setY(PennyPitch.GAME_HEIGHT - penny.getHeight());
			penny.setVelY(-penny.getVelY());
		}
		
		if(penny.intersects(pole)) {
			game.setScreen(new BoardScreen(game, pole.getBarY(), penny.getVelX(), penny.getVelY()));
		}
		
		if(input.isClicked()) {
			if(!isThrown && game.numPennies > 0) {
				double radians = Math.toRadians(cannon.getAngle());
				float x = (float) (cannon.getOriginX() + ((cannon.bounds.height + (penny.bounds.width / 2)) * Math.cos(radians)));
				float y = (float) (cannon.getOriginY() + ((cannon.bounds.height + (penny.bounds.height / 2)) * Math.sin(radians)));
				penny = new Penny(x - (penny.getWidth() / 2), y - (penny.getHeight() / 2), (float) (Math.cos(radians) * power.getPower()), (float) (Math.sin(radians) * power.getPower()));
				isThrown = true;
				sound.play(sound.explosion);
				game.numPennies--;
			}
		}
	}
	
	@Override
	public void render(float delta) {
		game.renderHUD();
		
		cannon.render(batch);
		pole.render(batch);
		penny.render(batch);
		power.render(batch);
	}
}
