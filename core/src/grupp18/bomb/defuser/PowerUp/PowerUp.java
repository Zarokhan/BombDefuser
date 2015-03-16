package grupp18.bomb.defuser.PowerUp;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Bomb.Bomb;
import grupp18.bomb.defuser.World.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PowerUp {
	
	private World world;
	private Bomb bomb;
	private float newSpeed, heroBaseSpeed, timer, time, worldTimer; // newGravity, baseGravity;
	private Rectangle hitBox;
	private Vector2 pos;
	private EPowerUp powerUp;
	private boolean hitTrue, active;
	
	public PowerUp(Bomb bomb, World world, float newSpeed, float x, float y, EPowerUp powerUp, float time){
		this.world = world;
		this.bomb = bomb;
		this.powerUp = powerUp;
		this.newSpeed = newSpeed;
		this.time = time;
		this.pos = new Vector2(x, y);
		active = true;
		heroBaseSpeed = this.world.getHero().getSpeed();
		hitBox = new Rectangle(x, y, 32, 32);
		hitTrue = false;
	}
	
	public void update(float delta){
		switch(powerUp){
			case IncreasingSpeed:
				if(heroHit()){
					world.getHero().setSpeed(newSpeed);
					hitTrue = true;
					active = false;
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
			case SlowTimeOnBomb:
				if(heroHit()){
					hitTrue = true;
					active = false;
					timer = time;
				}
				if(hitTrue){
					timer -=delta;
					worldTimer = bomb.getExplodeTime();				
					worldTimer +=delta * 0.8f;
					bomb.setExplodeTime(worldTimer);

				}
				if(timer < 0){
					hitTrue = false;
				}
			break;
				
		}
		
		
		checkActive();
	}
	
	public void checkActive(){
		if(!active){
			hitBox = new Rectangle(0, 0, 0, 0);
		}
	}
	
	public boolean heroHit(){
		if(world.getHero().getHitBox().overlaps(hitBox)){
			return true;
		}
		return false;
	}
	
	public void render(SpriteBatch batch){
		if(active)
			batch.draw(MyGame.res.fyrkant, pos.x, pos.y);
	}
	public float getTimer(){
		return timer;
	}
	public boolean getHit(){
		return hitTrue;
	}

}
