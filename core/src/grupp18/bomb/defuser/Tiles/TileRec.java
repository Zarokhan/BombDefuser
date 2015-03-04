package grupp18.bomb.defuser.Tiles;

import grupp18.bomb.defuser.utilities.GameObject;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileRec extends GameObject implements ITile{

	public TileRec(Texture texture, float x, float y, float width, float height, Color color) {
		super(texture, 0, 0, 1, 1, x, y, width, height, color);
	}

	@Override
	public int getId() {
		return 0;
	}


	@Override
	public Boolean getIsCollision() {
		return true;
	}

	@Override
	public void Update(float delta) {
		//Moving Platforms needs update etc...
	}

	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
	}

}
