package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anish_dmitriy.pennypitch.PennyPitch;

import entity.Penny;
import util.Assets;
import util.Font;
import util.InputHandler;
import util.Sounds;
import util.ui.Menu;
import util.ui.Option;

public class TitleScreen extends ScreenAdapter {
	
	PennyPitch game;
	SpriteBatch batch;
	InputHandler input;
	Sounds sound;
	Font font;
	
	Menu menu;
	
	private Penny[] pennies;
	
	public TitleScreen(final PennyPitch game) {
		this.game = game;
		
		batch = game.getSpriteBatch();
		input = game.getInput();
		sound = game.getSound();
		font = game.getFont();
		
		Option play = new Option("PLAY") {
			@Override
			public void execute() {
				game.startPlaying();
			}
		};
		
		Option help = new Option("HELP") {
			@Override
			public void execute() {
				game.setScreen(new HelpScreen(game));
				sound.fadeMusicOut();
			}
		};
		
		Option about = new Option("ABOUT") {
			@Override
			public void execute() {
				game.setScreen(new AboutScreen(game));
				sound.fadeMusicOut();
			}
		};
		
		Option exit = new Option("EXIT") {
			@Override
			public void execute() {
				Gdx.app.exit();
			}
		};
		
		menu = new Menu(input, sound, font, 0, 0, play, help, about, exit);
		menu.setX((PennyPitch.GAME_WIDTH / 2) - (menu.getWidth() / 2));
		menu.setY(25);
		
		pennies = new Penny[35];
		for(int i = 0; i < pennies.length; i++) {
			pennies[i] = new Penny((float) Math.random() * (PennyPitch.GAME_WIDTH - game.getPenny().getWidth()), (float) Math.random() * (PennyPitch.GAME_HEIGHT - game.getPenny().getHeight()), (float) Math.random() * (Math.random() > 0.5F ? -5 : 5), (float) (Math.random() * -30) - 15);
			pennies[i].setAcceleration(0, 0);
		}
	}
	
	public void update(float delta) {
		menu.update();
		
		for(int i = 0; i < pennies.length; i++) {
			pennies[i].update(delta);
			
			if(pennies[i].getY() < -game.getPenny().getHeight()) pennies[i].setY(PennyPitch.GAME_HEIGHT);
			if(pennies[i].getX() <= 0 || pennies[i].getX() > PennyPitch.GAME_WIDTH - game.getPenny().getWidth()) pennies[i].setVelX(-pennies[i].getVelX());
		}
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		for(int i = 0; i < pennies.length; i++) {
			pennies[i].render(batch);
		}
		
		batch.draw(Assets.logo, (PennyPitch.GAME_WIDTH / 2) - (Assets.logo.getRegionWidth() / 2), ((PennyPitch.GAME_HEIGHT - 50)) - (Assets.logo.getRegionHeight() / 2));
		
		menu.render(batch);
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
}
