/**
 * 
 */
package com.GGI.Screens;

import java.util.ArrayList;

import com.GGI.Objects.Barrier;
import com.GGI.Objects.Player;
import com.GGI.OrbitBall.OrbitBall;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;



/**
 * @author Emmett Deen
 *
 */
public class GameScreen implements Screen, InputProcessor{

	public OrbitBall o;
	public SpriteBatch pic;
	public int hs;
	public TextureRegion c = new TextureRegion(new Texture(Gdx.files.internal("CutCircle.png")));
	public ArrayList<Barrier> barriers  = new ArrayList<Barrier>();
	public float speed=.5f;
	public Player player;
	public Texture pText = new Texture(Gdx.files.internal("Circle.png"));
	public boolean gameOver = false;
	public boolean start = true;
	public int count = 0;
	public BitmapFont font;
	private int score = 0;
	public int w = Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	
	
	public GameScreen(OrbitBall o){
		this.o=o;
		this.font=o.font;
		
		
			barriers.add(new Barrier(this,1,(float) (Math.random()*360)));
			barriers.add(new Barrier(this,2,-(float) (Math.random()*360)));
			barriers.add(new Barrier(this,3,(float) (Math.random()*360)));
			barriers.add(new Barrier(this,4,-(float) (Math.random()*360)));
			
			player = new Player(this);
			
			
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		pic.begin();
		font.setScale(((float)(h))/1500);
		font.setColor(Color.BLACK);
		font.draw(pic, ""+score, (w/2)-(font.getBounds(""+score).width/2), 7*h/8);
		font.setScale(((float)(h))/4000);
		font.draw(pic, "HighScore: "+hs, (w/2)-(font.getBounds("HighScore: "+hs).width/2), 11*h/12);
		
		
		if(gameOver){
		
			if(o.gameCount%3==0&&o.gameCount>0){o.popup();System.out.println("Popup");}
			
			if(score>hs){hs=score;
			FileHandle file = Gdx.files.local("score.txt");
			file.writeString(""+hs, false);
			
			}
			
			Gdx.gl.glClearColor(1,0,0,1);
			Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
			
			for(int i = 0; i < barriers.size();i++){
				Barrier b = barriers.get(i);
				
				pic.draw(b, b.bounds.x, b.bounds.y, b.bounds.width/2, b.bounds.height/2, b.bounds.width, b.bounds.height, 1, 1, b.rot);
			}
			
			
			if(count>=100){
			o.setScreen(new GameScreen(o));
			}
			else{
			//	System.out.println(count);
				count++;
			}
		}
		
		
		if(!gameOver){
		
		
		
		for(int i = 0; i < barriers.size();i++){
			Barrier b = barriers.get(i);
			if(!start){
			b.update();
			speed+=.0001;
			}
			if(b.rot>0){b.rot+=speed*(2*b.scale);}else{b.rot-=speed*(2*b.scale);}
			pic.draw(b, b.bounds.x, b.bounds.y, b.bounds.width/2, b.bounds.height/2, b.bounds.width, b.bounds.height, 1, 1, b.rot);
		}
		player.update();
		pic.draw(player, player.bounds.x, player.bounds.y, player.bounds.width/2, player.bounds.height/2, player.bounds.width, player.bounds.height, 1, 1, player.rot);
		
		}
		
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
		if(Gdx.files.local("score.txt").exists()){
			FileHandle file = Gdx.files.local("score.txt");
			hs=Integer.parseInt(file.readString());
		}
		else{
			FileHandle file = Gdx.files.local("score.txt");
			file.writeString("0", false);
		}
		
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
		start = false;
		if(!gameOver){
		//System.out.println((Math.abs((player.rot)-(barriers.get(player.tier+1).rot)))%360);
		if(player.tier<barriers.size()-1&&((Math.abs((player.rot)-(barriers.get(player.tier+1).rot)))%360<35||(Math.abs((player.rot)-(barriers.get(player.tier+1).rot)))%360>325)){
		player.tier++;player.a*=-1;score ++;
		player.dif = (Math.abs((player.rot)-(barriers.get(player.tier).rot)))%360;
		System.out.println(player.dif);
		}
		else{
			
			gameOver=true;
			o.gameCount++;
		}
		}
		if(player.tier>=barriers.size()){player.tier--;}
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
