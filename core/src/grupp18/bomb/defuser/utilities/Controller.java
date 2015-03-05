package grupp18.bomb.defuser.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import grupp18.bomb.defuser.Entity.EntityMoveable;

public class Controller {

	private EntityMoveable entity;
	public Controller(EntityMoveable entity){
		this.entity = entity;
	}
	
	public void update(){
		if(Gdx.input.isKeyPressed(Keys.A))
			entity.moveLeft();
		if(Gdx.input.isKeyPressed(Keys.D))
			entity.moveRight();
		if(!Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D))
			entity.moveStop();
		if(Gdx.input.isKeyPressed(Keys.W) && entity.isOnGround())
			entity.applyVelocity(0, 800);
	}
}
