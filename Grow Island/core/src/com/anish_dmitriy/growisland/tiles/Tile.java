package com.anish_dmitriy.growisland.tiles;

import com.anish_dmitriy.growisland.building.*;


public class Tile{
    
    String type;
    public Building structure;

    public Tile(){
    	type = null;
    	structure = null;
    }
    
    public Tile(String s){
    	type = s; 
    }
    
    //Skill: Reforest, turns plains into forests.
    public void Reforest(){
    	type = "Forest";
    }
    
    //Skill: Irrigate, turns plains into water
    public void Irrigate(){
    	type = "Water";
    }
    
    //Skill: Deforest, turns forests into plains.
    public void Deforest(){
    	type = "Plains";
    }
   
    //Skill: Culture turns desert into plains
    public void Culture(){
    	type = "Plains";
    }
    
    //Skill: Drain turns water into plains
    public void Drain(){
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
