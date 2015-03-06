package grupp18.bomb.defuser.bomb;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface IBomb {
	
	boolean update(float delta);
	
	void render(SpriteBatch batch);
	
	Rectangle getHitBox();
}
