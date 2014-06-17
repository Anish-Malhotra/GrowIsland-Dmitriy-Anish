package com.anish_dmitriy.growisland.levels;

import com.anish_dmitriy.growisland.tiles.*;

import java.util.*;

public class Level {
		
	
	public Tile[] Tiles;
	public Tile[][] GameGrid;
	
	
	public Level(){
		Tiles = new Tile[6];
		Tiles[0] = new Plains();
		Tiles[1] = new Forest();
		Tiles[2] = new Mountain();
		Tiles[3] = new Water();
		Tiles[4] = new Desert();
		Tiles[5] = new Plains();
		
		GameGrid = new Tile[10][10];
	}
		
	public Level(int i){
		Tiles = new Tile[6];
		Tiles[0] = new Plains();
		Tiles[1] = new Forest();
		Tiles[2] = new Mountain();
		Tiles[3] = new Water();
		Tiles[4] = new Desert();
		Tiles[5] = new Plains();
		
		GameGrid = new Tile[i][i];
	}
	
	Random r = new Random();
	public void Generate(){
		for (int row = 0;row < GameGrid.length - 1;row++){
			for (int col = 0;col < GameGrid[0].length - 1;col++){
				GameGrid[row][col] = Tiles[r.nextInt(Tiles.length - 1)];
			}
		}
	}
}
