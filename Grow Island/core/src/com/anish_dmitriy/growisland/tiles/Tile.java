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
