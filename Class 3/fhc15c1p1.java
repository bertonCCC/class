import java.io.*;
import java.util.*;

public class fhc15c1p1{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    final int MAX = 10000000;
    int[] primacity = new int[MAX + 1];
    
    for(int i = 2; i <= MAX; i++){
      if(primacity[i] == 0){
        for(int j = i; j <= MAX; j += i){
          primacity[j] += 1;
        }
      }
    }
    
    int T = Integer.parseInt(in.readLine());
    for(int i = 1; i <= T; i++){
      String[] tokens = in.readLine().split(" ");
      int A = Integer.parseInt(tokens[0]);
      int B = Integer.parseInt(tokens[1]);
      int K = Integer.parseInt(tokens[2]);
      int count = 0;
      for(int j = A; j <= B; j++){
        if(primacity[j] == K)
          count += 1;
      }
      System.out.println("Case #" + i + ": " + count);
    }
  }
}