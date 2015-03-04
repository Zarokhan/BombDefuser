package grupp18.bomb.defuser.statesystem;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import grupp18.bomb.defuser.MyGame;

public abstract class State {
	
	protected MyGame game;
	
	public State(MyGame game){
		this.game = game;
	}
	
	public abstract void update(float delta);
	public abstract void render(SpriteBatch batch);
}
