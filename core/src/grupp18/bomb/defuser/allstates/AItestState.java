package grupp18.bomb.defuser.allstates;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.Entity.Enemy;
import grupp18.bomb.defuser.World.World;
import grupp18.bomb.defuser.statesystem.State;
import grupp18.bomb.defuser.utilities.Controller;

public class AItestState extends State {
	
	private World world;
	private Controller control;
	private OrthographicCamera camera;
	private float lerp = 0.1f;
	
	public AItestState(MyGame game) {
		super(game);
		
		world = new World(-30);
		world.setBomb(null);
		world.addAI(new Enemy(new Vector2(0, 400), Color.NAVY, world, 30));
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
