package com.GGI.OrbitBall.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.GGI.OrbitBall.OrbitBall;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		 cfg.width = 338;
	     cfg.height = 675;
		new LwjglApplication(new OrbitBall(), cfg);
	}
}
