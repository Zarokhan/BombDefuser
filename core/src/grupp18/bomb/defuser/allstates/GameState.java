package grupp18.bomb.defuser.allstates;

import grupp18.bomb.defuser.MyGame;
import grupp18.bomb.defuser.World.World;
import grupp18.bomb.defuser.statesystem.State;
import grupp18.bomb.defuser.utilities.Controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameState extends State {
	
	private World world;
	private Controller control;
	private OrthographicCamera camera, cameraHud;
	private float lerp = 0.1f;
	
	public GameState(MyGame game) {
		super(game);
		world = new World(-30);
		control = new Controller(world.getHero());
		camera = new OrthographicCamera(MyGame.WIDTH, MyGame.HEIGHT);
		cameraHud = new OrthographicCamera(MyGame.WIDTH, MyGame.HEIGHT);
		cameraHud.position.x += MyGame.WIDTH/2;
		cameraHud.position.y += MyGame.HEIGHT/2;
		cameraHud.update();
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
		MyGame.res.font.draw(batch, "Use WASD to move around", 10, MyGame.HEIGHT - 500);
		batch.setProjectionMatrix(cameraHud.combined);
	}

}
