package com.anish_dmitriy.growisland.building;

import com.anish_dmitriy.growisland.Constants;

public class Farm extends Building{
	public Farm(){
		level = 1;
		Constants.FOODs += 20;
		Constants.FARMS += 1;
	}
	
	public void getResource(){
		Constants.FOOD += 4;   
	}
	
	public void upGrade(){
		level += 1;
		Constants.FOODs += 30;
		Constants.FARMS += 1;
	}
	
	//don't let this be an option for the user.
		public void downGrade(){
			level -= level;
			Constants.FARMS -= 1;
		}
}
