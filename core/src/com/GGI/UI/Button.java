/**
 * 
 */
package com.GGI.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Emmett Deen
 *
 */
public class Button {
	
	private SpriteBatch pic;
	public BitmapFont font;
	public Rectangle bounds;
	private String text;
	public TextureRegion t=new TextureRegion(new Texture(Gdx.files.internal("CutCircle.png")));
	public float rot1=(float) (Math.random()*360),rot2=(float) (Math.random()*360);
	public int w = Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	private boolean isTouched = false;
	public Button(BitmapFont font, String text,float y){
		pic = new SpriteBatch();
		this.font=font;
		font.setScale((float)(h)/4000);
		font.setColor(0,0,0,1);
		this.text = text;
		bounds = new Rectangle(w/2-font.getBounds(text).width,y*h,font.getBounds(text).width*2,font.getBounds(text).width*2);
		
	}
	
	public void press(){
		isTouched  = true;
	}
	
	public void release(){
		isTouched  = false;
	}
	
	
	public void render(float delta){
		font.setScale((float)(h)/4000);
		font.setColor((isTouched) ? Color.RED : Color.BLACK);
		
		rot1+=1;
		rot2-=1;
		pic.begin();
		
		pic.draw(t, bounds.x, bounds.y, bounds.width/2, bounds.height/2, bounds.width, bounds.height, .9f, .9f, rot1);
		pic.draw(t, bounds.x, bounds.y, bounds.width/2, bounds.height/2, bounds.width, bounds.height, 1.3f, 1.3f, rot2);
		
		font.draw(pic, text, bounds.x+bounds.width/4, bounds.y+bounds.height/2+font.getBounds(text).height/2);
		pic.end();
	}
}
