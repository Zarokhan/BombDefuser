package grupp18.bomb.defuser.bomb;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.utilities.GameObject;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bomb extends GameObject implements IBomb{

	private float explodeTime;
	private float defuseTime;
	private float explodeTimer, defuseTimer;
	private boolean defused;
	
	public Bomb(Vector2 pos, float explodeTime, float defuseTime) {
		super(MyGame.res.dot, 0, 0, 50, 50, 0, 0, 50, 50, Color.RED);
		this.explodeTime = explodeTime;
		this.defuseTime = defuseTime;
		this.pos = pos;
		this.hitbox = new Rectangle(pos.x, pos.y, 50, 50);
	}
	
	@Override
	public boolean defuse(float delta){
		if(getTimeLeft() > 0){
			defuseTimer += delta;
			
			if(defuseTimer >= defuseTime){
				defused = true;
				this.color = Color.BLUE;
			}
		}
		
		return true;
	}
	
	@Override
	public void reset(){
		explodeTimer = 0;
		defuseTimer = 0;
		defused = false;
	}
	
	@Override
	public boolean update(float delta) {
		if(!defused){
			explodeTimer += delta;
			
			if(getTimeLeft() <= 0)
				return true;
		}
		
		return false;
	}

	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
		
		String msg = "" + (int)getTimeLeft();
		float width = MyGame.res.font.getBounds(msg).width;
		float height = MyGame.res.font.getBounds(msg).height;
		MyGame.res.font.draw(batch, "" + (int)getTimeLeft(), pos.x + (50 - width)/2, pos.y + (50 + height)/2);
		MyGame.res.font.draw(batch, "Hold space to defuse the bomb.", pos.x - 50, pos.y - 100);
	}
	
	@Override
	public float getTimeLeft(){
		return explodeTime - explodeTimer;
	}
	
	@Override
	public Rectangle getHitBox() {
		return super.getHitbox();
	}

	public float getExplodeTime(){
		return explodeTime;
	}
	public void setExplodeTime(float explodTime){
		this.explodeTime = explodTime;
	}
}
