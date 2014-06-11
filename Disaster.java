import java.io.*;
import java.util.*;

public class Disaster{
    String[] disasters;
    public Disaster(){
	disasters = new String[10];
	//add disasters for each slot
	for (int i = 0;i < disasters.length;i++){
	    disasters[i] = "" + i;
	}
    }
    
    public String generator(){
	Random r = new Random();
	int tmp = r.nextInt(disasters.length-2);
	String temp = disasters[tmp];
	disasters[tmp] = disasters[disasters.length-1];
	disasters[disasters.length-1] = temp;
	return temp;
	
    }
}