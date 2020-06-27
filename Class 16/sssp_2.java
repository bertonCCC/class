import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class sssp_2{
  static int N, M;
  static ArrayList<Edge>[] adj = new ArrayList[1001];
  static int[] dist = new int[1001];
  
  static void dijks(){
    PriorityQueue<Edge> heap = new PriorityQueue<Edge>();
    int cur;
    
    for(int i = 1; i <= N; i++)
      dist[i] = 1000 * 1000 * 1000;
    dist[1] = 0;
    heap.offer(new Edge(1, 0));
    
    while(!heap.isEmpty()){
      cur = heap.poll().node;
      for(Edge to : adj[cur]){
        if(dist[cur] + to.dist < dist[to.node]){
          dist[to.node] = dist[cur] + to.dist;
          heap.offer(new Edge(to.node, dist[to.node]));
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException{
    int u, v, w;
    String[] t;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    t = in.readLine().split(" ");
    N = Integer.parseInt(t[0]);
    M = Integer.parseInt(t[1]);
    
    for(int i = 1; i <= N; i++){
      adj[i] = new ArrayList<Edge>();
    }
    
    for(int i = 0; i < M; i++){
      t = in.readLine().split(" ");
      u = Integer.parseInt(t[0]);
      v = Integer.parseInt(t[1]);
      w = Integer.parseInt(t[2]);
      adj[u].add(new Edge(v, w));
      adj[v].add(new Edge(u, w));
    }
    
    dijks();
    
    for(int i = 1; i <= N; i++)
      System.out.println(dist[i] == 1000 * 1000 * 1000 ? -1 : dist[i]);
  }
}

class Edge implements Comparable<Edge>{
  int node, dist;
  public Edge(int n, int d){
    node = n;
    dist = d;
  }
  public int compareTo(Edge o){
    return dist - o.dist;
  }
}