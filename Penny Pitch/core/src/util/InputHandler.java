package util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {
		
		private int w, h;
		
		Key[] keys = new Key[256];
		Mouse mouse;
		
		public InputHandler(int width, int height) {
			Gdx.input.setInputProcessor(this);
			
			mouse = new Mouse();
			
			w = width;
			h = height;
			
			for(int i = 0; i < keys.length; i++) {
				keys[i] = new Key();
			}
		}
		
		public float getX() {
			return mouse.getX();
		}
		
		public float getY() {
			return mouse.getY();
		}
		
		public boolean isMouseDown() {
			return mouse.down;
		}
		
		public boolean isClicked() {
			return mouse.clicked;
		}
		
		public boolean isKeyDown(int key) {
			return keys[key].down;
		}
		
		public boolean keyClicked(int key) {
			return keys[key].clicked;
		}
		
		public void update() {
			mouse.clicked = false;
			
			for(int i = 0; i < keys.length; i++) {
				keys[i].clicked = false;
			}
		}
		
		@Override
		public boolean keyDown(int key) {
			keys[key].down = true;
			
			return false;
		}

		@Override
		public boolean keyUp(int key) {
			keys[key].down = false;
			keys[key].clicked = true;
			
			return false;
		}

		@Override
		public boolean keyTyped(char character) {
			return true;
		}

		@Override
		public boolean touchDown(int x, int y, int pointer, int button) {
			mouse.down = true;
			mouse.x = x;
			mouse.y = y;
			mouse.timePressed = System.currentTimeMillis();
			
			return false;
		}

		@Override
		public boolean touchUp(int x, int y, int pointer, int button) {
			mouse.down = false;
			mouse.clicked = true;
			mouse.x = x;
			mouse.y = y;
			
			return false;
		}

		@Override
		public boolean touchDragged(int x, int y, int pointer) {
			mouse.down = true;
			mouse.x = x;
			mouse.y = y;
			
			return true;
		}

		@Override
		public boolean mouseMoved(int x, int y) {
			mouse.x = x;
			mouse.y = y;
			
			return true;
		}

		@Override
		public boolean scrolled(int amount) {
			return false;
		}
		
		public class Mouse {
			
			public float x, y;
			public int button;
			public boolean down, clicked;
			
			long timePressed;
			
			public float getX() {
				return (x / Gdx.graphics.getWidth()) * w;
			}
			
			public float getY() {
				return ((Gdx.graphics.getHeight() - y) / Gdx.graphics.getHeight()) * h;
			}
		}
		
		public class Key {
			boolean down, clicked;
		}
	}


