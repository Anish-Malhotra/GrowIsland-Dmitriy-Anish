package com.anish_dmitriy.growisland.disasters;


import java.util.*;

import com.anish_dmitriy.growisland.levels.*;
import com.anish_dmitriy.growisland.tiles.*;

public class Disaster {
	
	Disaster[] all;
	Tile result;
	
	public Disaster(){
		all = new Disaster[6];
		all[0] = new Earthquake();
		all[1] = new Flood();
		all[2] = new Major();
		all[3] = new Minor();
		all[4] = new Nature();
		all[5] = new Wildfire();
		result = null;
		
	}
	
	Random r = new Random();
	public static PriorityQueue<Disaster> queue = new PriorityQueue<Disaster>();
	
	public void Generate(){
		queue.add(all[r.nextInt(all.length - 1)]);	
	}
	
	//Skill : Identify
	public Disaster Identify(){
		return queue.peek();
	}
	
	//Skill: Cancel
	public void Cancel(){
		queue.poll();
	}
	
	
	public void Target(Level l){
		for (int i = 0;i < l.GameGrid.length - 1;i++){
			int randomx = r.nextInt(l.GameGrid.length);
			int randomy = r.nextInt(l.GameGrid.length);
			if (l.GameGrid[randomx][randomy].structure == null){
				l.GameGrid[randomx][randomy] = result;
			} else {
				l.GameGrid[randomx][randomy].structure.downGrade();
			}
		}
		
	}
	
	
	
	
	
}
