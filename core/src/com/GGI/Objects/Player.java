package com.GGI.Objects;

import com.GGI.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class Player extends TextureRegion{

	public GameScreen s;
	public Rectangle bounds;
	public float w = Gdx.graphics.getWidth(),h = Gdx.graphics.getHeight();
	public int tier=0;
	public float rot;
	public Player(GameScreen s){
		super(s.pText);
		this.s=s;
		bounds = s.barriers.get(tier).bounds;
		rot = s.barriers.get(tier).rot;
	}
	
	public void update(){
	if(tier!=-1){
		bounds = s.barriers.get(tier).bounds;
		rot = s.barriers.get(tier).rot;
	}
	}
	
}
