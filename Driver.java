import java.io.*;
import java.util.*;

public class Driver{
    public static void main (String[] args){
	
	PriorityQueue dis = new PriorityQueue();
	Disaster d = new Disaster();
	for (int i = 0;i < 20;i++){
	    dis.add(d.generator());
	    
	    System.out.println(dis.remove());
	}
	
	
	
    }
}