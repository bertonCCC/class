import java.io.*;
import java.util.*;

public class dpn{
  static final long INF = 500 * 1000 * 1000 * 1000;
  static long[][] dp = new long[400][400];
  static long[] arr = new long[400];
  
  static long dfs(int left, int right){
    if(left >= right) return 0;
    if(dp[left][right] != INF) return dp[left][right];
    
    long rangeSum = 0;
    for(int i = left; i <= right; i++){
      rangeSum += arr[i];
    }
    
    for(int k = left; k < right; k++){
      dp[left][right] = Math.min(dp[left][right],
                                 dfs(left, k) + dfs(k + 1, right) + rangeSum);
    }
    
    return dp[left][right];
  }
  
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
    
    int N = in.nextInt();

    for(int i = 0; i < N; i++)
      arr[i] = in.nextInt();
    
    for(int i = 0; i < N; i++)
      for(int j = 0; j < N; j++)
      dp[i][j] = INF;
    
    long ans = dfs(0, N - 1);
    System.out.println(ans);
  }
}