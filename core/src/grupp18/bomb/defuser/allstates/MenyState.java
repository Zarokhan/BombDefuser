package grupp18.bomb.defuser.allstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.statesystem.State;

public class MenyState extends State {

	public MenyState(MyGame game) {
		super(game);
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(SpriteBatch batch) {
		game.getRes().font.draw(batch, "Meny", 200, 200);
	}

}
