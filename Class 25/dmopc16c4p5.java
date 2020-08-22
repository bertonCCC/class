import java.util.*;
import java.io.*;

public class dmopc16c4p5{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] tokens;
    
    tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]);
    int[] best = new int[N + 1];
    boolean[] vist = new boolean[N + 1];
    ArrayList<Pair>[] adj = new ArrayList[N + 1];
    for(int i = 0; i <= N; i++) adj[i] = new ArrayList<Pair>();
    
    for(int i = 0; i < M; i++){
      tokens = in.readLine().split(" ");
      int node1 = Integer.parseInt(tokens[0]), node2 = Integer.parseInt(tokens[1]), length = Integer.parseInt(tokens[2]);
      adj[node1].add(new Pair(node2, length));
      adj[node2].add(new Pair(node1, length));
    }
    
    PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
    heap.offer(new Pair(1, 0));
    best[1] = 2 * 1000 * 1000 * 1000;
    while(!heap.isEmpty()){
      int current = heap.poll().node;
      if(vist[current]) continue;
      vist[current] = true;
      
      for(Pair edge : adj[current]){
        int neighbour = edge.node;
        int length = edge.length;
        
        if(Math.min(best[current], length) > best[neighbour]){
          best[neighbour] = Math.min(best[current], length);
          heap.offer(new Pair(neighbour, best[neighbour]));
        }
      }
    }
    
    System.out.println(0);
    for(int i = 2; i <= N; i++)
      System.out.println(best[i]);
  }
}

class Pair implements Comparable<Pair>{
  int node, length;
  public Pair(int n, int l){
    node = n;
    length = l;
  }
  public int compareTo(Pair other){
    return other.length - this.length;
  }
}