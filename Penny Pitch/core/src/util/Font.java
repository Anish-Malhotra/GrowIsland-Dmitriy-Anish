package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Font {
	
	String letters = "ABCDEFGHIJKLMNOP" + //
					 "QRSTUVWXYZ012345" + //
					 "6789!?.,<>/\\%#&$" + //
					 "_-+=:;[]()\"\'~*|^";
	
	Texture fontTexture;
	Sprite[] chars = new Sprite[letters.length()];
	
	float fontHeight = 7;
	float lineSpacing = 2;
	float lineHeight = fontHeight + lineSpacing;
	float letterSpacing = 1;
	float spaceWidth = 5;
	
	float color;
	
	public Font() {
		fontTexture = new Texture(Gdx.files.internal("fonts/double-font.png"));
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(Gdx.files.internal("fonts/double-font.ffo").read()));
			
			int x = 0, y = 0;
			
			String line;
			int i = 0;
			while((line = reader.readLine()) != null) {
 				if(i % 16 == 0 && i != 0) {
					y += 8;
					x = 0;
				}
 				
				chars[i] = new Sprite(new TextureRegion(fontTexture, x, y, Integer.parseInt(line.charAt(0) + ""), 8));
				x += 8;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String message, float x, float y, SpriteBatch batch) {
		message = message.toUpperCase();
		char currChar;
		int index;
		float xi = x;
		
		y += getHeight(message) - fontHeight;
		
		for(int i = 0; i < message.length(); i++) {
			currChar = message.charAt(i);
			
			if(currChar == '\n') {
				y -= lineHeight;
				x = xi;
				continue;
			} else if(currChar == ' ') {
				x += spaceWidth;
				continue;
			}
			
			index = letters.indexOf(currChar);
			
			chars[index].setPosition(x, y);
			chars[index].draw(batch);
			
			x += chars[index].getRegionWidth() + letterSpacing;
		}
	}
	
	public float getWidth(String message) {
		message = message.toUpperCase();
		
		if(message.isEmpty()) return 0;
		
		float width = 0, currWidth = 0;
		char currChar;
		
		for(int i = 0; i < message.length(); i++) {
			currChar = message.charAt(i);
			
			if(currChar == '\n') width = 0;
			else if(currChar == ' ') width += spaceWidth;
			else width += chars[letters.indexOf(currChar)].getRegionWidth() + letterSpacing;
			
			if(width > currWidth) currWidth = width;
		}
		
		if(currWidth > width) width = currWidth;
		
		return width - 1;
	}
	
	public float getHeight(String message) {
		message = message.toUpperCase();
		
		float height = fontHeight;
		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) == '\n') height += lineHeight;
		}
		
		return height;
	}
	
	public TextBounds getBounds(String message) {
		return new TextBounds(getWidth(message), getHeight(message));
		/*message = message.toUpperCase();
		if(message.isEmpty()) return new TextBounds(0, 0);
		
		float width = 0, currWidth = 0;
		float height = fontHeight;
		char currChar;
		
		for(int i = 0; i < message.length(); i++) {
			currChar = message.charAt(i);
			
			if(currChar == '\n') {
				height += lineHeight;
				
				width = 0;
			} else if(currChar == ' ') {
				width += spaceWidth;
			} else {
				width += chars[letters.indexOf(currChar)].getRegionWidth() + letterSpacing;
			}
			
			if(width > currWidth) currWidth = width;
		}
		
		if(currWidth > width) width = currWidth;
		
		width -= 1;
		
		return new TextBounds(width, height);*/
	}
	
	public float getFontHeight() {
		return fontHeight;
	}
	
	public float getLineSpacing() {
		return lineSpacing;
	}
	
	public float getLetterSpacing() {
		return letterSpacing;
	}
	
	public float getSpaceWidth() {
		return spaceWidth;
	}
	
	public float getLineHeight() {
		return lineHeight;
	}
	
	public void setLineSpacing(float lineSpacing) {
		this.lineSpacing = lineSpacing;
	}
	
	public void setLetterSpacing(float letterSpacing) {
		this.letterSpacing = letterSpacing;
	}
	
	public void setSpaceWidth(float spaceWidth) {
		this.spaceWidth = spaceWidth;
	}
	
	public void setColor(float r, float g, float b, float a) {
		for(int i = 0; i < chars.length; i++) {
			chars[i].setColor(r, g, b, a);
		}
	}
	
	public void setColor(Color color) {
		for(int i = 0; i < chars.length; i++) {
			chars[i].setColor(color);
		}
	}
	
	public void setScale(float scale) {
		for(int i = 0; i < chars.length; i++) {
			chars[i].setScale(scale);
		}
	}
	
	public void dispose() {
		fontTexture.dispose();
	}
	
	public class TextBounds {
		public float width, height;
		
		public TextBounds(float width, float height) {
			this.width = width;
			this.height = height;
		}
	}
}
