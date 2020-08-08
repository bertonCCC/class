import java.util.*;

public class ccc07s4{
  static ArrayList<Integer>[] adj;
  static boolean[] vist;
  static int[] ways;
  static int N;
  
  static void dfs(int cur){
    vist[cur] = true;
    
    if(cur == N){
      ways[cur] = 1;
      return;
    }
    
    for(int to : adj[cur]){
      if(!vist[to]) dfs(to);
      ways[cur] += ways[to];
    }
  }
  
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
  
    N = in.nextInt();
    adj = new ArrayList[N + 1];
    vist = new boolean[N + 1];
    ways = new int[N + 1];
    for(int i = 1; i <= N; i++)
      adj[i] = new ArrayList<Integer>();
    
    while(true){
      int node1 = in.nextInt(), node2 = in.nextInt();
      if(node1 == 0 && node2 == 0) break;
      
      adj[node1].add(node2);
    }
    
    dfs(1);
    System.out.println(ways[1]);
  }
}