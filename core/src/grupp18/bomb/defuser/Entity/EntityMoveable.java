package grupp18.bomb.defuser.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Tiles.ITile;
import grupp18.bomb.defuser.World.World;
import grupp18.bomb.defuser.utilities.GameObject;

public class EntityMoveable extends GameObject implements IEntity{

	//Apply velocity varje frame
	private Vector2 velocity, forces, spawn;
	private float speed;
	private World world;
	private Boolean isOnGround;
	
	public EntityMoveable(Texture tex, float sourceX, float sourceY, float sourceWidth, float sourceHeight, float x, float y, float width, float height, Color color, World world, float speed) {
		super(tex, sourceX, sourceY, sourceWidth, sourceHeight, x, y, width, height, color);
		this.spawn = new Vector2(x, y);
		this.world = world;
		this.speed = speed;
		this.velocity = Vector2.Zero;
		this.forces = Vector2.Zero;
		this.isOnGround = false;
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
		moveHorizontal(delta);
		moveVertical(delta);
	}
	
	private void moveVertical(float delta){
		velocity.y += world.getGravity();
		pos.y += velocity.y * delta;
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
	
	private void moveHorizontal(float delta){
		pos.x += velocity.x * delta;
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

	@Override
	public Rectangle getHitBox() {
		return super.getHitbox();
	}
	
	public boolean isOnGround(){
		return isOnGround;
	}
}
