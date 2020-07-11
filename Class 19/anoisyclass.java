import java.io.*;
import java.util.*;

public class anoisyclass{
  static boolean[] vist;
  static boolean[] inPath;
  static boolean foundCycle = false;
  static ArrayList<Integer>[] adj;
  
  static void dfs(int current){
    vist[current] = true;
    inPath[current] = true;
    
    for(int neighbour : adj[current]){
      if(inPath[neighbour]) foundCycle = true;
      if(!vist[neighbour]){
        dfs(neighbour);
      }
    }
    
    inPath[current] = false;
  }
  
  public static void main(String[] args) throws IOException{
    //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner in = new Scanner(System.in);
    
    int N = in.nextInt(), M = in.nextInt();
    
    vist = new boolean[N + 1];
    inPath = new boolean[N + 1];
    adj = new ArrayList[N + 1];
    for(int i = 1; i <= N; i++)
      adj[i] = new ArrayList<Integer>();
    
    for(int i = 0; i < M; i++){
      int node1 = in.nextInt(), node2 = in.nextInt();
      adj[node1].add(node2);
    }
    
    for(int i = 1; i <= N; i++){
      if(!vist[i])
        dfs(i);
    }
    
    if(foundCycle) System.out.println("N");
    else System.out.println("Y");
  }
}