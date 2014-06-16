package com.anish_dmitriy.growisland.disasters;

import java.util.*;
import com.anish_dmitriy.growisland.levels.*;

public class Earthquake extends Disaster{
	public Earthquake(){
		super();
	}
	
	Random r = new Random();
	public void Target(Level l){
		int randomx = r.nextInt(l.GameGrid.length - 1);
		int randomy = r.nextInt(l.GameGrid.length - 1);
		//need to see exactly how this works.
	}
}
