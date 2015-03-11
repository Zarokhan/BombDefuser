package grupp18.bomb.defuser.Fan;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Tiles.TileRec;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Fan extends TileRec{
	float timeCounter, time, force;
	int distance;
	boolean activated, timed;
	EDirections direction;
	Rectangle fanRec;
	Color colorOn = Color.GREEN, colorOff = Color.RED;
	
	
	public Fan(float x, float y, float width, float height, float time, int distance, float force, EDirections direction) {
		super(MyGame.res.dot, x, y, width, height, Color.GREEN);
		this.activated = true;
		this.timed = (time == 0) ? false : true;
		this.time = time;
		this.timeCounter = 0;
		this.force = force;
		this.distance = distance;
		this.direction = direction;
		this.fanRec = rectangleAlgoritm();
	}

	@Override
	public void update(float delta)
	{
		super.update(delta);
		if(timed)
		{
			//activate and deactivate over time
			timeCounter += delta;
			if(timeCounter > time)
			{
				timeCounter = 0;
				activated = (activated) ? false : true;
				if(activated)
					setColor(colorOn);
				else
					setColor(colorOff);
			}
		}
	}
	
	private Rectangle rectangleAlgoritm()
	{
		Rectangle rectangle = new Rectangle();
		Rectangle hitBox = getHitBox();
		switch (direction) {
		case Up:
			rectangle = new Rectangle(hitbox.x, hitBox.y + hitbox.height, hitbox.width, distance);
			break;
		case Down:
			rectangle = new Rectangle(hitbox.x, hitBox.y + distance, hitbox.width, distance);
			break;
		case Right:
			rectangle = new Rectangle(hitbox.x + hitBox.width, hitBox.y, distance, hitbox.width);
			break;
		case Left:
			rectangle = new Rectangle(hitbox.x - distance, hitBox.y, hitbox.width, distance);
			break;
		}
		return rectangle;
	}
	
	public Vector2 getForceOnPoint(Vector2 vector){
		//System.out.println(((vector.y - fanRec.y) / fanRec.height));
		switch (direction) {
		case Up: return new Vector2(0, (1 - ((vector.y - 60 - fanRec.y) / fanRec.height)) * force);
		case Down: return new Vector2(0, (fanRec.height / (fanRec.y + fanRec.height - vector.y)) * force * -1);
		case Left: return new Vector2((fanRec.width / (fanRec.x + fanRec.x - vector.x)) * force * -1, 0);
		case Right: return new Vector2((fanRec.width / (vector.x - fanRec.x)) * force, 0);
		}
		return new Vector2(0, 0);
	}
	@Override
	public void render(SpriteBatch batch)
	{
		batch.setColor(1, 0, 0, 0.3f);
		batch.draw(MyGame.res.dot, fanRec.x, fanRec.y, fanRec.width, fanRec.height);
		batch.setColor(Color.WHITE);
		super.render(batch);
	}
	
	public Rectangle getFanRec(){
		return fanRec;
	}
	
	public boolean isActivated(){
		return activated;
	}

}
