/**
 * 
 */
package com.GGI.Screens;

import java.util.Timer;
import java.util.TimerTask;

import com.GGI.OrbitBall.OrbitBall;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Emmett Deen
 *
 */
public class OpeningScreen implements Screen{
	
	private OrbitBall g;
	private SpriteBatch pix;
	private boolean start = true;
	private Timer timer;
	public BitmapFont font;
	public float w = Gdx.graphics.getWidth(),h = Gdx.graphics.getHeight();
	public OpeningScreen(OrbitBall g){
		this.g=g;
		pix = new SpriteBatch();
		font = g.font;
		myTimer();
	}

	private void myTimer() {
		TimerTask timerTask = new TimerTask() {

	          @Override
	          public void run() {
	        	 
	        	  Gdx.app.postRunnable(new Runnable() {
	     	         @Override
	     	         public void run() {
	     	            // process the result, e.g. add it to an Array<Result> field of the ApplicationListener.
	     	        	 g.setScreen(new MainMenuScreen(g));
	     	         }
	     	      });
	          }
	      };
		timer = new Timer();
		timer.schedule(timerTask, 2000);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		pix.begin();
		font.setColor(Color.WHITE);
		font.setScale(h/5000);
		font.draw(pix, "Powered by", (w/2)-(font.getBounds("Powered by").width/2), 8*h/12);
		font.setScale(h/1000);
		font.draw(pix, "GG", (w/2)-(font.getBounds("GGI").width/2), 7*h/12);
		font.setColor(Color.ORANGE);
		font.draw(pix, "I", (w/2)-(font.getBounds("GGI").width/2)+(font.getBounds("GG").width), 7*h/12);
		
		pix.end();
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		//g.ar.playAd();
		
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

}
