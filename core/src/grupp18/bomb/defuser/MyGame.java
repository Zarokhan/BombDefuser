package grupp18.bomb.defuser;

import grupp18.bomb.defuser.statesystem.StateManager;
import grupp18.bomb.defuser.utilities.ResourceManager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends ApplicationAdapter {
	
	public final static int WIDTH = 1280, HEIGHT = 720;
	public static ResourceManager res;
	
	private SpriteBatch batch;
	private StateManager states;
	private OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		res = new ResourceManager();
		states = new StateManager(this);
	}
	
	@Override
	public void render () {
		/*
		 * Update logic
		 */
		
		float delta = Gdx.graphics.getRawDeltaTime();
		states.update(delta);
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
			Gdx.app.exit();
		
		/*
		 * Render logic
		 */
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		states.render(batch);
		batch.end();
	}
	
}
