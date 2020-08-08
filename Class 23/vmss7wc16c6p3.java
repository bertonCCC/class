import java.io.*;
import java.util.*;

public class vmss7wc16c6p3{
  static ArrayList<Integer>[] adj = new ArrayList[100001];
  static boolean[] vist = new boolean[100001];
  static int[] timestamp = new int[100001];
  static int currentTime;
  static int[] lowlink = new int[100001];
  static boolean[] isCut = new boolean[100001];
  
  static void dfs(int current, int parent){
    vist[current] = true;
    currentTime += 1;
    timestamp[current] = currentTime;
    lowlink[current] = currentTime;
    int children = 0;
    
    for(int neighbour : adj[current]){
      if(neighbour == parent) continue;
      
      if(!vist[neighbour]){
        children += 1;
        dfs(neighbour, current);
        lowlink[current]
          = Math.min(lowlink[current], lowlink[neighbour]); // Rule 2
        
        if(current != 1 && lowlink[neighbour] >= timestamp[current]) // Rule 3a)
          isCut[current] = true;
      }
      else{
        lowlink[current]
          = Math.min(lowlink[current], timestamp[neighbour]); // Rule 1
      }
    }
    
    if(current == 1 && children > 1) // Rule 3b)
      isCut[current] = true;
  }
  
  
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = pi(tokens[0]), M = pi(tokens[1]);
    for(int i = 1; i <= N; i++) adj[i] = new ArrayList<Integer>();
    for(int i = 0; i < M; i++){
      tokens = in.readLine().split(" ");
      int node1 = pi(tokens[0]), node2 = pi(tokens[1]);
      
      adj[node1].add(node2);
      adj[node2].add(node1);
    }
    
    dfs(1, -1);
    
    int count = 0;
    
    for(int node = 1; node <= N; node++)
      if(isCut[node])
      count += 1;
    
    System.out.println(count);
    for(int node = 1; node <= N; node++)
      if(isCut[node])
      System.out.println(node);
  }
  
  static int pi(String s){
    return Integer.parseInt(s);
  }
}