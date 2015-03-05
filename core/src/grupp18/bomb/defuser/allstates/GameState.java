package grupp18.bomb.defuser.allstates;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.World.World;
import grupp18.bomb.defuser.statesystem.State;
import grupp18.bomb.defuser.utilities.Controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState extends State {
	
	private World world;
	private Controller control;
	
	public GameState(MyGame game) {
		super(game);
		world = new World(-30);
		control = new Controller(world.getHero());
	}

	@Override
	public void update(float delta) {
		control.update();
		world.update(delta);
	}

	@Override
	public void render(SpriteBatch batch) {
		world.render(batch);
	}

}
