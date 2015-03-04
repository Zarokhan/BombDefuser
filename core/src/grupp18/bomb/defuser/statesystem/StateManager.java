package grupp18.bomb.defuser.statesystem;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.allstates.GameState;
import grupp18.bomb.defuser.allstates.MenyState;

public class StateManager extends State {
	
	private States currentState;
	
	// Alla states här
	private GameState game1; // kan ej heta game, kolla State klassen
	private MenyState meny;
	
	public StateManager(MyGame game) {
		super(game);
		game1 = new GameState(game);
		meny = new MenyState(game);
		
		currentState = States.Game;
	}

	@Override
	public void update(float delta) {
		switch (currentState) {
		case Meny:
			meny.update(delta);
			break;
		case WorldMap:
			break;
		case Game:
			game1.update(delta);
			break;
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		switch (currentState) {
		case Meny:
			meny.render(batch);
			break;
		case WorldMap:
			break;
		case Game:
			game1.render(batch);
			break;
		}
	}
}
