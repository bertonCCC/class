import java.io.*;
import java.util.*;

public class ccc13s4{
  static ArrayList<Integer>[] adj;
  static boolean[] vist;
  static int target;
  static boolean found = false;
  
  static void dfs(int cur){
    if(cur == target) found = true;
    
    vist[cur] = true;
    for(int to : adj[cur]){ // list of people shorter
      if(vist[to]) continue;
      
      dfs(to);
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]);
    adj = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++)
      adj[i] = new ArrayList<Integer>();
    vist = new boolean[N + 1];
    
    for(int i = 0; i < M; i++){
      tokens = in.readLine().split(" ");
      int x = Integer.parseInt(tokens[0]), y = Integer.parseInt(tokens[1]);
      
      adj[x].add(y);
    }
    
    tokens = in.readLine().split(" ");
    int P = Integer.parseInt(tokens[0]), Q = Integer.parseInt(tokens[1]);

    target = Q;
    found = false;
    dfs(P);
    if(found){
      System.out.println("yes");
      return;
    }
    
    target = P;
    found = false;
    vist = new boolean[N + 1];
    dfs(Q);
    if(found){
      System.out.println("no");
      return;
    }
    
    System.out.println("unknown");
  }
}