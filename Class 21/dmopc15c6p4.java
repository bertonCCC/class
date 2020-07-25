import java.io.*;
import java.util.*;

public class dmopc15c6p4{
  static int[] par;
  
  static int find(int cur){
    if(par[cur] == cur) return cur;
    return par[cur] = find(par[cur]);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]);
    par = new int[N + 1];
    for(int i = 1; i <= N; i++)
      par[i] = i;
    
    ArrayList<Edge> edges = new ArrayList<Edge>();
    tokens = in.readLine().split(" ");
    
    for(int i = 0; i < N - 1; i++){
      Edge edge = new Edge();
      edge.node1 = i + 1;
      edge.node2 = i + 2;
      edge.weight = Integer.parseInt(tokens[i]);
      edges.add(edge);
    }
    
    for(int i = 1; i + K <= N; i++){
      Edge edge = new Edge();
      edge.node1 = i;
      edge.node2 = i + K;
      edge.weight = 0;
      edges.add(edge);
    }
    
    Collections.sort(edges);
    
    int counter = 0, sum = 0;
    
    for(Edge edge : edges){
      // C++: int node1, node2, weight
      // tie(node1, node2, weight) = edge
      int node1 = edge.node1, node2 = edge.node2, weight = edge.weight;
      
      int par1 = find(node1), par2 = find(node2);
      if(par1 == par2) continue;
      
      par[par1] = par2;
      counter += 1;
      sum += weight;
      // ++counter, counter++, counter = counter + 1
      
      if(counter == N - 1) break;
    }
    
    System.out.println(sum);
  }
}

// C++: tuple<int, int, int> which is <weight, node1, node2>
class Edge implements Comparable<Edge>{
  public int node1, node2;
  public Integer weight;
  
  public int compareTo(Edge other){
    return this.weight.compareTo(other.weight);
  }
}