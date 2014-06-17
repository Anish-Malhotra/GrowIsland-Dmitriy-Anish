package screen;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anish_dmitriy.pennypitch.PennyPitch;
import util.Font;
import util.InputHandler;
import util.Sounds;

public class AboutScreen extends ScreenAdapter {
	
	PennyPitch game;
	SpriteBatch batch;
	InputHandler input;
	Sounds sound;
	Font font;
	
	String message = "MADE BY DMITRIY K\nAND ANISH M\nART BY: ANISH MALHOTRA\nSOUNDS BY: THESCREEM\nMUSIC BY: PLAYONLOOP\n\nMADE USING LIBGDX";
	String backMessage = "PRESS B OR TOUCH ANYWHERE TO GO BACK";
	
	public AboutScreen(PennyPitch game) {
		this.game = game;
		
		batch = game.getSpriteBatch();
		input = game.getInput();
		sound = game.getSound();
		font = game.getFont();
	}
	
	@Override
	public void update(float delta) {
		if(input.keyClicked(Keys.B) || input.isClicked()) {
			sound.play(sound.blip);
			game.setScreen(new TitleScreen(game));
			sound.fadeMusicIn();
		}
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		font.setColor(Color.WHITE);
		font.write(message, (PennyPitch.GAME_WIDTH / 2) - (font.getWidth(message) / 2), (PennyPitch.GAME_HEIGHT / 2) - (font.getHeight(message) / 2) + font.getFontHeight() + 4, batch);
		
		if(System.currentTimeMillis() % 800 < 400) font.write(backMessage, (PennyPitch.GAME_WIDTH / 2) - (font.getWidth(backMessage) / 2), 4, batch);
	}
}
