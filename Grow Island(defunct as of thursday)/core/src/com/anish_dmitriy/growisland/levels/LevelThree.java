package com.anish_dmitriy.growisland.levels;

import com.anish_dmitriy.growisland.Constants;
import com.anish_dmitriy.growisland.tiles.*;

public class LevelThree extends Level{
	public LevelThree(){
		for (int row = 1;row < GameGrid.length - 1;row++){
			for (int col = 0;col < GameGrid[0].length - 2;col++){
				GameGrid[row][col] = new Transparent();
			}
		}
		GameGrid[10][0] = new Water();
		GameGrid[10][1] = new Water();
		GameGrid[10][2] = new Water();
		GameGrid[10][3] = new Water();
		GameGrid[10][4] = new Water();
		GameGrid[10][5] = new Water();
		GameGrid[9][1] = new Water();
		GameGrid[9][2] = new Water();
		GameGrid[8][5] = new Water();
		
		GameGrid[9][0] = new Desert();
		GameGrid[8][1] = new Desert();
		GameGrid[9][3] = new Desert();
		GameGrid[9][4] = new Desert();
		
		GameGrid[5][5] = new Mountain();
		GameGrid[5][4] = new Mountain();
		GameGrid[6][5] = new Mountain();
		GameGrid[6][4] = new Mountain();
		
		GameGrid[5][0] = new Forest();
		GameGrid[5][1] = new Forest();
		GameGrid[5][2] = new Forest();
		GameGrid[5][3] = new Forest();
		GameGrid[7][5] = new Forest();
		GameGrid[9][5] = new Forest();
		
		GameGrid[8][0] = new Plains();
		GameGrid[8][2] = new Plains();
		GameGrid[8][3] = new Plains();
		GameGrid[8][4] = new Plains();
		GameGrid[7][0] = new Plains();
		GameGrid[7][1] = new Plains();
		GameGrid[7][2] = new Plains();
		GameGrid[7][3] = new Plains();
		GameGrid[7][4] = new Plains();
		GameGrid[6][0] = new Plains();
		GameGrid[6][1] = new Plains();
		GameGrid[6][2] = new Plains();
		GameGrid[6][3] = new Plains();
	}
	
	/*Make it so they play the game.
	The objective is to turn a desert into a plains via Culturing.
	Run a infinite loop until Complete returns true
	*/
	public boolean Complete(){
		if (Constants.CULTURED == true)
			return true;
		return false;
	}
}
