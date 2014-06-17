package com.anish_dmitriy.growisland.screens;

import com.anish_dmitriy.growisland.levels.Level;
import com.anish_dmitriy.growisland.tiles.Forest;
import com.anish_dmitriy.growisland.tiles.Mill;
import com.anish_dmitriy.growisland.tiles.Tile;
import com.anish_dmitriy.growisland.tiles.Transparent;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
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
	private Label heading;
	private Music music;
	
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
		/*stage.getViewport().update(width,height,true);
		table.invalidateHierarchy();
		table.setSize(width, height);*/
		
		//doesn't work right
	}

	@Override
	public void show() {
		
		
		music = Gdx.audio.newMusic(Gdx.files.internal("audio/DuckTales Music (NES) - The Moon Theme.mp3"));
		music.setLooping(true);
		music.play();
		
		background = new Texture("img/truebg.png");
		bgloader = new TextureRegion(background);
		drawer = new TextureRegionDrawable(bgloader);
		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas(Gdx.files.internal("ui/button.pack"));
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"),atlas);
		heading = new Label("", skin);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		startButton = new TextButton("START", skin);
		startButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new LevelSelect());
			}
		});
		startButton.pad(20);
		
		exitButton = new TextButton("EXIT", skin);
		exitButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		exitButton.pad(20);
		
		
		
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
		background.dispose();
	}

}
