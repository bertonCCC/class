import java.io.*;
import java.util.*;

public class dmopc16c4p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    TreeSet<Pair>[] stands = new TreeSet[101];
    for(int i = 0; i < 101; i++) stands[i] = new TreeSet();
    
    HashSet<Integer>[] types = new HashSet[100001];
    for(int i = 0; i < 100001; i++) types[i] = new HashSet();
    
    int[] dist = new int[100001];
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), S = Integer.parseInt(tokens[1]);
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++){
      dist[i + 1] = Integer.parseInt(tokens[i]);
    }
    
    for(int i = 0; i < S; i++){
      tokens = in.readLine().split(" ");
      int stand = Integer.parseInt(tokens[0]), type = Integer.parseInt(tokens[1]);
      types[stand].add(type);
      stands[type].add(new Pair(dist[stand], stand));
    }
    
    int Q = Integer.parseInt(in.readLine());
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      if(tokens[0].equals("A")){
        int stand = Integer.parseInt(tokens[1]), type = Integer.parseInt(tokens[2]);
        types[stand].add(type);
        stands[type].add(new Pair(dist[stand], stand));
      }
      else if(tokens[0].equals("S")){
        int stand = Integer.parseInt(tokens[1]), type = Integer.parseInt(tokens[2]);
        types[stand].remove(type);
        stands[type].remove(new Pair(dist[stand], stand));
      }
      else if(tokens[0].equals("E")){
        int stand = Integer.parseInt(tokens[1]), dis = Integer.parseInt(tokens[2]);
        for(int type : types[stand]){
          stands[type].remove(new Pair(dist[stand], stand));
        }
        types[stand].clear();
        dist[stand] = dis;
      }
      else{
        int type = Integer.parseInt(tokens[1]);
        if(stands[type].size() == 0) System.out.println(-1);
        else{
          int ans = stands[type].first().id;
          System.out.println(ans);
        }
      }
    }
  }
}

class Pair implements Comparable<Pair>{
  public Integer dist, id;
  public int compareTo(Pair other){
    if(this.dist == other.dist){
      return this.id.compareTo(other.id);
    }
    return this.dist.compareTo(other.dist);
  }
  public Pair(int d, int i){
    this.dist = d;
    this.id = i;
  }
}