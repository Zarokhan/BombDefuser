package grupp18.bomb.defuser.Fan;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import grupp18.bomb.defuser.Entity.EntityMoveable;
import grupp18.bomb.defuser.World.World;

public class FanHandler {

	private static List<Fan> fans = new ArrayList<Fan>();
	
	public static void addFan(Fan fan, World world)
	{
		world.getCollisionLayer().add(fan);
		fans.add(fan);
	}
	public static void updateForces(EntityMoveable hero)
	{
		for (Fan fan : fans) {
			if(!fan.isActivated())
				continue;
			Rectangle recTemp = new Rectangle();
			if(Intersector.intersectRectangles(fan.getFanRec(), hero.getHitBox(), recTemp))
			{
				Vector2 force = fan.getForceOnPoint(hero.getCenterPosition());
				hero.applyForce(force.x, force.y);
				//System.out.println(force);
			}
		}
	}
}
