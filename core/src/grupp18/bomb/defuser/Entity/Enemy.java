package grupp18.bomb.defuser.Entity;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.World.World;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends EntityMoveable {

	public Enemy(Vector2 pos, Color color, World world, float speed) {
		super(MyGame.res.dot, 0, 0, 50, 50, pos.x, pos.y, 50, 50,
				color, world, speed);
		// TODO Auto-generated constructor stub
	}
}
