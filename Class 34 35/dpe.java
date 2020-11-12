import java.util.*;

public class dpe {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int W = in.nextInt();
    
    int[] weights = new int[N + 1];
    int[] values  = new int[N + 1];
    long[][] dp = new long[N + 1][100001];
    
    for(int i = 1; i <= N; i++){
      weights[i] = in.nextInt();
      values[i]  = in.nextInt();
    }
    
    for(int i = 0; i <= N; i++){
      for(int v = 1; v <= 100000; v++){
        dp[i][v] = 10000000000000L;
      }
    }
    
    for(int n = 1; n <= N; n++){
      for(int v = 0; v <= 100000; v++){
        if(v >= values[n])
          dp[n][v] = Math.min(
                              dp[n - 1][v],
                              dp[n - 1][v - values[n]] + weights[n]);
        else
          dp[n][v] = dp[n - 1][v];
      }
    }
    
    for(int ans = 100000; ans >= 0; ans--){
      if(dp[N][ans] <= W){
        System.out.println(ans);
        break;
      }
    }
  }
}