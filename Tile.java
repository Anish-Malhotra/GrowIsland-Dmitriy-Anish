public class Tile{
    
    String type;
    String structure;
    
    public Tile(){
	type = null;
	structure = null;
    }
    
    public Tile(String s){
	type = s; 
    }

    public void Build(String t){
	structure = t;
    }

}