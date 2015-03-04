package grupp18.bomb.defuser.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ResourceManager {
	
	public Texture dot, logo, btnPlay;
    public BitmapFont font;
	
	public ResourceManager(){
		logo = new Texture(Gdx.files.internal("logo.png"));
		btnPlay = new Texture(Gdx.files.internal("play.png"));
		
		Pixmap p = new Pixmap(1, 1, Format.RGB565);
		p.setColor(Color.WHITE);
		p.fill();
		dot = new Texture(p);
		
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
	}
}
