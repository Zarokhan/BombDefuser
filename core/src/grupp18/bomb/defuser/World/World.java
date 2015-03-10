package grupp18.bomb.defuser.World;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Entity.Enemy;
import grupp18.bomb.defuser.Entity.EntityMoveable;
import grupp18.bomb.defuser.Entity.IEntity;
import grupp18.bomb.defuser.Tiles.ITile;
import grupp18.bomb.defuser.Tiles.TileRec;
import grupp18.bomb.defuser.bomb.Bomb;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class World {
	
	protected List<Enemy> enemies;
	protected List<ITile> topLayer;
	protected List<ITile> collsionLayer;
	protected List<ITile> lowerLayer;
	
	private float gravity;
	
	private EntityMoveable hero;
	private Bomb bomb;
	
	//I Construktorn skall man skicka in den fil/map man vill ladda, men i prototypen har vi inte detta.
	//Därför skapar jag en statisk värld i konstruktorn
	public World(float gravity)
	{
		this.gravity = gravity;
		
		lowerLayer = new ArrayList<ITile>();
		collsionLayer = new ArrayList<ITile>();
		topLayer = new ArrayList<ITile>();
		
		enemies = new ArrayList<Enemy>();
		hero = new EntityMoveable(MyGame.res.dot, 0, 0, 1, 1, 0, 600, 55, 70, Color.MAROON, this, 300);
		bomb = new Bomb(new Vector2(500 + 650, 100 + 50), 100, 2);
		
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
	
	public void addAI(Enemy enemy){
		enemies.add(enemy);
	}
	
	public void setBomb(Bomb bomb){
		this.bomb = bomb;
	}
	
	public void update(float delta)
	{
		for(Enemy i : enemies)
			i.update(delta);
		
		hero.update(delta);
		updateBomb(delta);
		
		for(ITile tile : collsionLayer)
			tile.update(delta);
	}
	
	public void updateBomb(float delta){
		if(bomb != null){
			// Returns true when the bomb explodes
			if(bomb.update(delta)){
				hero.reset();
				bomb.reset();
			}
			
			// Defuse module
			if(hero.getHitBox().overlaps(bomb.getHitbox())){
				if(Gdx.input.isKeyPressed(Keys.SPACE))
					bomb.defuse(delta);
			}
		}
	}
	
	public void render(SpriteBatch batch)
	{
		for(ITile tile : lowerLayer)
			tile.render(batch);
		for(Enemy i : enemies)
			i.render(batch);
		hero.render(batch);
		for(ITile tile : collsionLayer)
			tile.render(batch);
		for(ITile tile : topLayer)
			tile.render(batch);
		if(bomb != null){
			bomb.render(batch);
			MyGame.res.font.draw(batch, "Hurry up!!! You only got " + (int)bomb.getTimeLeft() + " time left!", 20, 300);
		}
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
