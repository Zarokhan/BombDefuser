package grupp18.bomb.defuser.allstates;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.World.World;
import grupp18.bomb.defuser.statesystem.State;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameState extends State {
	
	private Vector2 pos = Vector2.Zero;
	private World world;
	
	public GameState(MyGame game) {
		super(game);
		world = new World(-700);
	}

	@Override
	public void update(float delta) {
		pos.x += delta * 10;
		world.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		MyGame.res.font.draw(batch, "Prototype", 10, MyGame.HEIGHT - 10);
		world.render(batch);
	}

}
