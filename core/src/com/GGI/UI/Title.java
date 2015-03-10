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
public class Title {

	public BitmapFont font;
	public float w = Gdx.graphics.getWidth(), h = Gdx.graphics.getHeight();
	public Rectangle bounds;
	public SpriteBatch pic;
	public String text = "rbit Ball";
	public TextureRegion t = new TextureRegion(new Texture(Gdx.files.internal("CutCircle.png")));
	public float rot1 = (float) (Math.random()*360),rot2 = (float) (Math.random()*360);
	
	public Title(BitmapFont font){
		this.font = font;
		font.setColor(Color.BLACK);
		font.setScale(h/2500);
		bounds = new Rectangle((.5f*w)-(.5f*font.getBounds("O"+text).width),.9f*h,w,font.getBounds(text).height);
		pic = new SpriteBatch();
	}
	
	public void render(float delta){
		rot1+=1;
		rot2-=1;
		font.setColor(Color.BLACK);
		font.setScale(h/2500);
		pic.begin();
		font.draw(pic, text, bounds.x+(1.05f*font.getBounds("O").width), bounds.y);
		pic.draw(t, bounds.x, bounds.y-font.getBounds(text).height, font.getBounds("O").height/2, font.getBounds("O").height/2, font.getBounds("O").height, font.getBounds("O").height, 1f, 1f, rot1);
		pic.draw(t, bounds.x, bounds.y-font.getBounds(text).height, font.getBounds("O").height/2, font.getBounds("O").height/2, font.getBounds("O").height, font.getBounds("O").height, 1.4f, 1.4f, rot2);
		
		pic.end();
	}
}
