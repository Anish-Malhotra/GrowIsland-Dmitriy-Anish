package com.anish_dmitriy.growisland.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainMenu implements Screen {

	private Stage stage;
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
		stage = new Stage();
		
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
		tbstyle.fontColor = Color.BLACK;
		
		exitButton = new TextButton("EXIT", tbstyle);
		exitButton.pad(20);
		
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

	}

}
