package com.anish_dmitriy.growisland.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.anish_dmitriy.growisland.Constants;
import com.anish_dmitriy.growisland.GrowIsland;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Constants.TITLE + " v" + Constants.VERSION;
		config.vSyncEnabled = true;
		config.useGL30 = true;
		config.height = 656;
		config.width = 1216;
		new LwjglApplication(new GrowIsland(), config);
	}
}
