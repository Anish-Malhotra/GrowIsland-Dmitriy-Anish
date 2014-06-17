package util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
	private static TextureAtlas atlas;
	
	public static Texture logoTexture;
	public static TextureRegion logo;
	
	public static TextureRegion penny;
	public static TextureRegion cannon;
	public static TextureRegion pennyGroup;
	public static TextureRegion secretBox;
	
	public static TextureRegion powerMeter;
	public static TextureRegion powerOutline;
	
	public static TextureRegion pole;
	public static TextureRegion poleBar;
	
	public static TextureRegion scoreTile;
	public static TextureRegion scoreBlinker;
	
	public static TextureRegion hudBar;
	public static TextureRegion volumeOn;
	public static TextureRegion volumeOff;
	public static TextureRegion menu;
	
	public static NinePatch textBox;
	
	public static void load() {
		atlas = new TextureAtlas(Gdx.files.internal("penny.pack"));
		
		logoTexture = new Texture(Gdx.files.internal("icons/128x128.png"));
		logo = new TextureRegion(logoTexture, 0, 27, 128, 74);
		
		penny = atlas.findRegion("penny");
		cannon = atlas.findRegion("cannon");
		pennyGroup = atlas.findRegion("pennyGroup");
		secretBox = atlas.findRegion("secret-box");
		
		powerMeter = atlas.findRegion("power-meter");
		powerOutline = atlas.findRegion("power-outline");
		
		pole = atlas.findRegion("pole");
		poleBar = atlas.findRegion("pole-bar");
		
		scoreTile = atlas.findRegion("score-tile");
		scoreBlinker = atlas.findRegion("score-blinker");
		
		hudBar = atlas.findRegion("hudBar");
		volumeOn = atlas.findRegion("volume-on");
		volumeOff = atlas.findRegion("volume-off");
		menu = atlas.findRegion("menu");
		
		textBox = new TextureAtlas(Gdx.files.internal("ui/ui.pack")).createPatch("textbox");
	}
	
	public static void dispose() {
		atlas.dispose();
		logoTexture.dispose();
	}
}
