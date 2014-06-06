public class Forest extends Tile {
    //Tile t = new Tile();
    
    public Forest(){
	super("Forest");
    }
    
    public void Build(){
	super.Build("Mill");
    }
}