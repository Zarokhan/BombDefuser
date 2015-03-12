package grupp18.bomb.defuser.PowerUp;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.World.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PowerUp {
	
	
	private World world;
	private float newSpeed, heroBaseSpeed, timer, time, newGravity, baseGravity;
	private Rectangle hitBox;
	private Vector2 pos;
	private int currentState;
	private boolean hitTrue;
	public PowerUp(World _world, float _newSpeed, float x, float y, int _currentState, float _time){
		this.world = _world;
		this.currentState = _currentState;
		this.newSpeed = _newSpeed;
		this.pos = new Vector2(x,y);
		this.time = _time;
		heroBaseSpeed = world.getHero().getSpeed();
		hitBox = new Rectangle(x,y,32,32);
		hitTrue = false;
	}
	
	public void update(float delta){
		switch(currentState){
			case 0:
				if(heroHit()){
					world.getHero().setSpeed(newSpeed);
					hitTrue = true;
					timer = time;
				}
				if(hitTrue){
					timer -=delta;

				}
				if(timer < 0){
					hitTrue = false;
					world.getHero().setSpeed(heroBaseSpeed);
				}
			break;
		}
		
	}
	
	public boolean heroHit(){
		if(world.getHero().getHitBox().overlaps(hitBox)){
			return true;
		}
		return false;
	}
	
	public void render(SpriteBatch batch){
		batch.draw(MyGame.res.fyrkant, pos.x, pos.y);
	}
	public float getTimer(){
		return timer;
	}
	public boolean getHit(){
		return hitTrue;
	}

}
