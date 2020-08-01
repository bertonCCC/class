import java.io.*;
import java.util.*;

public class ccc18j5{
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(in.readLine());
    
    ArrayList<Integer>[] adj = new ArrayList[N + 1];
    int[] dist = new int[N + 1];
    boolean[] vist = new boolean[N + 1];
    
    for(int i = 1; i <= N; i++){
      adj[i] = new ArrayList<Integer>();
      String[] tokens = in.readLine().split(" ");
      int len = Integer.parseInt(tokens[0]);
      for(int j = 1; j <= len; j++){
        adj[i].add(Integer.parseInt(tokens[j]));
      }
    }
    
    Queue<Integer> que = new LinkedList<Integer>();
    que.offer(1);
    vist[1] = true;
    while(!que.isEmpty()){
      int cur = que.poll();
      // C++, cur = que.front(); que.pop();
      
      for(int to : adj[cur]){
        if(!vist[to]) continue;
        
        vist[to] = true;
        dist[to] = dist[cur] + 1;
        que.offer(to);
      }
    }
    
    boolean allReachable = true;
    for(int i = 1; i <= N; i++){
      if(!vist[i]) allReachable = false;
    }
    
    int shortestDist = 10 * 1000 + 1;
    for(int i = 1; i <= N; i++){
      if(vist[i] && adj[i].size() == 0)
        shortestDist = Math.min(shortestDist, dist[i]);
    }
    
    System.out.println(allReachable ? "Y" : "N");
    System.out.println(shortestDist + 1);
  }
}