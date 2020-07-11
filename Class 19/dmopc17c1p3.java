import java.io.*;
import java.util.*;

public class dmopc17c1p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]);
    boolean[] vist = new boolean[N + 1];
    ArrayList<NodeAndDist>[] adj = new ArrayList[N + 1];
    
    for(int i = 0; i < M; i++){
      tokens = in.readLine().split(" ");
      int node1 = Integer.parseInt(tokens[0]), node2 = Integer.parseInt(tokens[1]), dang = Integer.parseInt(tokens[2]);
      
      adj[node1].add(new NodeAndDist(node2, new Distance(dang, 1)));
      adj[node2].add(new NodeAndDist(node1, new Distance(dang, 1)));
    }
  }
}

class Distance implements Comparable<Distance>{
  Integer dang, total;
  
  public Distance(int d, int t){
    this.dang = d;
    this.total = t;
  }
  
  public int compareTo(Distance other){
    if(this.dang == other.dang)
      return this.total.compareTo(other.total);
    return this.dang.compareTo(other.dang);
  }
}

class NodeAndDist implements Comparable<NodeAndDist>{
  int node;
  Distance dist;
  
  public NodeAndDist(int n, Distance d){
    this.node = n;
    this.dist = d;
  }
  
  public int compareTo(NodeAndDist other){
    return this.dist.compareTo(other.dist);
  }
}