package grupp18.bomb.defuser.World;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Entity.EntityMoveable;
import grupp18.bomb.defuser.Entity.IEntity;
import grupp18.bomb.defuser.Tiles.ITile;
import grupp18.bomb.defuser.Tiles.TileRec;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class World {
	
	protected List<ITile> topLayer;
	protected List<ITile> collsionLayer;
	protected List<ITile> lowerLayer;
	
	private float gravity;
	
	EntityMoveable hero;
	//I Construktorn skall man skicka in den fil/map man vill ladda, men i prototypen har vi inte detta.
	//Därför skapar jag en statisk värld i konstruktorn
	public World(float gravity)
	{
		this.gravity = gravity;
		
		lowerLayer = new ArrayList<ITile>();
		collsionLayer = new ArrayList<ITile>();
		topLayer = new ArrayList<ITile>();
		
		hero = new EntityMoveable(MyGame.res.dot, 0, 0, 1, 1, 0, 600, 55, 70, Color.MAROON, this, 300);
		
		lowerLayer.add(new TileRec(MyGame.res.dot, 200, 100, 200, 300, Color.LIGHT_GRAY));
		lowerLayer.add(new TileRec(MyGame.res.dot, 800, 100, 300, 150, Color.LIGHT_GRAY));
		
		collsionLayer.add(new TileRec(MyGame.res.dot, 0, 100, 400, 50, Color.DARK_GRAY));
		collsionLayer.add(new TileRec(MyGame.res.dot, 500, 100, 700, 50, Color.DARK_GRAY));
		collsionLayer.add(new TileRec(MyGame.res.dot, 600, 100, 50, 200, Color.DARK_GRAY));
		collsionLayer.add(new TileRec(MyGame.res.dot, 800, 250, 300, 50, Color.DARK_GRAY));	
		collsionLayer.add(new TileRec(MyGame.res.dot, 200, 400, 200, 50, Color.DARK_GRAY));
		
		topLayer.add(new TileRec(MyGame.res.dot, 800, 150, 10, 100, Color.ORANGE));
		topLayer.add(new TileRec(MyGame.res.dot, 1090, 150, 10, 100, Color.ORANGE));

	}
	
	public void update(float delta)
	{
		hero.update(delta);
		for(ITile tile : collsionLayer)
			tile.update(delta);
	}
	
	public void render(SpriteBatch batch)
	{
		for(ITile tile : lowerLayer)
			tile.render(batch);
		hero.render(batch);
		for(ITile tile : collsionLayer)
			tile.render(batch);
		for(ITile tile : topLayer)
			tile.render(batch);
	}
	
	public ITile CollisionEntityTile(IEntity entity)
	{
		for(ITile tile : collsionLayer)
		{
			Rectangle tempRec = new Rectangle();
			if(Intersector.intersectRectangles(entity.getHitBox(), tile.getHitBox(), tempRec))
				return tile;
		}
		return null;
	}
	
	public float getGravity(){
		return gravity;
	}
	
	public EntityMoveable getHero(){
		return hero;
	}

}
