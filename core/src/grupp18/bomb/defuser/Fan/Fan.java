package grupp18.bomb.defuser.Fan;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Tiles.TileRec;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fan extends TileRec{
	float timeCounter, time, force;
	int distance;
	boolean activated, timed;
	EDirections direction;
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
	@Override
	public void render(SpriteBatch batch)
	{
		super.render(batch);
	}

}
