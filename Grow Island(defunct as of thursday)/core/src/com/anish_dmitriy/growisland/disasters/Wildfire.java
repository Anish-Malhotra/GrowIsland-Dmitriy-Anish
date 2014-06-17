package com.anish_dmitriy.growisland.disasters;

import com.anish_dmitriy.growisland.levels.Level;
import com.anish_dmitriy.growisland.tiles.*;

//This class should be called Drought, since i don't know how to do I'll jsut leave it
public class Wildfire extends Disaster{
	
	public Wildfire(){
		result = new Desert();
	}
	
	//so much copy and pasta.
	public void Target2(Level l){
		
			if (l.GameGrid[1][0].structure == null){
				l.GameGrid[1][0] = result;
			} else {
				l.GameGrid[1][0].structure.downGrade();
			}
			
			if (l.GameGrid[2][1].structure == null){
				l.GameGrid[2][1] = result;
			} else {
				l.GameGrid[2][1].structure.downGrade();
			}
			
			if (l.GameGrid[3][2].structure == null){
				l.GameGrid[3][2] = result;
			} else {
				l.GameGrid[3][2].structure.downGrade();
			}
			
			if (l.GameGrid[4][3].structure == null){
				l.GameGrid[4][3] = result;
			} else {
				l.GameGrid[4][3].structure.downGrade();
			}		
			
		
	}
}
