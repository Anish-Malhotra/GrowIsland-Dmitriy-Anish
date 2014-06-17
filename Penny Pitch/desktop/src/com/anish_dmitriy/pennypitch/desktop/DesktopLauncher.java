package com.anish_dmitriy.pennypitch.desktop;

import com.anish_dmitriy.pennypitch.PennyPitch;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	
	public static final int SCREEN_WIDTH = 480;
	public static final int SCREEN_HEIGHT = 320;
	public static final String NAME = "Penny Pitch";
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.addIcon("icons/16x16.png", FileType.Internal);
		cfg.addIcon("icons/32x32.png", FileType.Internal);
		cfg.addIcon("icons/128x128.png", FileType.Internal);
		cfg.title = NAME;
		cfg.width = SCREEN_WIDTH;
		cfg.height = SCREEN_HEIGHT;
		cfg.resizable = false;
		cfg.useGL30 = true;
		
		new LwjglApplication(new PennyPitch(), cfg);
	}
}
