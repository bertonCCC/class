import java.io.*;
import java.util.*;

public class mwc15c6p3{
  public static int pi(String s){
    return Integer.parseInt(s);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = pi(tokens[0]), Q = pi(tokens[1]);
    
    long[] sets = new long[N + 1];
    
    for(int i = 1; i <= N; i++){
      tokens = in.readLine().split(" ");
      int size = pi(tokens[0]);
      
      long mask = 0;
      for(int j = 1; j <= size; j++){
        int ele = pi(tokens[j]) + 30;
        mask = mask | (1L << ele);
      }
      
      sets[i] = mask;
    }
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      int size = pi(tokens[0]);
      
      long ansMask = 0;
      for(int j = 1; j <= size; j++){
        int setIndex = pi(tokens[j]);
        ansMask = ansMask ^ sets[setIndex];
      }
      
      ArrayList<Integer> ans = new ArrayList<Integer>();
      for(int j = -30; j <= 30; j++){
        if((ansMask & (1L << (j + 30))) != 0){
          ans.add(j);
        }
      }
      
      System.out.print(ans.size() + " ");
      for(int n : ans){
        System.out.print(n + " ");
      }
      System.out.println();
    }
  }
}