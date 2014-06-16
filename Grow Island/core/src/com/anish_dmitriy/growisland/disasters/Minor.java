package com.anish_dmitriy.growisland.disasters;

import java.util.*;

import com.anish_dmitriy.growisland.levels.*;
import com.anish_dmitriy.growisland.tiles.*;

public class Minor extends Disaster{
	public Minor(){
		super();
	}
	
	Random r = new Random();
	boolean side;
	public void Target(Level l){
		int random = r.nextInt(l.GameGrid.length -1 );
		if (side == true){
			for (int i = l.GameGrid.length - 1;i > 0;i--){
				l.GameGrid[i][random] = l.GameGrid[i - 1][random]; 
			}
			Tile t = l.Tiles[r.nextInt(5)];
			l.GameGrid[0][random] = t; 
		} else {
			for (int i = l.GameGrid.length - 1;i > 0;i--){
				l.GameGrid[random][i] = l.GameGrid[random][i - 1]; 
			}
			Tile t = l.Tiles[r.nextInt(5)];
			l.GameGrid[random][0] = t; 
		}
	}
}
