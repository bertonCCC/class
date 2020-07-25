import java.io.*;
import java.util.*;

public class ccc17s4{
  static int[] par;
  
  static int find(int cur){
    if(par[cur] == cur) return cur;
    return par[cur] = find(par[cur]);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]), D = Integer.parseInt(tokens[2]);
    Edge[] edges = new Edge[M];
    par = new int[N + 1];
    for(int i = 1; i <= N; i++) par[i] = i;
    
    for(int i = 0; i < M; i++){
      tokens = in.readLine().split(" ");
      int node1 = Integer.parseInt(tokens[0]), node2 = Integer.parseInt(tokens[1]), weight = Integer.parseInt(tokens[2]);
      edges[i] = new Edge();
      edges[i].node1 = node1;
      edges[i].node2 = node2;
      edges[i].weight = weight;
      edges[i].active = (i < N - 1);
    }
    
    Arrays.sort(edges);
    
    int counter = 0;
    int days = 0;
    
    for(Edge edge : edges){
      int final1 = find(edge.node1), final2 = find(edge.node2);
      if(final1 == final2) continue;
      else{
        par[final1] = final2;
        counter += 1;
        if(!edge.active) days += 1;
      }
      
      if(counter == N - 1) break;
    }
    
    System.out.println(days);
  }
}

class Edge implements Comparable<Edge>{
  public int node1, node2;
  Integer weight;
  public boolean active;
  
  public int compareTo(Edge other){
    if(this.weight != other.weight) return this.weight.compareTo(other.weight);
    if(this.active == other.active) return 0;
    else if(this.active && !other.active) return -1;
    return 1;
  }
}