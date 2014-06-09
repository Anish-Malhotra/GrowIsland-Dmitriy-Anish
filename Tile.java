public class Tile{
    
    String type;
    String structure;
    int struc;
    
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
    
    public void upGrade(){
	struc = struc + 1;
    }
    
    public void downGrade(){
	if (struc == 0){
	    type = null; //something
	}else{
	    struc = struc - 1;
	}
    }
}
