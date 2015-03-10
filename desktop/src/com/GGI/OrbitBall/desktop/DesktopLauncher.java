package com.GGI.OrbitBall.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.GGI.OrbitBall.ActionResolver;
import com.GGI.OrbitBall.OrbitBall;

public class DesktopLauncher implements ActionResolver{
	public static void main(String[] args){new DesktopLauncher();}
	public DesktopLauncher () {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		 cfg.width = 338;//338
	     cfg.height = 675;
		new LwjglApplication(new OrbitBall(this), cfg);
	}

	@Override
	public void showOrLoadInterstital() {
		// TODO Auto-generated method stub
		
	}
}
