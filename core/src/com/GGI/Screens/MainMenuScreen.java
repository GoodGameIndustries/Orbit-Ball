package com.GGI.Screens;

import com.GGI.OrbitBall.OrbitBall;
import com.GGI.UI.Button;
import com.GGI.UI.Title;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;


public class MainMenuScreen implements Screen,InputProcessor{

	public OrbitBall o;
	public Button help;
	public Button play;
	public Button rate;
	public Title title;
	public SpriteBatch pic;
	public int w = Gdx.graphics.getWidth(),h = Gdx.graphics.getHeight();
	
	public MainMenuScreen(OrbitBall o){
		this.o=o;
		help = new Button(o.font,"Help",.35f);
		play = new Button(o.font,"Play",.6f);
		rate = new Button(o.font,"Rate",.1f);
		title = new Title(o.font);
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		pic.begin();
		//pic.draw(bg,0,0,w,h);
		
		pic.end();
		title.render(delta);
		play.render(delta);
		help.render(delta);
		rate.render(delta);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		pic = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
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
		screenY = h-screenY;
		Rectangle touch = new Rectangle(screenX,screenY,1,1);
		if(Intersector.overlaps(touch, play.bounds)){
			play.press();
		}
		else if(Intersector.overlaps(touch, help.bounds)){
			help.press();
		}
		else if(Intersector.overlaps(touch, rate.bounds)){
			rate.press();
		}
		return true;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = h-screenY;
		play.release();
		help.release();
		rate.release();
		Rectangle touch = new Rectangle(screenX,screenY,1,1);
		if(Intersector.overlaps(touch, play.bounds)){
			o.setScreen(new GameScreen(o));
		}
		else if(Intersector.overlaps(touch, help.bounds)){
			o.setScreen(new HelpScreen(o));
		}
		else if(Intersector.overlaps(touch, rate.bounds)){
			Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.GGI.OrbitBall.android&hl=en");
		}
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
