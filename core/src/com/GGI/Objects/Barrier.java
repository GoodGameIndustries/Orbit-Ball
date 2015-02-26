package com.GGI.Objects;

import com.GGI.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Barrier extends TextureRegion{

	public Rectangle bounds = new Rectangle();
	public float scale;
	public float rot=0;
	public float w=Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	public GameScreen s;
	
	public Barrier(GameScreen s,float scale,float rot){
		super(s.c);
		this.scale=scale;
		this.rot=rot;
		this.s=s;
		calibrate();
		
		
	}
	
	private void calibrate() {
		bounds.width = (w/4)*scale;
		bounds.height = (w/4)*scale;
		bounds.x=(w/2)-(bounds.width/2f);
		bounds.y=(h/2)-(bounds.height/2f);
		
	}

	public void update(){
		scale-=.01f;
		if(scale<=0){s.barriers.remove(this);s.barriers.add(new Barrier(s,4f,rot));s.player.tier-=1;if(s.player.tier<=-1){s.gameOver=true;}}
		
		calibrate();
		
		if(s.gameOver){super.setRegion(s.over);}
		
	}
}
