package grupp18.bomb.defuser.AllStates;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Enemy.Enemy;
import grupp18.bomb.defuser.StateSystem.State;
import grupp18.bomb.defuser.Utilities.Controller;
import grupp18.bomb.defuser.World.World;

public class AItestState extends State {
	
	private World world;
	private Controller control;
	private OrthographicCamera camera;
	private float lerp = 0.1f;
	
	public AItestState(MyGame game) {
		super(game);
		
		world = new World(-30);
		world.setBomb(null);
		world.addEnemy(MyGame.res.dot, 300, 500, 50, 70, 30, Color.BLUE);
		world.addEnemy(MyGame.res.dot, 500, 250, 50, 70, 30, Color.PINK);
		
		control = new Controller(world.getHero());
		camera = new OrthographicCamera(MyGame.WIDTH, MyGame.HEIGHT);
	}

	@Override
	public void update(float delta) {
		control.update();
		world.update(delta);
		updateCamera();
	}
	
	public void updateCamera()
	{
		Vector3 position = camera.position;
		position.x += (world.getHero().getPos().x - position.x) * lerp;
		position.y += (world.getHero().getPos().y - position.y) * lerp;
		camera.update();
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		world.render(batch);
	}

}
