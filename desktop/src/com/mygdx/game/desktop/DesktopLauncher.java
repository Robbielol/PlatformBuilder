package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.CharacterTest;
import com.mygdx.game.MainMenu;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 600;
		config.width = 1000;
		//config.useGL30 = true;
//		new LwjglApplication(new MainMenu(), config);
		new LwjglApplication(new CharacterTest(), config);
	}
}
