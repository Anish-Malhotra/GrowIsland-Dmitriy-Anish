package com.anish_dmitriy.growisland.disasters;

import java.util.*;

import com.anish_dmitriy.growisland.levels.*;
import com.anish_dmitriy.growisland.tiles.Tile;

public class Earthquake extends Disaster{
	public Earthquake(){
		super();
	}
	
	Random r = new Random();
	public void Target(Level l){
		int randomx = r.nextInt(l.GameGrid.length - 1);
		int randomy = r.nextInt(l.GameGrid.length - 1);
		for(int row = 1;row < randomx;row++){
			l.GameGrid[row][randomy] = l.GameGrid[row - 1][randomy];
		}
		for (int row = l.GameGrid.length-1;row > randomx;row--){
			l.GameGrid[row][randomy] = l.GameGrid[row + 1][randomy];
		}
		for(int col = 1;col < randomy ;col++){
			l.GameGrid[randomx][col] = l.GameGrid[randomx][col - 1];
		}
		for (int col = l.GameGrid.length-1;col > randomy;col--){
			l.GameGrid[randomx][col] = l.GameGrid[randomx][col + 1];
		}
		Tile t = l.Tiles[r.nextInt(5)];
		l.GameGrid[randomx][randomy] = t;
	}
	
}
