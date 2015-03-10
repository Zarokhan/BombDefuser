package grupp18.bomb.defuser.utilities;

import grupp18.bomb.defuser.MyGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Button extends GameObject {
	
	
	private boolean hover, clicked;
	
	// Mouse coordinates
	private float x, y;
	
	public Button(Texture tex) {
		super(tex);
		hitbox = new Rectangle();
	}
	
	@Override
	public void setPos(Vector2 pos){
		this.pos = pos;
		hitbox = new Rectangle(pos.x, pos.y, width, height);
	}
	
	// If this update loop returns true the button has been pressed.
	public boolean update(){
		x = Gdx.input.getX() / (float)(Gdx.graphics.getWidth() / 1280f);
		y = MyGame.HEIGHT - Gdx.input.getY() / (float)(Gdx.graphics.getHeight() / 720f);
		
		// Hover effect
		if(this.hitbox.contains(x,  y))
			hover = true;
		else
			hover = false;
		
		// Is clicked?
		if(Gdx.input.isTouched()){
			if(hover && !clicked){
				MyGame.res.select.play();
				clicked = true;
				return true;
			}
		}else{
			if(clicked)
				clicked = false;
		}
		
		
		
		return false;
	}
}
