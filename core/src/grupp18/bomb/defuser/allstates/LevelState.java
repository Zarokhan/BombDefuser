package grupp18.bomb.defuser.allstates;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.statesystem.State;
import grupp18.bomb.defuser.statesystem.States;
import grupp18.bomb.defuser.utilities.Button;

public class LevelState extends State {
	
	private OrthographicCamera camera;
	private Button btnGame, btnAI;
	
	public LevelState(MyGame game) {
		super(game);
		// init camera
		camera = new OrthographicCamera(1280, 720);
		camera.translate(1280/2, 720/2);
		camera.update();
		
		// init buttons
		btnGame = new Button(MyGame.res.btnGame);
		btnGame.setPos(new Vector2(610, 540));
		btnAI = new Button(MyGame.res.btnAI);
		btnAI.setPos(new Vector2(575, 410));
	}

	@Override
	public void update(float delta) {
		// GameState btn
		if(btnGame.update())
			game.getStateManager().setState(States.Game);
		
		// AI test btn
		if(btnAI.update())
			game.getStateManager().setState(States.AItest);
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.draw(MyGame.res.europe, 0, -240);
		btnGame.render(batch);
		btnAI.render(batch);
	}

}
