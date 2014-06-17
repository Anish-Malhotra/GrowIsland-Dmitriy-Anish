package screen;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anish_dmitriy.pennypitch.PennyPitch;

import util.Assets;
import util.Font;
import util.InputHandler;
import util.Sounds;

public class HelpScreen extends ScreenAdapter {
	
	PennyPitch game;
	
	SpriteBatch batch;
	InputHandler input;
	Sounds sound;
	Font font;
	
	String backMessage = "PRESS B OR TOUCH ANYWHERE TO GO BACK";
	
	public HelpScreen(PennyPitch game) {
		this.game = game;
		
		batch = game.getSpriteBatch();
		input = game.getInput();
		sound = game.getSound();
		font = game.getFont();
	}
	
	public void update(float delta) {
		if(input.keyClicked(Keys.B) || input.isClicked()) {
			sound.play(sound.blip);
			game.setScreen(new TitleScreen(game));
			sound.fadeMusicIn();
		}
	}
	
	String cannon = "THIS IS YOUR CANNON. AIM WITH\nTHE MOUSE AND HOLD FOR POWER.\nRELEASE TO FIRE.";
	String penny = "THIS IS A PENNY. THEY'RE\nLIMITED, SO USE THEM WISELY.";
	String extraPennies = "EXTRA PENNIES MAY APPEAR ON\nTHE BOARD. COLLECT THEM FOR\nA HIGHER SCORE.";
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		font.setColor(Color.WHITE);
		batch.draw(Assets.cannon, 8, PennyPitch.GAME_HEIGHT - Assets.cannon.getRegionHeight() - 23);
		font.write(cannon, 8 + Assets.cannon.getRegionWidth() + 8, 117, batch);
		
		batch.draw(Assets.penny, 30, 82);
		font.write(penny, Assets.penny.getRegionWidth() + 38, 78, batch);
		
		batch.draw(Assets.pennyGroup, 25, 36);
		font.write(extraPennies, Assets.pennyGroup.getRegionWidth() + 32, 33, batch);
		
		if(System.currentTimeMillis() % 800 < 400) font.write(backMessage, (PennyPitch.GAME_WIDTH / 2) - (font.getWidth(backMessage) / 2), 4, batch);
	}
}
