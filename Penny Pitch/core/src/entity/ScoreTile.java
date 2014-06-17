package entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anish_dmitriy.pennypitch.PennyPitch;
import util.Assets;
import util.Font;
import util.Font.TextBounds;
import util.Sounds;

public class ScoreTile extends Entity {
	
	private static final int WIDTH = PennyPitch.GAME_WIDTH / 5;
	private static final int HEIGHT = PennyPitch.GAME_HEIGHT / 5;
	
	Font font;
	Sounds sound;
	TextBounds textBounds;
	
	public int score;
	boolean shouldBlink = false;
	long startBlinkTime;
	Sprite blink;

	public ScoreTile(float x, float y, int score, Font font, Sounds sound) {
		super(x, y, WIDTH, HEIGHT);
		
		this.score = score;
		this.sound = sound;
		this.font = font;
		
		textBounds = font.getBounds(score + "");
		
		blink = new Sprite(Assets.scoreBlinker);
		blink.setPosition(x + 1, y + 1);
	}

	@Override
	public void update(float delta) {
		if(shouldBlink) {
			if(System.currentTimeMillis() - startBlinkTime >= 1000) shouldBlink = false;
			
			blink.setColor(1, 1, 1, 1 - (System.currentTimeMillis() - startBlinkTime) / 1000F);
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		if(shouldBlink) blink.draw(batch);
		
		batch.draw(Assets.scoreTile, pos.x, pos.y);
		
		font.setScale(2);
		font.setColor(0.55F, 0.7F, 1, 1);
		
		font.write(score + "", pos.x + (WIDTH / 2) - (textBounds.width / 2), pos.y + (HEIGHT / 2) - (textBounds.height / 2), batch);
		font.setScale(1);
	}
	
	public void score() {
		if(!shouldBlink) {
			if(score == 1) sound.play(sound.score1);
			if(score == 2) sound.play(sound.score2);
			if(score == 3) sound.play(sound.score3);
			startBlinkTime = System.currentTimeMillis();
			shouldBlink = true;
		}
	}
}
