import java.io.*;
import java.util.*;

/*
Input might look like
5 5
1 4 3
1 2 2
1 5 1
2 3 5
4 5 2
*/

public class sort_edges{  
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
    
    int N = in.nextInt(), M = in.nextInt();
    Edge[] edges = new Edge[M];
    
    for(int i = 0; i < M; i++){
      int node1 = in.nextInt(), node2 = in.nextInt(), length = in.nextInt();
      edges[i] = new Edge();
      edges[i].node1 = node1;
      edges[i].node2 = node2;
      edges[i].length = length;
    }
    Arrays.sort(edges);
    
    for(int i = 0; i < M; i++){
      System.out.println(edges[i].node1 + " " + edges[i].node2 + " " + edges[i].length);
    }
  }
}

class Edge implements Comparable<Edge>{
  public Integer node1, node2, length;
  
  public int compareTo(Edge other){
    return this.length.compareTo(other.length);
  }
}