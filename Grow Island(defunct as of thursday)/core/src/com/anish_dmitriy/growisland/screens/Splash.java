package com.anish_dmitriy.growisland.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.anish_dmitriy.growisland.Constants;
import com.anish_dmitriy.growisland.tween.SpriteAccessor;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash implements Screen {

	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager manager;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		splash.draw(batch);
		batch.end();
		manager.update(delta);

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		manager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		splash = new Sprite(new Texture("img/splash.png"));
		Tween.set(splash, Constants.ALPHA).target(0).start(manager);
		Tween.to(splash, Constants.ALPHA, 2).target(1).repeatYoyo(1,0.5f).setCallback(new TweenCallback() {
			public void onEvent(int type, BaseTween<?> source){
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		}).start(manager);
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
		splash.getTexture().dispose();
	}

}