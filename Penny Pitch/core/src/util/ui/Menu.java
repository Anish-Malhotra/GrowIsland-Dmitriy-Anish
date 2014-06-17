package util.ui;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import util.Font;
import util.Font.TextBounds;
import util.InputHandler;
import util.Sounds;

public class Menu {
	
	InputHandler input;
	Sounds sound;
	Font font;
	
	private Option[] options;
	int option;
	boolean selected;
	
	float x, y, width, height;
	private final int CURSOR_WIDTH;
	
	boolean shouldRender;
	boolean blink;
	long startTime;
	long blinkTime = 500L;
	
	public Menu(InputHandler input, Sounds sound, Font font, float x, float y, Option... options) {
		this.options = options;
		
		this.input = input;
		this.sound = sound;
		this.font = font;
		
		this.x = x;
		this.y = y;
		
		CURSOR_WIDTH = (int) font.getBounds(">").width;
		
		calcDimensions();
	}
	
	public void update() {
		if(input.keyClicked(Keys.DOWN)) {
			setSelected(option + 1);
		} else if(input.keyClicked(Keys.UP)) {
			setSelected(option - 1);
		}
		
		if(input.keyClicked(Keys.ENTER)) select();
		
		for(int i = 0; i < options.length; i++) {
			if(options[i].bounds.contains(input.getX(), input.getY())) {
				setSelected(i);
				if(input.isClicked()) select();
			}
		}
		
		if(blink) {
			long delta = System.currentTimeMillis() - startTime;
			shouldRender = delta % 200 > 100;
			
			if(delta >= blinkTime) {
				shouldRender = true;
				blink = false;
				selected = false;
				options[option].execute();
			}
		}
	}

	public void render(SpriteBatch batch) {
		float fWidth, y;
		String optionMessage;
		
		for(int i = 0; i < options.length; i++) {
			optionMessage = options[i].option;
			y = options[i].getY();
			
			if(i == option) {
				font.setColor(Color.WHITE);
				optionMessage = ">" + optionMessage + "<";
			} else {
				font.setColor(new Color(0.7F, 0.7F, 0.7F, 1));
			}
			
			fWidth = font.getWidth(optionMessage);
			
			if(blink && i == option) {
				if(shouldRender) font.write(optionMessage, this.x + (width / 2) - (fWidth / 2), y, batch);
			} else font.write(optionMessage, this.x + (width / 2) - (fWidth / 2), y, batch);
		}
	}
	
	private void calcDimensions() {
		float fWidth = 0;
		
		for(int i = 0; i < options.length; i++) {
			fWidth = font.getWidth(options[i].option);
			
			if(fWidth > width) width = fWidth;
			
			height += (font.getFontHeight() + font.getLineSpacing());
		}
		
		height -= font.getLineSpacing();
		width += (CURSOR_WIDTH * 2);
		
		setBounds();
	}
	
	private void setBounds() {
		float x, y = this.y + (options.length * font.getLineHeight());
		
		TextBounds bounds;
		String optionMessage;
		
		for(int i = 0; i < options.length; i++) {
			optionMessage = options[i].option;
			
			if(i == option) optionMessage = ">" + optionMessage + "<";
			
			bounds = font.getBounds(optionMessage);
			
			x = this.x + (width / 2) - (bounds.width / 2);
			y -= font.getLineHeight();
			
			options[i].setBounds(x, y, bounds.width, bounds.height);
		}
	}
	
	private void select() {
		if(!selected) {
			startTime = System.currentTimeMillis();
			sound.play(sound.select);
			blink = true;
			selected = true;
		}
	}
	
	private void setSelected(int option) {
		if(!selected) {
			this.option = option;
			if(option > options.length - 1) this.option = options.length - 1;
			if(option < 0) this.option = 0;
		}
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setX(float x) {
		this.x = x;
		setBounds();
	}
	
	public void setY(float y) {
		this.y = y;
		setBounds();
	}
}
