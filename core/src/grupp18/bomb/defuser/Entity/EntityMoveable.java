package grupp18.bomb.defuser.Entity;

import grupp18.bomb.defuser.Tiles.ITile;
import grupp18.bomb.defuser.Utilities.GameObject;
import grupp18.bomb.defuser.World.World;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class EntityMoveable extends GameObject implements IEntity{

	//Apply velocity varje frame
	protected Vector2 velocity, forces, spawn;
	protected float speed;
	protected World world;
	protected Boolean isOnGround;
	protected Rectangle headRec, feetRec;
	
	public EntityMoveable(Texture tex, float sourceX, float sourceY, float sourceWidth, float sourceHeight, float x, float y, float width, float height, Color color, World world, float speed) {
		super(tex, sourceX, sourceY, sourceWidth, sourceHeight, x, y, width, height, color);
		this.spawn = new Vector2(x, y);
		this.world = world;
		this.speed = speed;
		this.velocity = new Vector2(0, 0);
		this.forces = new Vector2();
		this.isOnGround = false;
		
		headRec = new Rectangle(0, 0, width, 10);
		feetRec = new Rectangle(0, 0, width, 10);
	}
	
	public void reset(){
		pos = new Vector2(spawn.x, spawn.y);
	}
	
	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void update(float delta) {
		velocity.x += forces.x;
		velocity.y += forces.y;
		moveHorizontal(delta);
		moveVertical(delta);
		//System.out.println(velocity + " - " + forces);
		forces = new Vector2(0, 0);
		
		// update head and feet rectangles
		headRec.x = this.pos.x;
		headRec.y = this.pos.y + height - headRec.height;
		feetRec.x = this.pos.x;
		feetRec.y = this.pos.y;
	}
	
	protected void moveVertical(float delta){
		velocity.y += world.getGravity();
		pos.y += (velocity.y) * delta;
		super.updateHitBox();
		ITile tile = world.CollisionEntityTile(this);
		if(tile != null)
		{
			Rectangle tileHitBox = tile.getHitBox();
			if(velocity.y < 0){
				pos.y = tileHitBox.y + tileHitBox.height;
				isOnGround = true;
			}
			else
				isOnGround = false;
			if(velocity.y > 0)
				pos.y = tileHitBox.y - height;
			velocity.y = 0;
		}
		else
			isOnGround = false;
	}
	
	protected void moveHorizontal(float delta){
		pos.x += (velocity.x) * delta;
		super.updateHitBox();
		ITile tile = world.CollisionEntityTile(this);
		if(tile != null)
		{
			Rectangle tileHitBox = tile.getHitBox();
			if(velocity.x < 0)
				pos.x = tileHitBox.x + tileHitBox.width;
			if(velocity.x > 0)
				pos.x = tileHitBox.x - width;
			velocity.x = 0;
		}
	}
	public void moveRight(){
		velocity.x = speed;
	}
	public void moveLeft(){
		velocity.x = -speed;
	}
	public void moveStop(){
		velocity.x = 0;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
	}
	
	public void setVelocity(float x, float y){
		velocity = new Vector2(x, y);
	}
	public void applyVelocity(float x, float y){
		velocity.x += x;
		velocity.y += y;
	}
	public void applyForce(float x, float y){
		forces.x += x;
		forces.y += y;
	}
	
	public Rectangle getHeadRec(){
		return headRec;
	}
	
	public Rectangle getFeetRec(){
		return feetRec;
	}
	
	@Override
	public Rectangle getHitBox() {
		return super.getHitbox();
	}
	
	public boolean isOnGround(){
		return isOnGround;
	}
	public float getSpeed(){
		return speed;
	}
	public void setSpeed(float newSpeed){
		this.speed = newSpeed;
	}
}
