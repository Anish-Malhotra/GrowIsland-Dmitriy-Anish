package com.anish_dmitriy.growisland.disasters;

import java.util.*;

import com.anish_dmitriy.growisland.levels.Level;
import com.anish_dmitriy.growisland.tiles.Tile;

public class Major extends Disaster{
	public Major(){
		super();
	}
	
	//need to draw this to determine whether or not it works
	Random r = new Random();
	boolean side;
	public void Target(Level l){
		int length = l.GameGrid.length;
		if (side == true){
			for (int i = 0;i < l.GameGrid.length-2;i++){
				for (int j = 0;j < length - 1;j++){
					l.GameGrid[i][j] = l.GameGrid[i+1][j];
				}
				Tile t = l.Tiles[r.nextInt(5)];
				l.GameGrid[i][length - 1] = t;
			}
			side = false;
		} else {
			for (int i = 0;i < l.GameGrid.length-1;i++){
				for (int j = 0;j < length - 2;j++){
					l.GameGrid[j][i] = l.GameGrid[j+1][i];
				}
				Tile t = l.Tiles[r.nextInt(5)];
				l.GameGrid[length - 1][i] = t;
			}
			side = true;
		}
	}
}
