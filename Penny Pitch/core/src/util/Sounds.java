package util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Array;

public class Sounds {
	
	public Sound explosion;
	public Sound bounce;
	public Sound score1;
	public Sound score2;
	public Sound score3;
	public Sound pickup;
	public Sound select;
	public Sound blip;
	public Music music;
	
	private Array<Sound> sounds;
	
	private boolean mute = false;
	
	private boolean fadeMusicIn;
	private boolean fadeMusicOut;
	
	public Sounds() {
		explosion = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.ogg"));
		bounce = Gdx.audio.newSound(Gdx.files.internal("sounds/bounce.ogg"));
		score1 = Gdx.audio.newSound(Gdx.files.internal("sounds/score1.ogg"));
		score2 = Gdx.audio.newSound(Gdx.files.internal("sounds/score2.ogg"));
		score3 = Gdx.audio.newSound(Gdx.files.internal("sounds/score3.ogg"));
		pickup = Gdx.audio.newSound(Gdx.files.internal("sounds/pickup.ogg"));
		select = Gdx.audio.newSound(Gdx.files.internal("sounds/select.ogg"));
		blip = Gdx.audio.newSound(Gdx.files.internal("sounds/blip.ogg"));
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.ogg"));
		
		sounds = new Array<Sound>();
		sounds.add(explosion);
		sounds.add(bounce);
		sounds.add(score1);
		sounds.add(score2);
		sounds.add(score3);
		sounds.add(pickup);
		sounds.add(select);
		sounds.add(blip);
	}
	
	public void update(float delta) {
		if(fadeMusicOut) {
			music.setVolume(music.getVolume() - (0.5F * delta));
			if(music.getVolume() < 0.2F) {
				music.setVolume(0.2F);
				fadeMusicOut = false;
			}
		} else if(fadeMusicIn) {
			music.setVolume(music.getVolume() + (0.5F * delta));
			if(music.getVolume() > 0.7F) {
				music.setVolume(0.7F);
				fadeMusicIn = false;
			}
		}
	}
	
	public void play(Sound sound) {
		if(!mute) sound.play();
	}
	
	public void play(Music music) {
		if(!mute) music.play();
	}
	
	public boolean isMute() {
		return mute;
	}
	
	public void setMute(boolean mute) {
		this.mute = mute;
		
		if(mute) {
			for(Sound s : sounds) s.stop();
			music.pause();
		} else music.play();
	}
	
	public void fadeMusicIn() {
		fadeMusicIn = true;
		fadeMusicOut = false;
	}
	
	public void fadeMusicOut() {
		fadeMusicOut = true;
		fadeMusicIn = false;
	}
	
	public void dispose() {
		for(Sound s : sounds) s.dispose();
		music.dispose();
	}
}
