package grupp18.bomb.defuser.statesystem;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.allstates.AItestState;
import grupp18.bomb.defuser.allstates.GameState;
import grupp18.bomb.defuser.allstates.LevelState;
import grupp18.bomb.defuser.allstates.MenyState;

public class StateManager{
	
	private States currentState;
	
	//Statemanager should not be a part of State.
	//kan ej heta game, kolla State klassen --> Funkar nu, då vi inte ärver state!
	private GameState game;
	private MenyState meny;
	private LevelState levels;
	private AItestState AItest; 
	
	public StateManager(MyGame game) {
		this.game = new GameState(game);
		this.meny = new MenyState(game);
		this.levels = new LevelState(game);
		this.AItest = new AItestState(game);
		
		currentState = States.Meny;
	}
	
	public void setState(States state){
		currentState = state;
	}
	
	public void update(float delta) {
		switch (currentState) {
		case Meny:
			meny.update(delta);
			break;
		case WorldMap:
			levels.update(delta);
			break;
		case Game:
			game.update(delta);
			break;
		case AItest:
			AItest.update(delta);
			break;
		}
	}

	public void render(SpriteBatch batch) {
		switch (currentState) {
		case Meny:
			meny.render(batch);
			break;
		case WorldMap:
			levels.render(batch);
			break;
		case Game:
			game.render(batch);
			break;
		case AItest:
			AItest.render(batch);
			break;
		}
	}
}
