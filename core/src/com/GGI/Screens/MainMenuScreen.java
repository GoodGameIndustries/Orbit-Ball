package com.GGI.Screens;

import com.GGI.OrbitBall.OrbitBall;
import com.GGI.UI.Button;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainMenuScreen implements Screen,InputProcessor{

	public OrbitBall o;
	public Texture bg = new Texture(Gdx.files.internal("MainScreen.png"));
	public Button help = new Button("Help.png","HelpDown.png");
	public Button play = new Button("Play.png","PlayDown.png");
	public SpriteBatch pic;
	public int w = Gdx.graphics.getWidth(),h = Gdx.graphics.getHeight();
	
	public MainMenuScreen(OrbitBall o){
		this.o=o;
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		pic.begin();
		pic.draw(bg,0,0,w,h);
		pic.draw(play.getState(),(w/2)-(w/8),5*h/8,(w/4),(w/4));
		pic.draw(help.getState(),(w/2)-(w/8),3*h/8,(w/4),(w/4));
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
		if(screenX>(w/2)-(w/8)&&screenX<((w/2)-(w/8))+w/4){
			if(screenY>5*h/8&&screenY<(5*h/4)+w/4){
				play.press();
			}
			else if(screenY>3*h/8&&screenY<(3*h/4)+w/4){
				help.press();
			}
			
		}
		return true;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = h-screenY;
		help.release();
		play.release();
		
		if(screenX>(w/2)-(w/8)&&screenX<((w/2)-(w/8))+w/4){
			if(screenY>5*h/8&&screenY<(5*h/4)+w/4){
				o.setScreen(new GameScreen(o));
			}
			else if(screenY>3*h/8&&screenY<(3*h/4)+w/4){
				o.setScreen(new HelpScreen(o));
			}
			
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
