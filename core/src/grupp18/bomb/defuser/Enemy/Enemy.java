package grupp18.bomb.defuser.Enemy;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Entity.EntityMoveable;
import grupp18.bomb.defuser.Tiles.TileRec;
import grupp18.bomb.defuser.World.World;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends EntityMoveable {
	
	private enum Direction{
		Left, Right, None
	}
	
	private int ID;
	private World world;
	
	protected Direction currentDir;
	protected TileRec leftTile, rightTile;
	
	public Enemy(Texture texture, int ID, Vector2 pos, Color color, World world, float speed) {
		super(texture, 0, 0, 50, 50, pos.x, pos.y, 50, 50,
				color, world, speed);
		this.ID = ID;
		this.world = world;
		
		leftTile = new TileRec(MyGame.res.dot, pos.x, pos.y, 0, 0, Color.BLUE);
		leftTile.setWidth(width);
		leftTile.setHeight(height);
		rightTile = new TileRec(MyGame.res.dot, pos.x, pos.y, 0, 0, Color.BLUE);
		rightTile.setWidth(width);
		rightTile.setHeight(height);
		
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
	
	private void updateFreeFallDetectors(float delta){
		leftTile.updatePos(this.getPos().x - width, this.getPos().y - 5);
		rightTile.updatePos(this.getPos().x + width, this.getPos().y - 5);
		leftTile.update(delta);
		rightTile.update(delta);
	}
	
	@Override
	public void update(float delta) {
		updateFreeFallDetectors(delta);
		setCurrentDirection();
		
		if(this.isOnGround()){
			switch (currentDir) {
			case Left:
				
				// Check if left detector collide with any collide tiles/objects 
				//if(world.CollisionWithAnyTile(leftTile) != null)
					//speed = -speed;
				
				if(speed > velocity.x)
					velocity.x -= speed * delta;
				
				break;
			case Right:

				// Check if right detector collide with any collide tiles/objects 
				/*if(world.CollisionWithAnyTile(leftTile.getHitBox()){
					String msg = "Enemy " + this.ID + " has changed direction to left.";
					System.out.println(msg);
					speed = -speed;
					velocity.x = 0;
				}*/
				
				if(speed < velocity.x)
					velocity.x += speed * delta;
				
				break;
			case None:
				break;
			}
			if(speed > this.velocity.x)
				velocity.x += speed * delta;
		}
		super.update(delta);
	}
	
	@Override
	public void moveLeft() {

	}
	
	@Override
	public void moveRight() {
		
	}
	
	@Override
	public void render(SpriteBatch batch) {
		leftTile.render(batch);
		rightTile.render(batch);
		super.render(batch);
	}
}
