package com.anish_dmitriy.growisland.tiles;

import com.anish_dmitriy.growisland.Constants;

public class Factory extends Plains implements Building{
	public Factory(){
		super();
		Constants.PRODUCTIONs += 30; 
		Constants.FACTORIES += 1;
	}
	
	public void getResource(){
		Constants.PRODUCTION += 4;   
	}
	
	public void upGrade(){
		level += 1;
		Constants.PRODUCTIONs += 30;
		Constants.FACTORIES += 1;
	}
	
	//need to look this up
	public void Rampart(){
		
	}
	
	//don't let this be an option for the user.
	public void downGrade(){
		level -= level;
		Constants.PRODUCTION -= 30;
		Constants.FACTORIES -= 1;
	}
}
