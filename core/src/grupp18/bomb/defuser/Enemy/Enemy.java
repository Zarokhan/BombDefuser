package grupp18.bomb.defuser.Enemy;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Entity.EntityMoveable;
import grupp18.bomb.defuser.Tiles.ITile;
import grupp18.bomb.defuser.Tiles.TileRec;
import grupp18.bomb.defuser.World.World;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends EntityMoveable {
	
	private enum Direction{
		Left, Right, None
	}
	
	private int ID;
	private World world;
	
	protected Direction currentDir;
	protected Rectangle leftRec, rightRec;
	
	protected boolean deathWish;
	
	public Enemy(Texture texture, int ID, Vector2 pos, float width, float height, Color color, World world, float speed) {
		super(texture, 0, 0, width, height, pos.x, pos.y, width, height,
				color, world, speed);
		this.ID = ID;
		this.world = world;
		
		leftRec = new Rectangle(0, 0, width, height);
		rightRec = new Rectangle(0, 0, width, height);
		
		setCurrentDirection();
	}
	
	private void setCurrentDirection(){
		if(speed > 0)
			currentDir = Direction.Right;
		else if(speed < 0)
			currentDir = Direction.Left;
		else
			currentDir = Direction.None;
	}
	
	private void updateRectangles(){
		leftRec.x = this.getPos().x - width;
		leftRec.y = this.getPos().y - 5;
		rightRec.x = this.getPos().x + width;
		rightRec.y = this.getPos().y - 5;
	}
	
	@Override
	protected void moveHorizontal(float delta) {
		pos.x += (velocity.x) * delta;
		super.updateHitBox();
		ITile tile = world.CollisionEntityTile(this);
		if(tile != null)
		{
			Rectangle tileHitBox = tile.getHitBox();
			if(velocity.x < 0){
				String msg = "Enemy " + this.ID + " has collided with left wall/object, changes direction to right.";
				System.out.println(msg);
				speed = -speed;
				velocity.x = speed;
				pos.x = tileHitBox.x + tileHitBox.width;
			}
			if(velocity.x > 0){
				String msg = "Enemy " + this.ID + " has collided with right wall/object, changes direction to left.";
				System.out.println(msg);
				speed = -speed;
				velocity.x = speed;
				pos.x = tileHitBox.x - width;
			}
			//velocity.x = 0;
		}
	}
	
	@Override
	public void update(float delta) {
		if(!deathWish){
			updateRectangles();
			setCurrentDirection();
			
			if(this.isOnGround()){
				switch (currentDir) {
				case Left:
					
					// Check if left detector collide with any collide tiles/objects 
					if(!world.CollisionWithAnyTile(leftRec)){
						String msg = "Enemy " + this.ID + " has changes direction to left.";
						System.out.println(msg);
						speed = -speed;
						velocity.x = speed;
					}
					
					if(speed < velocity.x)
						velocity.x += speed * delta;
					
					break;
				case Right:

					// Check if right detector collide with any collide tiles/objects 
					if(!world.CollisionWithAnyTile(rightRec)){
						String msg = "Enemy " + this.ID + " has changed direction to left.";
						System.out.println(msg);
						speed = -speed;
						velocity.x = speed;
					}
					
					if(speed > velocity.x)
						velocity.x += speed * delta;
					
					break;
				case None:
					break;
				}
				if(speed > this.velocity.x)
					velocity.x += speed * delta;
			}
			super.update(delta);
			
			if(world.getHero().getFeetRec().overlaps(this.feetRec)){
				deathWish = true;
				velocity.y = -1000;
				MyGame.res.hurt.play();
			}
		}
		
		if(deathWish){
			this.pos.x += velocity.x * delta;
			this.pos.y += velocity.y * delta;
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
	}
}
