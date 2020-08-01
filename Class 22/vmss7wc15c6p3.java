import java.io.*;
import java.util.*;

public class vmss7wc15c6p3{
  static ArrayList<Integer>[] adj;
  static int[] value;
  static int[] sum;
  static int max = -1 * 1000 * 1000 * 1000;
  
  static void dfs(int cur){
    sum[cur] = value[cur];
    
    for(int to : adj[cur]){
      dfs(to);
      sum[cur] += sum[to];
    }
    
    // sum[cur] is a correct value
    max = Math.max(max, sum[cur]);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(in.readLine());
    adj = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++)
      adj[i] = new ArrayList<Integer>();
    value = new int[N + 1];
    sum = new int[N + 1];
    
    String tokens[];
    for(int i = 0; i < N - 1; i++){
      tokens = in.readLine().split(" ");
      int node1 = Integer.parseInt(tokens[0]), node2 = Integer.parseInt(tokens[1]);
      
      adj[node1].add(node2);
    }
    
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++){
      value[i + 1] = Integer.parseInt(tokens[i]);
    }
    
    dfs(1);
    
    System.out.println(max);
  }
}