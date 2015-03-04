package grupp18.bomb.defuser.allstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.statesystem.State;

public class GameState extends State {
	
	private Vector2 pos = Vector2.Zero;
	
	public GameState(MyGame game) {
		super(game);
	}

	@Override
	public void update(float delta) {
		pos.x += delta * 10;
	}

	@Override
	public void render(SpriteBatch batch) {
		game.getRes().font.draw(batch, "GAME", 200, 200);
	}

}
