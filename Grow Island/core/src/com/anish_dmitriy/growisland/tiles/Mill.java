package com.anish_dmitriy.growisland.tiles;

import com.anish_dmitriy.growisland.Constants;

public class Mill extends Forest implements Building{
	public Mill(){
		super();
		Constants.WOODs += 20;
		Constants.MILLS += 1;
	}
	
	public void getResource(){
		Constants.WOOD += 4;   
	}
	
	public void upGrade(){
		level += 1;
		Constants.WOODs += 20;
		Constants.MILLS += 1;
	}
	
	//don't let this be an option for the user.
	public void downGrade(){
		level -= level;
		Constants.MILLS -= 1;
		Constants.WOOD -= 20;
	}
}
