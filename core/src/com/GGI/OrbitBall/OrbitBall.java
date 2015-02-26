package com.GGI.OrbitBall;

import com.GGI.Screens.OpeningScreen;
import com.badlogic.gdx.Game;

public class OrbitBall extends Game {
	
	
	@Override
	public void create () {
		this.setScreen(new OpeningScreen(this));
	}

	
}
