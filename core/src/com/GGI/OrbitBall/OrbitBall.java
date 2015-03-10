package com.GGI.OrbitBall;

import com.GGI.Screens.OpeningScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class OrbitBall extends Game {
	
	private ActionResolver actionResolver;
	public int gameCount = 0;
	public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	public BitmapFont font;
	
	
	public OrbitBall(ActionResolver androidLauncher) {
		this.actionResolver=androidLauncher;
		
		
		
	}

	@Override
	public void create () {
		
FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Neou-Bold.ttf"));
		
		font = generator.generateFont(150,FONT_CHARACTERS,false);
		generator.dispose();
		font.setColor(1,1,1,1);
		
		this.setScreen(new OpeningScreen(this));

	}

	public void popup(){
		actionResolver.showOrLoadInterstital();
	}
	
	
}
