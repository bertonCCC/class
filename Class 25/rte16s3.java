import java.util.*;
import java.io.*;

public class rte16s3{
  static ArrayList<Pair>[] adj = new ArrayList[6001];
  static int[][] dist = new int[6001][6001];
  
  static void dfs(int current, int parent, int start){
    for(Pair edge : adj[current]){
      int neighbour = edge.node;
      int length = edge.length;
      if(neighbour == parent) continue;
      dist[start][neighbour] = dist[start][current] + length;
      dfs(neighbour, current, start);
    }
  }
  
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(in.readLine());
    String tokens[];
    for(int i = 0; i < N; i++) adj[i] = new ArrayList<Pair>();
    for(int i = 0; i < N - 1; i++){
      tokens = in.readLine().split(" ");
      int node1 = Integer.parseInt(tokens[0]), node2 = Integer.parseInt(tokens[1]), length = Integer.parseInt(tokens[2]);
      adj[node1].add(new Pair(node2, length));
      adj[node2].add(new Pair(node1, length));
    }
    
    for(int i = 0; i < N; i++)
      dfs(i, -1, i);
    
    int Q = Integer.parseInt(in.readLine());
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      int node1 = Integer.parseInt(tokens[0]), node2 = Integer.parseInt(tokens[1]);
      System.out.println(dist[node1][node2] < 0 ? Integer.toUnsignedString(dist[node1][node2]) : dist[node1][node2]);
    }
  }
}

class Pair{
  int node, length;
  public Pair(int n, int l){
    node = n;
    length = l;
  }
}
