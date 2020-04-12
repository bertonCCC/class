import java.io.*;
import java.util.*;

public class ccc15s3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int G = Integer.parseInt(in.readLine());
    int P = Integer.parseInt(in.readLine());
    
    TreeSet<Integer> open = new TreeSet<Integer>();
    for(int i = 1; i <= G; i++){
      open.add(i);
    }
    
    for(int i = 0; i < P; i++){
      int pref = Integer.parseInt(in.readLine());
      
      Integer best = open.floor(pref);
      if(best == null){
        System.out.println(i);
        return;
      }
      else{
        open.remove(best);
      }
    }
    
    System.out.println(P);
  }
}