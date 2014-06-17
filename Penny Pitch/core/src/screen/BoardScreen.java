package screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anish_dmitriy.pennypitch.PennyPitch;
import entity.Penny;
import entity.PennyGroup;
import entity.ScoreTile;
import util.Assets;
import util.InputHandler;
import util.Sounds;

public class BoardScreen extends ScreenAdapter {
	
	PennyPitch game;
	
	Penny penny;
	SpriteBatch batch;
	InputHandler input;
	Sounds sound;
	
	float deltaVelX, deltaVelY;
	
	PennyGroup pennies;
	boolean collected = false;
	boolean added = false;
	
	BoardState state;
	long startTime = 0;
	
	private ScoreTile[][] tiles = new ScoreTile[5][5];
	
	public BoardScreen(PennyPitch game, float startY, float velX, float velY) {
		this.game = game;
		
		batch = game.getSpriteBatch();
		input = game.getInput();
		sound = game.getSound();
		
		penny = game.getPenny();
		penny.setPosition(-penny.getWidth(), startY);
		penny.setVelocity(velX, velY);
		penny.setAcceleration(0, 0);
		
		state = BoardState.MOVING;
		
		pennies = new PennyGroup(-50, -50, game.getFont());
		if(Math.random() * 10 <= 2) {
			pennies = new PennyGroup(((float) Math.random() * (PennyPitch.GAME_WIDTH - pennies.getWidth())), ((float) Math.random() * (PennyPitch.GAME_HEIGHT - pennies.getHeight())), game.getFont());
			collected = false;
		}
		
		deltaVelX = velX / 240F;
		deltaVelY = Math.abs((velY / velX) * deltaVelX);
		
		int score;
		for(int y = 0; y < tiles.length; y++) {
			score = 1;
			for(int x = 0; x < tiles[0].length; x++) {
				if(x == 4) score = 1;
				if(x > 0 && x < 4 && y != 0 && y != 4) score = 2;
				if(x == 2 && y == 2) score = 3;
				tiles[x][y] = new ScoreTile(PennyPitch.GAME_WIDTH - (x * Assets.scoreTile.getRegionWidth()) - (PennyPitch.GAME_WIDTH / 5), PennyPitch.GAME_HEIGHT - (y * Assets.scoreTile.getRegionHeight()) - (PennyPitch.GAME_HEIGHT / 5), score, game.getFont(), sound);
			}
		}
	}
	
	public void update(float delta) {
		pennies.update(delta);
		penny.update(delta);
		penny.velocity.x += penny.velocity.x > 0 ? -deltaVelX : deltaVelX;
		penny.velocity.y += penny.velocity.y > 0 ? -deltaVelY : deltaVelY;
		
		if(penny.pos.x >= PennyPitch.GAME_WIDTH - penny.bounds.width) {
			penny.pos.x = PennyPitch.GAME_WIDTH - penny.bounds.width;
			penny.velocity.x = -penny.velocity.x;
			sound.play(sound.bounce);
		}
		
		if(penny.pos.x <= 0) {
			penny.pos.x = 0;
			penny.velocity.x = -penny.velocity.x;
			sound.play(sound.bounce);
		}
		
		if(penny.pos.y >= PennyPitch.GAME_HEIGHT - penny.bounds.height) {
			penny.pos.y = PennyPitch.GAME_HEIGHT - penny.bounds.height;
			penny.velocity.y = -penny.velocity.y;
			sound.play(sound.bounce);
		}
		
		if(penny.pos.y <= 0) {
			penny.pos.y = 0;
			penny.velocity.y = -penny.velocity.y;
			sound.play(sound.bounce);
		}
		
		if(!collected && penny.intersects(pennies)) {
			game.numPennies += pennies.getExtra();
			game.penniesUsed += pennies.getExtra();
			collected = true;
			
			pennies.blink();
			
			sound.play(sound.pickup);
		}
		
		if(Math.abs(penny.getVelX()) <= 5) penny.setVelX(0);
		if(Math.abs(penny.getVelY()) <= 5) penny.setVelY(0);
		
		if(penny.getVelX() == 0 && penny.getVelY() == 0 && state == BoardState.MOVING) state = BoardState.LANDED;
		
		if(state == BoardState.LANDED && !added) {
			float xi = penny.getX() + (penny.getWidth() / 2);
			float yi = penny.getY() + (penny.getHeight() / 2);
			for(int y = 0; y < tiles.length; y++) {
				for(int x = 0; x < tiles[0].length; x++) {
					if(tiles[x][y].bounds.contains(xi, yi)) {
						game.score += tiles[x][y].score;
						state = BoardState.ADDED;
						startTime = System.currentTimeMillis();
						tiles[x][y].score();
						added = true;
						break;
					}
				}
			}
		}
		
		for(int y = 0; y < tiles.length; y++) {
			for(int x = 0; x < tiles[0].length; x++) {
				tiles[x][y].update(delta);
			}
		}
		
		if(state == BoardState.ADDED) {
			if(game.numPennies > 0) {
				if(System.currentTimeMillis() - startTime >= 1000) {
					penny.setPosition(-50, -50);
					game.setScreen(new TossScreen(game));
				}
			} else {
				startTime = System.currentTimeMillis();
				if(state != BoardState.DONE) state = BoardState.DONE;
			}
		}
		
		if(state == BoardState.DONE) {
			if(System.currentTimeMillis() - startTime >= 1000) game.setGameOver(true);
		}
	}
	
	@Override
	public void render(float delta) {
		for(int y = 0; y < tiles.length; y++) {
			for(int x = 0; x < tiles[0].length; x++) {
				tiles[x][y].render(batch);
			}
		}
		
		penny.render(batch);
		pennies.render(batch);
		
		game.renderHUD();
	}
	
	@Override
	public void hide() {
		state = BoardState.MOVING;
		deltaVelX = 0;
		deltaVelY = 0;
		startTime = 0;
	}
	
	enum BoardState {
		MOVING,
		LANDED,
		ADDED,
		DONE
	}
}
