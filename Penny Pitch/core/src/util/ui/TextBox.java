package util.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.anish_dmitriy.pennypitch.PennyPitch;
import util.Assets;
import util.Font;
import util.InputHandler;
import util.Font.TextBounds;
import util.Sounds;

public class TextBox {
	
	private final int PADDING = 6;
	
	NinePatch texture;
	InputHandler input;
	Font font;
	
	String message = ""; // Initialized here to avoid a NPE
	Menu menu;
	
	TextBounds messageBounds;
	float width, height;
	float x, y;
	
	public TextBox(InputHandler input, Sounds sound, Font font, String message, Menu menu) {
		this.font = font;
		this.input = input;
		this.menu = menu;
		setMessage(message);
		
		texture = Assets.textBox;
	}
	
	public TextBox(InputHandler input, Sounds sound, Font font, String message, Option... options) {
		this(input, sound, font, message, new Menu(input, sound, font, 0, 0, options));
	}
	
	public void update() {
		menu.update();
	}
	
	public void render(SpriteBatch batch) {
		texture.draw(batch, x, y, width, height);
		
		float messageY = y + height - PADDING - font.getFontHeight();
		font.setColor(Color.WHITE);
		font.write(message, x + (width / 2) - (messageBounds.width / 2), messageY - 9, batch);
		
		menu.render(batch);
	}
	
	private void calculateDimensions() {
		TextBounds bounds = font.getBounds(message);
		
		width = bounds.width + (PADDING * 2);
		if(menu.getWidth() > bounds.width) width += menu.getWidth();
		
		height = bounds.height + + menu.getHeight() + (PADDING * 2);
		
		x = (PennyPitch.GAME_WIDTH / 2) - (width / 2);
		y = (PennyPitch.GAME_HEIGHT / 2) - (height / 2);
		
		menu.setX(x + (width / 2) - (menu.getWidth() / 2));
		menu.setY(y + PADDING);
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		if(this.message.equals(message + "\n")) return;
		
		this.message = message.isEmpty() ? message : message + '\n';
		messageBounds = font.getBounds(message);
		
		calculateDimensions();
	}
}
