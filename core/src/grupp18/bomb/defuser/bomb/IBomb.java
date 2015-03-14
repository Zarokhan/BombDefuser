package grupp18.bomb.defuser.Bomb;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface IBomb {
	
	
	void reset();
	
	boolean defuse(float delta);
	
	boolean update(float delta);
	
	void render(SpriteBatch batch);
	
	float getTimeLeft();
	
	Rectangle getHitBox();
}
