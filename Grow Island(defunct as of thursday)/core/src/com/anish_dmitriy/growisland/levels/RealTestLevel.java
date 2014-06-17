package com.anish_dmitriy.growisland.levels;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class RealTestLevel implements Screen{

	private Game game;
	private Texture texture;
	private final Sprite[][] sprites = new Sprite[10][10];
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle glViewport;
	
	public RealTestLevel(Game game){
		this.game=game;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(texture,0,0);
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				sprites[i][j].setScale(2f,2f);
				sprites[i][j].draw(batch);
			}
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.translate(162, 150);
		camera.update();
		camera.setToOrtho(true);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		texture = new Texture("img/bg.png");
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(i==0){
					if(j==0)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
					else if(j==1)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
					else if(j>=2 && j<=4)
						sprites[i][j] = (new Sprite(new Texture("tiles/water.png")));
					else if(j>=5 && j<10)
						sprites[i][j] = (new Sprite(new Texture("tiles/mountain.png")));
				}
				else if(i==1){
					if(j==0)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
					else if(j==1)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
					else if(j>=2 && j<=4)
						sprites[i][j] = (new Sprite(new Texture("tiles/water.png")));
					else if(j>=5 && j<10)
						sprites[i][j] = (new Sprite(new Texture("tiles/mountain.png")));
				}
				else if(i==2){
					if(j==0)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
					else if(j==1)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
					else if(j>=2 && j<=4)
						sprites[i][j] = (new Sprite(new Texture("tiles/water.png")));
					else if(j>=5 && j<9)
						sprites[i][j] = (new Sprite(new Texture("tiles/mountain.png")));
					else if(j==9)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
				}
				else if(i==3){
					if(j==0)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
					else if(j==1)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
					else if(j>=2 && j<=4)
						sprites[i][j] = (new Sprite(new Texture("tiles/water.png")));
					else if(j>=5 && j<10)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
				}
				else if(i==4){
					if(j==0)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
					else if(j==1)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
					else if(j>=2 && j<=4)
						sprites[i][j] = (new Sprite(new Texture("tiles/water.png")));
					else if(j==5)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
					else if(j>=6 && j<10)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
				}
				else if(i==5){
					if(j==0)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
					else if(j==1)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
					else if(j>=2 && j<=5)
						sprites[i][j] = (new Sprite(new Texture("tiles/water.png")));
					else if(j>=6 && j<10)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
				}
				else if(i==6){
					if(j==0)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
					else if(j==1)
						sprites[i][j] = (new Sprite(new Texture("tiles/desert.png")));
					else if(j>=2 && j<=5)
						sprites[i][j] = (new Sprite(new Texture("tiles/water.png")));
					else if(j==6)
						sprites[i][j] = (new Sprite(new Texture("tiles/farm.png")));
					else if(j>=7 && j<10)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
				}
				else if(i==7){
					if(j<=7)
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
					else if(j>7 && j<10)
						sprites[i][j] = (new Sprite(new Texture("tiles/farm.png")));
				}
				else if(i==8){
					if(j<3)
						sprites[i][j] = (new Sprite(new Texture("tiles/corruption.png")));
					else
						sprites[i][j] = (new Sprite(new Texture("tiles/water.png")));
				}
				else if(i==9){
					if(j<3)
						sprites[i][j] = (new Sprite(new Texture("tiles/corruption.png")));
					else
						sprites[i][j] = (new Sprite(new Texture("tiles/plains.png")));
				}
			}
		}
		
		camera = new OrthographicCamera(1216,656);
		glViewport = new Rectangle(0, 0, 1216, 656);
		//camera.zoom = 1 / 1.5f;
		
//		AnimatedTiledMapTile animatedTile = new AnimatedTiledMapTile();
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
		texture.dispose();
	}

}
