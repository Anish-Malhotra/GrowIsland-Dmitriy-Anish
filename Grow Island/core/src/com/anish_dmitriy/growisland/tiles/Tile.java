package com.anish_dmitriy.growisland.tiles;

import com.anish_dmitriy.growisland.Constants;



public class Tile{
    
	//tied image
	
	int level;
    String type;
    public Building structure;

    public Tile(){
    	level = 0;
    	type = null;
    	structure = null;
    }
    
    public Tile(String s){
    	level = 0;
    	type = s; 
    }
    
    //Skill: Reforest, turns plains into forests.
    public void Reforest(){
    	Constants.FOOD -= 15;
    	Constants.WOOD -= 25;
    	Constants.PRODUCTION -= 15;
    	Constants.MAGIC -= 15;
    	
    	type = "Forest";
    }
    
    //Skill: Irrigate, turns plains into water
    public void Irrigate(){
    	Constants.FOOD -= 15;
    	Constants.WOOD -= 15;
    	Constants.PRODUCTION -= 10;
    	Constants.MAGIC -= 20;
    	
    	type = "Water";
    }
    
    //Skill: Deforest, turns forests into plains.
    public void Deforest(){
    	Constants.FOOD -= 25;
    	Constants.WOOD -= 25;
    	Constants.PRODUCTION -= 20;
    	Constants.MAGIC -= 10;
    	
    	type = "Plains";
    }
   
    //Skill: Culture turns desert into plains
    public void Culture(){
    	Constants.CULTURED = true;
    	Constants.FOOD -= 10;
    	Constants.WOOD -= 10;
    	Constants.PRODUCTION -= 10;
    	Constants.MAGIC -= 20;
    	
    	type = "Plains";
    }
    
    //Skill: Drain turns water into plains
    public void Drain(){
    	Constants.FOOD -= 20;
    	Constants.WOOD -= 10;
    	Constants.PRODUCTION -= 20;
    	Constants.MAGIC -= 20;
    	
    	type = "Plains";
    }
    
    /*you should limit what could be built on what.
    *as it stands any structure can be built anywhere.
    *Plains: City/Factory/School/Farm
    *Forest: Mill
    *Mountain:Shrine?
    *Water Shrine?
    *Desert: null
    */
    public void Build(Building b){
    	structure = b;
    }
}
