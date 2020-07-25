import java.io.*;
import java.util.*;

public class dmopc17c1p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]);
    boolean[] vist = new boolean[N + 1];
    ArrayList<NodeAndDist>[] adj = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++) adj[i] = new ArrayList<NodeAndDist>();
    final int INFINITY = 1000 * 1000;
    
    for(int i = 0; i < M; i++){
      tokens = in.readLine().split(" ");
      int node1 = Integer.parseInt(tokens[0]), node2 = Integer.parseInt(tokens[1]), dang = Integer.parseInt(tokens[2]);
      
      adj[node1].add(new NodeAndDist(node2, new Distance(dang, 1)));
      adj[node2].add(new NodeAndDist(node1, new Distance(dang, 1)));
    }
    
    PriorityQueue<NodeAndDist> heap = new PriorityQueue<NodeAndDist>();
    Distance[] dist = new Distance[N + 1];
    for(int i = 2; i <= N; i++)
      dist[i] = new Distance(INFINITY, INFINITY);
    dist[1] = new Distance(0, 0);
    heap.offer(new NodeAndDist(1, dist[1]));
    
    while(!heap.isEmpty()){
      NodeAndDist lowest = heap.poll();
      int current = lowest.node;
      if(vist[current]) continue;
      vist[current] = true;
      
      for(NodeAndDist to : adj[current]){
        int neighbour = to.node;
        Distance weight = to.dist;
        
        Distance newDist 
          = new Distance(dist[current].dang + weight.dang, dist[current].total + weight.total);
        
        if(newDist.compareTo(dist[neighbour]) < 0){
          dist[neighbour] = newDist;
          heap.offer(new NodeAndDist(neighbour, newDist));
        }
      }
    }
    
    if(dist[N].total == INFINITY)
      System.out.println(-1);
    else
      System.out.println(dist[N].dang + " " + dist[N].total);
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