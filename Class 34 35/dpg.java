import java.io.*;
import java.util.*;

public class dpg{
  static final int SIZE = 100 * 1000 + 1;
  static ArrayList<Integer>[] adj = new ArrayList[SIZE];
  static int[] dp = new int[SIZE];
  
  static int dfs(int u){
    if(dp[u] != -1) return dp[u];
    
    // Longest path is 1 + longest path from each child
    // or 0 if there are no children
    dp[u] = 0;
    for(int v : adj[u]){
      dp[u] = Math.max(dp[u], dfs(v) + 1);
    }
    
    return dp[u];
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]);
    for(int i = 1; i <= N; i++) adj[i] = new ArrayList<Integer>();
    for(int i = 0; i < M; i++){
      tokens = in.readLine().split(" ");
      int u = Integer.parseInt(tokens[0]), v = Integer.parseInt(tokens[1]);
      adj[u].add(v);
      //adj[v].add(u);
    }
    
    // dp[u] is the longest path starting from u
    // Set it to -1 initially to symbolize that dp[u] hasn't been calculated yet
    for(int i = 1; i <= N; i++)
      dp[i] = -1;
    
    // Graph might not be connected so call DP  function on every node
    // If any node has been visited before it'll exit immediately, keeping O(N) total
    int ans = 0;
    for(int i = 1; i <= N; i++){
      ans = Math.max(ans, dfs(i));
    }
    System.out.println(ans);
  }
}