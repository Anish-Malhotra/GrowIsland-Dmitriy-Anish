package com.anish_dmitriy.growisland.tiles;

import com.anish_dmitriy.growisland.Constants;

public class School extends Plains implements Building{
	public School(){
		super();
		Constants.KNOWLEDGEs += 30;
		Constants.SCHOOLS += 1;
	}
	
	public void getResource(){
		Constants.KNOWLEDGE+= 4;   
	}
	
	public void upGrade(){
		level += 1;
		Constants.KNOWLEDGEs += 30;
		Constants.SCHOOLS += 1;
	}
	
	//don't let this be an option for the user.
	public void downGrade(){
		level -= level;
		Constants.SCHOOLS -= 1;
		Constants.KNOWLEDGE -= 30;
	}
}
