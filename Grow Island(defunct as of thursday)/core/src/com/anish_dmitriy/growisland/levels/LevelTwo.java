package com.anish_dmitriy.growisland.levels;

import com.anish_dmitriy.growisland.disasters.*;
import com.anish_dmitriy.growisland.tiles.*;

public class LevelTwo extends Level {
	public LevelTwo(){
		super(5);
	}
	
	//this is me being lazy
	public void Generate(){
		for (int row = 1;row < GameGrid.length - 1;row++){
			for (int col = 0;col < GameGrid[0].length - 1;col++){
				GameGrid[row][col] = new Transparent();
			}
		}
		GameGrid[0][0] = new Forest();
		GameGrid[0][1] = new Forest();
		GameGrid[0][2] = new Forest();
		GameGrid[4][4] = new Forest();
		GameGrid[3][4] = new Forest();
		GameGrid[2][4] = new Forest();
		Mill m = new Mill();
		GameGrid[2][4].Build(m);
		
		GameGrid[6][3] = new Mountain();
		GameGrid[6][4] = new Mountain();
		GameGrid[7][3] = new Mountain();
		GameGrid[7][4] = new Mountain();
	
		GameGrid[9][0] = new Water();
		GameGrid[10][0] = new Water();
		GameGrid[9][1] = new Water();
		GameGrid[10][1] = new Water();
		
		GameGrid[8][0] = new Desert();
		GameGrid[10][2] = new Desert();
		
		GameGrid[7][0] = new Plains();
		GameGrid[7][1] = new Plains();
		GameGrid[7][2] = new Plains();
		GameGrid[8][1] = new Plains();
		GameGrid[8][2] = new Plains();
		GameGrid[8][3] = new Plains();
		GameGrid[9][2] = new Plains();
		GameGrid[9][3] = new Plains();
		GameGrid[10][3] = new Plains();
		Farm f = new Farm();
		GameGrid[8][3].Build(f);
		
		City c = new City();
		c.upGrade();
		GameGrid[7][3].Build(c);
		
		
	}
	
	/*Objective, survive the Wildfire
	 * all from Level 1
	 * build Temple, and acquire magic
	 * acquire Identify and Countdown
	 * Witness Wildfire. 
	*/
	
	public boolean Complete(){
		Wildfire w = new Wildfire();
		w.Target2(this);
		// return true after Wildfire and Identify and Countdown have been acquired.
		return true;
	}
}
