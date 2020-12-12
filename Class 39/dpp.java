import java.io.*;
import java.util.*;

public class dpp{
  static final int SIZE = 100 * 1000 + 1;
  static final int MOD = 1000 * 1000 * 1000 + 7;
  static ArrayList<Integer>[] adj = new ArrayList[SIZE];
  static long[] dpw = new long[SIZE];
  static long[] dpb = new long[SIZE];
  
  static void dfs(int cur, int par){
    dpw[cur] = 1; // product of all dpw[child] + dpb[child]
    dpb[cur] = 1; // product of all dpw[child]
    
    for(int child : adj[cur]){
      if(child == par) continue;
      dfs(child, cur); // make sure that dp[child] is calculated
      
      dpw[cur] = dpw[cur] * (dpw[child] + dpb[child]) % MOD;
      dpb[cur] = dpb[cur] * dpw[child] % MOD;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    for(int i = 1; i <= N; i++)
      adj[i] = new ArrayList<Integer>();
    
    String[] tokens;
    for(int i = 0; i < N - 1; i++){
      tokens = in.readLine().split(" ");
      int u = Integer.parseInt(tokens[0]), v = Integer.parseInt(tokens[1]);
      
      adj[u].add(v);
      adj[v].add(u);
    }
    
    dfs(1, -1);
    
    long ans = (dpw[1] + dpb[1]) % MOD;
    System.out.println(ans);
  }
}