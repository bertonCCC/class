import java.io.*;
import java.util.*;

// NOT FINISHED
public class dmopc16c4p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    //TreeSet<Pair>[] dists = new TreeSet<Pair>[100];
  }
}

class Pair implements Comparable<Pair>{
  public Integer dist, id;
  public int compareTo(Pair other){
    if(this.dist == other.dist)
      return this.id.compareTo(other.id);
    return this.dist.compareTo(other.dist);
  }
}