package com.anish_dmitriy.growisland.tiles;


public class Forest extends Tile {
    //Tile t = new Tile();
    
    public Forest(){
	super("Forest");
    }
    
    public void Build(Mill m){
    	super.Build(m);
    }

}