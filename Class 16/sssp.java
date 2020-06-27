import java.io.*;
import java.util.*;

public class sssp{
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
  
    int N = in.nextInt(), M = in.nextInt();
    ArrayList<Edge>[] adj = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++)
      adj[i] = new ArrayList<Edge>();
    
    for(int i = 0; i < M; i++){
      int node1 = in.nextInt(), node2 = in.nextInt(), distance = in.nextInt();
      adj[node1].add(new Edge(node2, distance));
      adj[node2].add(new Edge(node1, distance));
    }
    
    boolean[] visited = new boolean[N + 1];
    int[] dist = new int[N + 1]; // dist[i] = distance from node 1 to node i
    for(int i = 2; i <= N; i++)
      dist[i] = 1000 * 1000 * 1000;
    
    for(int i = 0; i < N; i++){
      int current = 0;
      // want to find the node with smallest dist
      // (distance to 1), but also not visited
      for(int node = 1; node <= N; node++){
        if(!visited[node] && (current == 0 || dist[node] < dist[current]))
          current = node;
      }
      
      visited[current] = true;
      
      for(Edge edge : adj[current]){
        int neighbour = edge.to;
        int length = edge.length;
        
        if(dist[current] + length < dist[neighbour]){
          dist[neighbour] = dist[current] + length;
        }
      }
    }
    
    for(int i = 1; i <= N; i++){
      if(dist[i] == 1000 * 1000 * 1000)
        System.out.println(-1);
      else
        System.out.println(dist[i]);
    }
  }
}

class Edge{
  public int to, length;
  
  public Edge(int t, int l){
    this.to = t;
    this.length = l;
  }
}