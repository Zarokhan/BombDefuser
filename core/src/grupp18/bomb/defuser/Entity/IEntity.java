package grupp18.bomb.defuser.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface IEntity {
	
	int getID();
	
	void update(float delta);
	
	void render(SpriteBatch batch);
	
	Rectangle getHitBox();
}
