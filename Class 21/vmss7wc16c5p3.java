import java.io.*;
import java.util.*;

public class vmss7wc16c5p3{
  static boolean[] vist;
  static int[] dist;
  static ArrayList<Integer>[] adj;
  static int farthest = 1;
  
  static void dfs(int cur){
    vist[cur] = true;
    if(dist[cur] > dist[farthest])
      farthest = cur;
    
    for(int neigh : adj[cur]){
      if(vist[neigh]) continue;
      dist[neigh] = dist[cur] + 1;
      dfs(neigh);
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    adj = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++) adj[i] = new ArrayList();
    vist = new boolean[N + 1];
    dist = new int[N + 1];
    
    for(int i = 0; i < N - 1; i++){
      String[] tokens = in.readLine().split(" ");
      int node1 = Integer.parseInt(tokens[0]), node2 = Integer.parseInt(tokens[1]);
      adj[node1].add(node2);
      adj[node2].add(node1);
    }
    
    dfs(1);
    int A = farthest;
    
    farthest = A;
    for(int i = 1; i <= N; i++){
      vist[i] = false;
      dist[i] = 0;
    }
    dfs(A);
    int B = farthest;
    
    System.out.println(dist[B]);
  }
}