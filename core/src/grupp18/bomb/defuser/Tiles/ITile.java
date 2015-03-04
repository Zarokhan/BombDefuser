package grupp18.bomb.defuser.Tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public interface ITile{

	int getId();
	
	Boolean getIsCollision();
	
	void update(float delta);
	
	void render(SpriteBatch batch);
}