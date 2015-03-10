package grupp18.bomb.defuser.allstates;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.statesystem.State;
import grupp18.bomb.defuser.statesystem.States;
import grupp18.bomb.defuser.utilities.Button;
import grupp18.bomb.defuser.utilities.GameObject;

public class MenyState extends State {

	private OrthographicCamera camera;
	private GameObject logo;
	private Button btnPlay;
	
	public MenyState(MyGame game) {
		super(game);
		
		// init camera
		camera = new OrthographicCamera(1280, 720);
		camera.translate(1280/2, 720/2);
		camera.update();
		
		logo = new GameObject(game.res.logo);
		logo.setPos(new Vector2((MyGame.WIDTH - logo.getWidth())/2, 120));            
		logo.setScale(0.5f);
		btnPlay = new Button(game.res.btnPlay);
		btnPlay.setPos(new Vector2((MyGame.WIDTH - btnPlay.getWidth())/2, 100));
	}

	@Override
	public void update(float delta) {
		if(btnPlay.update())
			game.getStateManager().setState(States.WorldMap);
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.draw(MyGame.res.character, 0, 0);
		logo.render(batch);
		btnPlay.render(batch);
	}

}
