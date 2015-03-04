package grupp18.bomb.defuser.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import grupp18.bomb.defuser.World.World;
import grupp18.bomb.defuser.utilities.GameObject;

public class EntityMoveable extends GameObject implements IEntity{

	//Apply velocity varje frame
	private Vector2 velocity;
	private World world;
	
	public EntityMoveable(Texture tex, float sourceX, float sourceY, float sourceWidth, float sourceHeight, float x, float y, float width, float height, Color color, World world) {
		super(tex, sourceX, sourceY, sourceWidth, sourceHeight, x, y, width, height, color);
		this.world = world;
	}

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void update(float delta) {
		velocity.y += world.getGravity() * delta;
		pos.x += velocity.x * delta;
		pos.y += velocity.y * delta;
		super.update(delta);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
	}
	
	public void setVelocity(float x, float y){
		velocity = new Vector2(x, y);
	}
}
