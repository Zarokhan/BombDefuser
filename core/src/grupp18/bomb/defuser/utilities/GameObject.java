package grupp18.bomb.defuser.utilities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
	
	private Texture tex;
	protected Vector2 pos, origin;
	protected float width, height, scale, scaleX, scaleY, rotation;
	protected Rectangle source, hitbox;
	
	public GameObject(Texture tex){
		this.tex = tex;
		width = tex.getWidth();
		height = tex.getHeight();
		source = new Rectangle(0, 0, width, height);
		hitbox = new Rectangle(0, 0, width, height);
		pos = Vector2.Zero;
		origin = new Vector2(width/2, height/2);
		rotation = 0f;
		scale = 1f;
		scaleX = 1f;
		scaleY = 1f;
	}
	
	public Rectangle getSource(){
		return source;
	}
	
	public Rectangle getHitbox(){
		return hitbox;
	}
	
	public Vector2 getCenterPosition(){
		Vector2 p = new Vector2(pos.x + origin.x, pos.y + origin.y);
		return p;
	}
	
	public void render(SpriteBatch batch){
		batch.draw(tex, pos.x, pos.y, origin.x, origin.y, width, height, scale, scale, rotation, (int)source.x, (int)source.y, (int)source.width, (int)source.height, false, false);
	}
	
	public void render2(SpriteBatch batch){
		batch.draw(tex, pos.x, pos.y, origin.x, origin.y, width, height, scaleX, scaleY, rotation, (int)source.x, (int)source.y, (int)source.width, (int)source.height, false, false);
	}
	
	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public Vector2 getOrigin() {
		return origin;
	}

	public void setOrigin(Vector2 origin) {
		this.origin = origin;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public void setSource(Rectangle source) {
		this.source = source;
	}

	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}

	public float getScaleX() {
		return scaleX;
	}

	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}

	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}
	
}
