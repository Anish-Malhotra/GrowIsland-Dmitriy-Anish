package com.anish_dmitriy.growisland.levels;

import com.anish_dmitriy.growisland.Constants;
import com.anish_dmitriy.growisland.tiles.*;

public class LevelOne extends Level{
	public LevelOne(){
			super();
	}
	
	public void Generate(){
		for (int row = 1;row < GameGrid.length - 1;row++){
			for (int col = 0;col < GameGrid[0].length - 1;col++){
				GameGrid[row][col] = new Transparent();
			}
		}
		GameGrid[7][0] = new Forest();
		GameGrid[7][1] = new Forest();
		GameGrid[7][2] = new Forest();
		GameGrid[7][3] = new Forest();
		GameGrid[8][3] = new Forest();
		GameGrid[9][3] = new Forest();
		GameGrid[10][3] = new Forest();
		GameGrid[8][0] = new Plains();
		GameGrid[8][1] = new Plains();
		GameGrid[8][2] = new Plains();
		GameGrid[9][0] = new Plains();
		GameGrid[9][1] = new Plains();
		GameGrid[9][2] = new Plains();
		GameGrid[10][0] = new Plains();
		GameGrid[10][1] = new Plains();
		GameGrid[10][2] = new Plains();
		
		
	}
	
	
	/*You have to add some objectives:
	 * Build city level 1
	 * build Farm level 1 && build Mill level 1
	 * Build city level 2
	 * At this point the level ends
	 */
	 
	
	//makes the player go back to level select or main menu
	public boolean Complete(){
		if (Constants.CITIES == 2){
			return true;
		} else {
			return false;
		}
	}
	
	
}
