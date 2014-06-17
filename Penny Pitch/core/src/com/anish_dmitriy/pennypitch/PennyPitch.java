package com.anish_dmitriy.pennypitch;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import entity.Penny;
import screen.ScreenAdapter;
import screen.TitleScreen;
import screen.TossScreen;
import util.Assets;
import util.Font;
import util.InputHandler;
import util.Sounds;
import util.ui.Option;
import util.ui.TextBox;

public class PennyPitch extends Game {
	
	public static final int GAME_WIDTH = 240;
	public static final int GAME_HEIGHT = 160;
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private InputHandler input;
	private Sounds sound;
	private Font font;
	
	Rectangle hudBounds;
	Rectangle volumeBounds;
	Rectangle menuBounds;
	
	float delta;
	long currTime, lastTime;
	
	private Penny penny;
	private final int INIT_PENNIES = 3;
	public int numPennies = INIT_PENNIES;
	public int penniesUsed = numPennies;
	public int score = 0;
	
	public boolean playing = false;
	private boolean gameOver = false;
	private boolean showEscOptions = false;
	private TextBox gameOverOptions;
	private TextBox escOptions;
	
	private Focus focus = Focus.SCREEN;
	
	@Override
	public void create() {
		Assets.load();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
		
		batch = new SpriteBatch();
		input = new InputHandler(GAME_WIDTH, GAME_HEIGHT);
		sound = new Sounds();
		font = new Font();
		
		penny = new Penny(-50, -50, 0, 0);
		
		Option play = new Option("PLAY AGAIN") {
			@Override
			public void execute() {
				reset();
				startPlaying();
			}
		};
		
		Option menu = new Option("MAIN MENU") {
			@Override
			public void execute() {
				showMainMenu();
			}
		};
		
		Option exit = new Option("EXIT") {
			@Override
			public void execute() {
				Gdx.app.exit();
			}
		};
		
		Option reset = new Option("RESET") {
			@Override
			public void execute() {
				reset();
				startPlaying();
			}
		};
		
		gameOverOptions = new TextBox(input, sound, font, "", play, menu, exit);
		escOptions = new TextBox(input, sound, font, "PAUSED", reset, menu, exit);
		
		lastTime = currTime;
		currTime = System.nanoTime();
		delta = (float) ((System.nanoTime() - lastTime) / 1e9);
		
		sound.music.setLooping(true);
		sound.music.setVolume(0.2F);
		sound.play(sound.music);
		
		hudBounds = new Rectangle(0, GAME_HEIGHT - Assets.hudBar.getRegionHeight(), Assets.hudBar.getRegionWidth(), Assets.hudBar.getRegionHeight());
		menuBounds = new Rectangle(46, GAME_HEIGHT - (Assets.hudBar.getRegionHeight() / 2) - (Assets.menu.getRegionHeight() / 2), Assets.menu.getRegionWidth(), Assets.menu.getRegionHeight());
		
		showMainMenu();
		
		sound.fadeMusicIn();
	}
	
	boolean updateScreen = true;
	
	public void update() {
		lastTime = currTime;
		currTime = System.nanoTime();
		delta = (float) ((System.nanoTime() - lastTime) / 1e9);
		
		sound.update(delta);
		
		updateScreen = true;
		
		if(input.keyClicked(Keys.ESCAPE)) {
			escOptions.setMessage("YOU HAVE " + calcScore() + " POINTS.");
			showEscapeMenu();
		}
		
		if(input.isClicked() && hudBounds.contains(input.getX(), input.getY())) {
			updateScreen = false;
			
			if(Gdx.app.getType() == ApplicationType.Android && menuBounds.contains(input.getX(), input.getY())) {
				showEscapeMenu();
			}
			
			if(volumeBounds.contains(input.getX(), input.getY())) {
				sound.setMute(!sound.isMute());
			}
		}
		
		if(focus != Focus.SCREEN) updateScreen = false;
		
		if(updateScreen) ((ScreenAdapter) getScreen()).update(delta);
		
		if(showEscOptions && focus == Focus.TEXTBOX) escOptions.update();
		if(gameOver && focus == Focus.TEXTBOX) gameOverOptions.update();
		
		input.update();
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(0.35F, 0.5F, 0.8F, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		update();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		{
			super.render();
			
			batch.draw(sound.isMute() ? Assets.volumeOff : Assets.volumeOn, volumeBounds.x, volumeBounds.y);
			
			if(showEscOptions) escOptions.render(batch);
			if(gameOver) gameOverOptions.render(batch);
		}
		batch.end();
	}
	
	public void renderHUD() {
		batch.draw(Assets.hudBar, 0, GAME_HEIGHT - Assets.hudBar.getRegionHeight());
		batch.draw(Assets.penny, 3, GAME_HEIGHT - penny.bounds.height - 3);
		if(Gdx.app.getType() == ApplicationType.Android) batch.draw(Assets.menu, menuBounds.x, menuBounds.y);
		
		font.setColor(Color.WHITE);
		font.write("x" + numPennies, penny.bounds.width + 6, GAME_HEIGHT - (Assets.hudBar.getRegionHeight() / 2) - (font.getBounds("x" + numPennies).height / 2), batch);
		font.write("Score: " + score, GAME_WIDTH / 2, GAME_HEIGHT - (Assets.hudBar.getRegionHeight() / 2) - (font.getBounds("Score: " + score).height / 2), batch);
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
		
		if(gameOver) {
			focus = Focus.TEXTBOX;
			playing = false;
			gameOverOptions.setMessage("You scored " + calcScore() + " points!");
			sound.fadeMusicOut();
		}
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void reset() {
		setGameOver(false);
		score = 0;
		numPennies = INIT_PENNIES;
		penniesUsed = numPennies;
		penny = new Penny(-50, -50, 0, 0);
		
		focus = Focus.SCREEN;
		showEscOptions = false;
	}
	
	private void showEscapeMenu() {
		if(playing) showEscOptions = !showEscOptions;
		
		if(showEscOptions) focus = Focus.TEXTBOX;
		else focus = Focus.SCREEN;
	}
	
	private void showMainMenu() {
		reset();
		playing = false;
		showEscOptions = false;
		volumeBounds = new Rectangle(4, GAME_HEIGHT - Assets.volumeOn.getRegionHeight() - 4, Assets.volumeOn.getRegionWidth(), Assets.volumeOn.getRegionHeight());
		setScreen(new TitleScreen(this));
		sound.fadeMusicIn();
	}
	
	public void startPlaying() {
		playing = true;
		volumeBounds = new Rectangle(70, GAME_HEIGHT - (Assets.hudBar.getRegionHeight() / 2) - (Assets.volumeOn.getRegionHeight() / 2), Assets.volumeOn.getRegionWidth(), Assets.volumeOn.getRegionHeight());
		setScreen(new TossScreen(this));
		sound.fadeMusicIn();
	}
	
	private int calcScore() {
		return (int) ((score / (penniesUsed * 3F)) * 1000 * penniesUsed);
	}
	
	public OrthographicCamera getCamera() {
		return camera;
	}
	
	public SpriteBatch getSpriteBatch() {
		return batch;
	}
	
	public InputHandler getInput() {
		return input;
	}
	
	public Sounds getSound() {
		return sound;
	}
	
	public Font getFont() {
		return font;
	}
	
	
	public Penny getPenny() {
		return penny;
	}
	
	@Override
	public void dispose() {
		super.dispose();
		
		Assets.dispose();
		sound.dispose();
		batch.dispose();
		font.dispose();
	}
	
	enum Focus {
		SCREEN,
		TEXTBOX
	}
}
