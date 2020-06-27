import java.io.*;
import java.util.*;

public class vmss7wc16c3p2_2{
  static boolean ans = false;
  static int B;
  static boolean[] vist;
  static ArrayList<Integer>[] adj;

  static void dfs(int current){
    vist[current] = true;
    if(current == B) ans = true;
    
    for(int neighbour : adj[current]){
      if(!vist[neighbour]){
        dfs(neighbour);
      }
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]),
      M = Integer.parseInt(tokens[1]),
      A = Integer.parseInt(tokens[2]);
    
    B = Integer.parseInt(tokens[3]);
    
    vist = new boolean[N + 1];
    adj = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++)
      adj[i] = new ArrayList<Integer>();
    
    for(int i = 0; i < M; i++){
      tokens = in.readLine().split(" ");
      int X = Integer.parseInt(tokens[0]), Y = Integer.parseInt(tokens[1]);
      
      adj[X].add(Y);
      adj[Y].add(X);
    }
    
    dfs(A);
    
    if(ans) System.out.println("GO SHAHIR!");
    else System.out.println("NO SHAHIR!");
  }
}