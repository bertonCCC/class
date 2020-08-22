import java.util.*;

public class vmss15c1p4{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    
    int T = in.nextInt(), N = in.nextInt(), M = in.nextInt(), G = in.nextInt();
    int[] dist = new int[N + 1];
    boolean[] isDest = new boolean[N + 1];
    boolean[] vist = new boolean[N + 1];
    ArrayList<Pair>[] adj = new ArrayList[N + 1];
    
    for(int i = 0; i <= N; i++) adj[i] = new ArrayList<Pair>();
    for(int i = 1; i <= N; i++) dist[i] = 2 * 1000 * 1000 * 1000;
    
    for(int i = 0; i < G; i++){
      int node = in.nextInt();
      isDest[node] = true;
    }
    
    for(int i = 0; i < M; i++){
      int node1 = in.nextInt(), node2 = in.nextInt(), length = in.nextInt();
      adj[node1].add(new Pair(node2, length));
    }
    
    PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
    heap.offer(new Pair(0, 0));
    int answer = 0;
    
    while(!heap.isEmpty()){
      int current = heap.poll().node;
      if(vist[current]) continue;
      vist[current] = true;
      if(isDest[current] && dist[current] <= T) answer += 1;
      
      for(Pair edge : adj[current]){
        int neighbour = edge.node;
        int length = edge.length;
                
        if(dist[current] + length < dist[neighbour]){
          dist[neighbour] = dist[current] + length;
          heap.offer(new Pair(neighbour, dist[neighbour]));
        }
      }
    }

    System.out.println(answer);
  }
}

class Pair implements Comparable<Pair>{
  int node, length;
  
  public Pair(int n, int l){
    node = n;
    length = l;
  }
  
  public int compareTo(Pair other){
    return this.length - other.length;
  }
}
