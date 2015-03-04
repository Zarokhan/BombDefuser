package grupp18.bomb.defuser.World;

import java.util.ArrayList;
import java.util.List;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Tiles.ITile;
import grupp18.bomb.defuser.Tiles.TileRec;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	
	protected List<ITile> topLayer;
	protected List<ITile> collsionLayer;
	protected List<ITile> lowerLayer;
	
	//I Construktorn skall man skicka in den fil/map man vill ladda, men i prototypen har vi inte detta.
	//Därför skapar jag en statisk värld i konstruktorn
	public World()
	{
		lowerLayer = new ArrayList<ITile>();
		collsionLayer = new ArrayList<ITile>();
		topLayer = new ArrayList<ITile>();
		
		
		lowerLayer.add(new TileRec(MyGame.getRes().dot, 200, 100, 200, 300, Color.LIGHT_GRAY));
		lowerLayer.add(new TileRec(MyGame.getRes().dot, 800, 100, 300, 150, Color.LIGHT_GRAY));
		
		collsionLayer.add(new TileRec(MyGame.getRes().dot, 0, 100, 400, 50, Color.DARK_GRAY));
		collsionLayer.add(new TileRec(MyGame.getRes().dot, 500, 100, 700, 50, Color.DARK_GRAY));
		collsionLayer.add(new TileRec(MyGame.getRes().dot, 600, 100, 50, 200, Color.DARK_GRAY));
		collsionLayer.add(new TileRec(MyGame.getRes().dot, 800, 250, 300, 50, Color.DARK_GRAY));	
		collsionLayer.add(new TileRec(MyGame.getRes().dot, 200, 400, 200, 50, Color.DARK_GRAY));
		
		topLayer.add(new TileRec(MyGame.getRes().dot, 800, 150, 10, 100, Color.ORANGE));
		topLayer.add(new TileRec(MyGame.getRes().dot, 1090, 150, 10, 100, Color.ORANGE));

	}
	
	public void Update(float delta)
	{
		for(ITile tile : collsionLayer)
			tile.Update(delta);
	}
	
	public void Render(SpriteBatch batch)
	{
		for(ITile tile : lowerLayer)
			tile.render(batch);
		for(ITile tile : collsionLayer)
			tile.render(batch);
		for(ITile tile : topLayer)
			tile.render(batch);
	}

}
