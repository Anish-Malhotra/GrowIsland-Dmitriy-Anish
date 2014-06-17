package com.anish_dmitriy.growisland.building;

public class Building {
	int resource;
	int level;
	public Building(){
		resource = 0;
		level = 0;
	}
	
	public void upGrade(){
		level += level;
	}
	
	//don't let this be an option for the user.
	public void downGrade(){
		level -= level;
	}
	
}
