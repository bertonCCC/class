import java.io.*;
import java.util.*;

public class mwc15c4p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), Q = Integer.parseInt(tokens[1]);
    TreeSet<Long> exists = new TreeSet<Long>(); // type 1 question
    TreeMap<Integer, Integer> xfreq = new TreeMap<Integer, Integer>();
    TreeMap<Integer, Integer> yfreq = new TreeMap<Integer, Integer>();
    
    for(int i = 0; i < N; i++){
      tokens = in.readLine().split(" ");
      int x = Integer.parseInt(tokens[0]), y = Integer.parseInt(tokens[1]);
      
      exists.add((long) x * 1000000000 + y);
      
      if(xfreq.containsKey(x)){
        int old = xfreq.get(x);
        xfreq.put(x, old + 1);
      }
      else{
        xfreq.put(x, 1);
      }
      
      if(yfreq.containsKey(y)){
        int old = yfreq.get(y);
        yfreq.put(y, old + 1);
      }
      else{
        yfreq.put(y, 1);
      }
    }
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      int type = Integer.parseInt(tokens[0]);
      if(type == 1){
        int x = Integer.parseInt(tokens[1]), y = Integer.parseInt(tokens[2]);
        if(exists.contains((long) x * 1000000000 + y))
          System.out.println("salty");
        else
          System.out.println("bland");
      }
      else{
        String subtype = tokens[1];
        if(subtype.equals("X")){
          int x = Integer.parseInt(tokens[2]);
          if(!xfreq.containsKey(x)) System.out.println(0);
          else System.out.println(xfreq.get(x));
        }
        else{
          int y = Integer.parseInt(tokens[2]);
          if(!yfreq.containsKey(y)) System.out.println(0);
          else System.out.println(yfreq.get(y));
        }
      }
    }
  }
}