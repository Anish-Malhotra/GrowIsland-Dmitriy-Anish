public class Plains extends Tile{
    public Plains(){
	super("Plains");
    }
    
    // we can build a City/Factory/Farm/School/Temple on this tile
    public void Build(String s){
	super.Build(s);
    }
    
}