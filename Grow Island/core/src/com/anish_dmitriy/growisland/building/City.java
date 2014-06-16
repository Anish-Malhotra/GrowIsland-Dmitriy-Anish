package com.anish_dmitriy.growisland.building;

import com.anish_dmitriy.growisland.Constants;

public class City extends Building{
	
	public City(){
		level = 1;
		Constants.POPULATIONs = 3;
		Constants.CITIES += 1;
	}
	
	public void upGrade(){
		level += 1;
		Constants.CITIES += 1;
		if (level == 1){
			Constants.POPULATIONs = 3;
		}
		if (level == 2){
			Constants.POPULATIONs = 9;
		}
		if (level == 3){
			Constants.POPULATIONs = 20;
		}
		if (level == 4){
			Constants.POPULATIONs = 30;
		}
		
	}
	
	//don't let this be an option for the user.
	public void downGrade(){
		level = level - 2;	
		Constants.CITIES -= 2;
		upGrade();
	}
	
}
