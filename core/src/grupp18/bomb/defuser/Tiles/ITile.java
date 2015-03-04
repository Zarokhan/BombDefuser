package grupp18.bomb.defuser.Tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public interface ITile{

	public int getId();
	
	public Boolean getIsCollision();
	
	public void Update(float delta);
	
	public void render(SpriteBatch batch);
}
