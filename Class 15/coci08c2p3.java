import java.io.*;

public class coci08c2p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    int[] sour = new int[N];
    int[] bitter = new int[N];
    
    for(int i = 0; i < N; i++){
      String[] tokens = in.readLine().split(" ");
      sour[i] = Integer.parseInt(tokens[0]);
      bitter[i] = Integer.parseInt(tokens[1]);
    }
    
    int ans = 2 * 1000 * 1000 * 1000;
    for(int mask = 1; mask < (1 << N); mask++){
      int sourTotal = 1;
      int bitterTotal = 0;
      
      for(int pos = 0; pos < N; pos++){
        if((mask & (1 << pos)) != 0){
          sourTotal *= sour[pos];
          bitterTotal += bitter[pos];
        }
      }
      
      ans = Math.min(ans, Math.abs(sourTotal - bitterTotal));
    }
    
    System.out.println(ans);
  }
}