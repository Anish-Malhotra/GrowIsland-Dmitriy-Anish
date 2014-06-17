package com.anish_dmitriy.growisland.levels;

import com.anish_dmitriy.growisland.Constants;
import com.anish_dmitriy.growisland.tiles.Forest;
import com.anish_dmitriy.growisland.tiles.Plains;
import com.anish_dmitriy.growisland.tiles.Tile;
import com.anish_dmitriy.growisland.tiles.Transparent;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public class LevelOne extends Level implements Screen,InputProcessor{
	private SpriteBatch batch;
	private OrthographicCamera cam;
	private Texture background;
	private Tile lastSelectedTile = null;
	final Plane xzPlane = new Plane(new Vector3(0, 1, 0), 0);
	final Vector3 intersection = new Vector3();
	private final Matrix4 matrix = new Matrix4();
	
	
	public LevelOne(){
			super();
	}
	
	@Override
	public void show(){
		background = new Texture("img/bg.png");
		 
		
		for (int row = 0;row < GameGrid.length;row++){
			for (int col = 0;col < GameGrid[0].length;col++){
				GameGrid[row][col] = new Transparent();
			}
		}
		
		GameGrid[9][2] = new Plains();
		GameGrid[6][0] = new Forest();
		GameGrid[6][1] = new Forest();
		GameGrid[6][2] = new Forest();
		GameGrid[6][3] = new Forest();
		GameGrid[7][3] = new Forest();
		GameGrid[8][3] = new Forest();
		GameGrid[9][3] = new Forest();
		GameGrid[7][0] = new Plains();
		GameGrid[7][1] = new Plains();
		GameGrid[7][2] = new Plains();
		GameGrid[8][0] = new Plains();
		GameGrid[8][1] = new Plains();
		GameGrid[8][2] = new Plains();
		GameGrid[9][0] = new Plains();
		GameGrid[9][1] = new Plains();
		
		batch = new SpriteBatch();
		cam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		Gdx.input.setInputProcessor(this);

		
	}
	
	
	/*You have to add some objectives:
	 * Build city level 1
	 * build Farm level 1 && build Mill level 1
	 * Build city level 2
	 * At this point the level ends
	 */
	 
	
	//makes the player go back to level select or main menu
	public boolean Complete(){
		if (Constants.CITIES == 2){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(background,0,0);
		for (int row = 0;row < GameGrid.length ;row++){
			for (int col = 0;col < GameGrid[0].length;col++){
				GameGrid[row][col].setSize(64f, 64f);
				GameGrid[row][col].draw(batch);
				GameGrid[row][col].setX(50+(64*row));
				GameGrid[row][col].setY(210+(64*col));
				
			}
		}
		batch.end();
		checkTileTouched();

	}

	private void checkTileTouched() {
		if(Gdx.input.justTouched()) {
			Ray pickRay = cam.getPickRay(Gdx.input.getX(), Gdx.input.getY());
			Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
			int x = (int)intersection.x;
			int z = (int)intersection.z;
			if(x >= 0 && x < 10 && z >= 0 && z < 10) {
				if(lastSelectedTile != null) lastSelectedTile.setColor(1, 1, 1, 1);
				Tile tile = GameGrid[x][z];
				tile.setColor(1, 0, 0, 1);
				lastSelectedTile = tile;
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		cam.update();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
