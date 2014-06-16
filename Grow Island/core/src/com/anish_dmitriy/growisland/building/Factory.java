package com.anish_dmitriy.growisland.building;

import com.anish_dmitriy.growisland.Constants;

public class Factory extends Building{
	public Factory(){
		level = 1;
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
	
	//don't let this be an option for the user.
		public void downGrade(){
			level -= level;
			Constants.CITIES -= 1;
		}
}
