package com.anish_dmitriy.growisland;

import com.anish_dmitriy.growisland.screens.Splash;
import com.badlogic.gdx.Game;

public class GrowIsland extends Game {
	
	@Override
	public void create () {
		setScreen(new Splash());
	}

	@Override
	public void render () {
		super.render();
	}
	
}
