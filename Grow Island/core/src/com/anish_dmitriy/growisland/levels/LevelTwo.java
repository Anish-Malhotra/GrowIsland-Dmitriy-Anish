package com.anish_dmitriy.growisland.levels;

import com.anish_dmitriy.growisland.tiles.*;
import com.anish_dmitriy.growisland.building.*;

public class LevelTwo extends Level {
	public LevelTwo(){
		super(5);
	}
	
	//this is me being lazy
	public void Generate(){
		GameGrid[0][0] = new Forest();
		GameGrid[0][1] = new Forest();
		GameGrid[0][2] = new Forest();
		GameGrid[4][4] = new Forest();
		GameGrid[3][4] = new Forest();
		GameGrid[2][4] = new Forest();
		Mill m = new Mill();
		GameGrid[2][4].Build(m);
		
		GameGrid[0][3] = new Mountain();
		GameGrid[0][4] = new Mountain();
		GameGrid[1][3] = new Mountain();
		GameGrid[1][4] = new Mountain();
	
		GameGrid[3][0] = new Water();
		GameGrid[4][0] = new Water();
		GameGrid[3][1] = new Water();
		GameGrid[4][1] = new Water();
		
		GameGrid[2][0] = new Desert();
		GameGrid[4][2] = new Desert();
		
		for (int row = 1;row < GameGrid.length - 1;row++){
			for (int col = 0;col < GameGrid[0].length - 1;col++){
				GameGrid[row][col] = new Plains();
			}
		}
		Farm f = new Farm();
		GameGrid[3][3].Build(f);
		
		City c = new City();
		c.upGrade();
		GameGrid[2][3].Build(c);
	}
	
	/*Objective, survive the Wildfire
	 * all from Level 1
	 * build Temple, and acquire magic
	 * acquire Identify and Countdown
	 * Witness Wildfire. 
	*/
	
	public boolean Complete(){
		// return true after Wildfire and Identify and Countdown have been acquired.
		return true;
	}
}
