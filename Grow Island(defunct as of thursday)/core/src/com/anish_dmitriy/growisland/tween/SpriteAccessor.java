package com.anish_dmitriy.growisland.tween;

import com.anish_dmitriy.growisland.Constants;
import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class SpriteAccessor implements TweenAccessor<Sprite> {

	@Override
	public int getValues(Sprite target, int tweenType, float[] values) {
		switch(tweenType) {
		case Constants.ALPHA:
			values[0] = target.getColor().a;
			return 1;
		default:
			assert false;
			return -1;
		}
	}

	@Override
	public void setValues(Sprite target, int tweenType, float[] values) {
		switch(tweenType) {
		case Constants.ALPHA:
			target.setColor(target.getColor().r,target.getColor().g,target.getColor().b,values[0]);
		}
	}


}
