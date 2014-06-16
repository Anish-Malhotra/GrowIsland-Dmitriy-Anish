package com.anish_dmitriy.growisland.levels;

import com.anish_dmitriy.growisland.Constants;
import com.anish_dmitriy.growisland.tiles.*;

public class LevelOne extends Level{
	public LevelOne(){
			super(4);
	}
	
	public void Generate(){
		GameGrid[0][0] = new Forest();
		GameGrid[0][1] = new Forest();
		GameGrid[0][2] = new Forest();
		GameGrid[0][3] = new Forest();
		GameGrid[1][3] = new Forest();
		GameGrid[2][3] = new Forest();
		GameGrid[3][3] = new Forest();
		for (int row = 1;row < GameGrid.length - 1;row++){
			for (int col = 0;col < GameGrid[0].length - 2;col++){
				GameGrid[row][col] = new Plains();
			}
		}
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
