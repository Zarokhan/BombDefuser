package grupp18.bomb.defuser.PowerUp;

import grupp18.bomb.defuser.Bomb.Bomb;
import grupp18.bomb.defuser.World.World;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PowerUpManger {

	private World world;
	private Bomb bomb;
	private List<PowerUp> powerUps;
	
	public PowerUpManger(World _world, Bomb _bomb){
		this.world = _world;
		this.bomb = _bomb;
		
		powerUps = new ArrayList<PowerUp>();
		powerUps.add(new PowerUp(bomb, world, 100, 440, 500, EPowerUp.powerup1, 5));
		powerUps.add(new PowerUp(bomb, world, 450, 300, 300, EPowerUp.powerup2, 5));
	}
	
	public void update(float delta){
		for(PowerUp p: powerUps)
			p.update(delta);
		
		for(PowerUp p: powerUps){
			if(p.getTimer() < 0){
				powerUps.remove(p);
				break;
			}
		}
		
	}
	public void render(SpriteBatch batch){
		for(PowerUp p: powerUps)
			p.render(batch);
	}
}
