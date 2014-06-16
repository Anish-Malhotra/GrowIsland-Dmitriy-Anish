package com.anish_dmitriy.growisland.building;

import com.anish_dmitriy.growisland.Constants;

public class Temple extends Building{
	
	public Temple(){
		level = 1;
		Constants.MAGICs += 30;
		Constants.TEMPLES += 1;
	}
	
	public void getResource(){
		Constants.MAGIC += 4; 
	}
	
	public void upGrade(){
		level += 1;
		Constants.MAGICs += 30;
		Constants.TEMPLES += 1;
	}
	
	//don't let this be an option for the user.
	public void downGrade(){
		level -= level;
		Constants.CITIES -= 1;
	}
}
