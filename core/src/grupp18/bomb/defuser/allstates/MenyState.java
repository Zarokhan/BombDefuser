package grupp18.bomb.defuser.allstates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.statesystem.State;
import grupp18.bomb.defuser.utilities.Button;
import grupp18.bomb.defuser.utilities.GameObject;

public class MenyState extends State {

	private GameObject logo;
	private Button btnPlay;
	
	public MenyState(MyGame game) {
		super(game);
		
		logo = new GameObject(game.res.logo);
		
		btnPlay = new Button(game.res.btnPlay);
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(SpriteBatch batch) {
		MyGame.res.font.draw(batch, "Prototype", 0, 0);
		
		logo.render(batch);
		btnPlay.render(batch);
	}

}
