package com.anish_dmitriy.growisland.screens;

import com.anish_dmitriy.growisland.levels.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class LevelSelect implements Screen {

	private Table table,container;
	private Stage stage;
	private Texture background;
	private TextureRegion bgloader;
	private TextureRegionDrawable drawer;
	private TextureAtlas atlas;
	private Skin skin;
	private TextButton levelOne,levelTwo,levelThree;
	private ScrollPane scroll;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		background = new Texture("img/levelselect.png");
		bgloader = new TextureRegion(background);
		drawer = new TextureRegionDrawable(bgloader);
		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas(Gdx.files.internal("ui/button.pack"));
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"),atlas);
		
		levelOne = new TextButton("Level One", skin);
		levelOne.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new LevelOne());
			}
		});
		levelTwo = new TextButton("Level Two", skin);
		levelThree = new TextButton("Level Three", skin);
		
		container = new Table(skin);
		table = new Table(skin);
		
		container.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		scroll = new ScrollPane(table);
		container.add(scroll).width(300f).height(300f);
		container.setBackground(drawer);
		table.add(levelOne);
		table.add(levelTwo);
		table.add(levelThree);
		container.row();
		stage.addActor(container);
		
	}

	@Override
	public void hide() {
		this.dispose();
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
		background.dispose();
	}

}
