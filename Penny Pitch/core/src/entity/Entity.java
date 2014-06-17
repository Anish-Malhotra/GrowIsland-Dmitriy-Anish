package entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	
	public Vector2 pos;
	public Vector2 velocity;
	public Vector2 acceleration;
	
	public Rectangle bounds;
	
	public Entity(float x, float y, float width, float height) {
		pos = new Vector2(x, y);
		bounds = new Rectangle(x, y, width, height);
		
		velocity = new Vector2();
		acceleration = new Vector2();
	}
	
	public abstract void update(float delta);
	public abstract void render(SpriteBatch batch);
	
	public void updateBounds() {
		bounds.x = pos.x;
		bounds.y = pos.y;
	}
	
	public float getX() {
		return pos.x;
	}
	
	public float getY() {
		return pos.y;
	}
	
	public Vector2 getPosition() {
		return pos;
	}
	
	public float getVelX() {
		return velocity.x;
	}
	
	public float getVelY() {
		return velocity.y;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}
	
	public float getAccelX() {
		return acceleration.x;
	}
	
	public float getAccelY() {
		return acceleration.y;
	}
	
	public Vector2 getAcceleration() {
		return acceleration;
	}
	
	public float getWidth() {
		return bounds.width;
	}
	
	public float getHeight() {
		return bounds.height;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public boolean intersects(Entity e) {
		if(bounds.overlaps(e.getBounds()) || bounds.contains(e.getBounds())) return true;
		else return false;
	}
	
	public void setX(float x) {
		pos.x = x;
	}
	
	public void setY(float y) {
		pos.y = y;
	}
	
	public void setPosition(float x, float y) {
		pos.x = x;
		pos.y = y;
	}
	
	public void setPosition(Vector2 position) {
		pos.set(position);
	}
	
	public void setVelX(float velX) {
		velocity.x = velX;
	}
	
	public void setVelY(float velY) {
		velocity.y = velY;
	}
	
	public void setVelocity(float velX, float velY) {
		velocity.x = velX;
		velocity.y = velY;
	}
	
	public void setVelocity(Vector2 velocity) {
		this.velocity.set(velocity);
	}
	
	public void setAccelX(float accelX) {
		acceleration.x = accelX;
	}
	
	public void setAccelY(float accelY) {
		acceleration.y = accelY;
	}
	
	public void setAcceleration(float accelX, float accelY) {
		acceleration.x = accelX;
		acceleration.y = accelY;
	}
	
	public void setAcceleration(Vector2 acceleration) {
		this.acceleration.set(acceleration);
	}
}
