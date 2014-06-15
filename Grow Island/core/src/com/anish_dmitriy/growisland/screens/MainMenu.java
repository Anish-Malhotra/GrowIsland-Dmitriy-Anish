package com.anish_dmitriy.growisland.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainMenu implements Screen {

	private Stage stage;
	private Texture background;
	private TextureRegion bgloader;
	private TextureRegionDrawable drawer;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton startButton, exitButton;
	private BitmapFont white;
	private Label heading;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Table.drawDebug(stage); //remove later
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		background = new Texture("img/truebg.png");
		bgloader = new TextureRegion(background);
		drawer = new TextureRegionDrawable(bgloader);
		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas(Gdx.files.internal("ui/button.pack"));
		skin = new Skin(atlas);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		white = new BitmapFont(Gdx.files.internal("font/outline.fnt"),false);
		
		TextButtonStyle tbstyle = new TextButtonStyle();
		tbstyle.up = skin.getDrawable("button.up");
		tbstyle.down = skin.getDrawable("button.down");
		tbstyle.pressedOffsetX = 1;
		tbstyle.pressedOffsetY = -1;
		tbstyle.font = white;
		tbstyle.fontColor = Color.WHITE;
		
		startButton = new TextButton("START", tbstyle);
		startButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new Round());
			}
		});
		startButton.pad(20);
		
		exitButton = new TextButton("EXIT", tbstyle);
		exitButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		exitButton.pad(20);
		
		LabelStyle headingStyle = new LabelStyle(white,Color.WHITE);
		
		heading = new Label("",headingStyle);
		
		//putting it all together
		table.setBackground(drawer);
		table.add(heading);
		table.getCell(heading).spaceBottom(160);
		table.row();
		table.add(startButton);
		table.getCell(startButton).spaceBottom(30);
		table.row();
		table.add(exitButton);
		table.debug(); //remove later
		stage.addActor(table);
		
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		white.dispose();
		background.dispose();
	}

}
