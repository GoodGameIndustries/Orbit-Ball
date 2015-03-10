/**
 * 
 */
package com.GGI.Screens;

import com.GGI.OrbitBall.OrbitBall;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Emmett Deen
 *
 */
public class HelpScreen implements Screen, InputProcessor{

	public OrbitBall o;
	public SpriteBatch pic;
	public float w = Gdx.graphics.getWidth(), h = Gdx.graphics.getHeight();
	public BitmapFont font;
	public float rot1=(float) (Math.random()*360),rot2=(float) (Math.random()*360);
	public Rectangle bounds;
	public TextureRegion t=new TextureRegion(new Texture(Gdx.files.internal("CutCircle.png")));
	public TextureRegion t2=new TextureRegion(new Texture(Gdx.files.internal("Circle.png")));
	
	public HelpScreen(OrbitBall o){
		this.o=o;
		this.font=o.font;
		
		bounds = new Rectangle(w/4,h/2,w/2,w/2);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		rot1+=1;rot2-=1;
		
		pic.begin();
		//pic.draw(bg,0,0,w,h);
		pic.draw(t, bounds.x, bounds.y, bounds.width/2, bounds.height/2, bounds.width, bounds.height, .9f, .9f, rot1);
		pic.draw(t2, bounds.x, bounds.y, bounds.width/2, bounds.height/2, bounds.width, bounds.height, .9f, .9f, rot1);
		pic.draw(t, bounds.x, bounds.y, bounds.width/2, bounds.height/2, bounds.width, bounds.height, 1.3f, 1.3f, rot2);
	
		
		font.setScale(((float)(h))/4000);
		font.setColor(Color.BLACK);
		if(Math.abs(rot1-rot2)%360<35||Math.abs(rot1-rot2)%360>325){
		font.draw(pic, "Tap", (w/2)-(font.getBounds("Tap").width/2), 11*h/12);
		}
		font.setScale(((float)(h))/5000);
		font.draw(pic, "At the correct time tap", (w/2)-(font.getBounds("At the correct time tap").width/2), 4*h/12);
		font.draw(pic, "to jump to the next ring!", (w/2)-(font.getBounds("to jump to the next ring!").width/2), 3*h/12);
		pic.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		pic = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		o.setScreen(new MainMenuScreen(o));
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
