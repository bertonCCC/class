import java.io.*;

public class dpm{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    final int MOD = 1000 * 1000 * 1000 + 7;
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]);
    int[] arr = new int[N];
    
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(tokens[i]);
    
    int[][] dp = new int[N][K + 1];
    // dp[n][k] = # of ways to distribute k candies over
    // first n children
    int[][] psa = new int[N][K + 1];
    
    // base case: first child can have all candies if they can hold them
    // i.e. 0 <= k <= arr[0]
    for(int k = 0; k <= arr[0]; k++)
      dp[0][k] = 1;
    
    for(int n = 1; n < N; n++){
      // set up the PSA for the previous row
      psa[n - 1][0] = dp[n - 1][0];
      for(int k = 1; k <= K; k++){
        psa[n - 1][k] = (psa[n - 1][k - 1] + dp[n - 1][k]) % MOD;
      }
      
      // actually do dp
      for(int k = 0; k <= K; k++){
        // dp[n][k] = dp[n - 1][k] + dp[n - 1][k - 1] + ... + dp[n - 1][k - arr[n]]
        int minCandies = k - arr[n];
        // if minCandies <= 0, we're taking everything from dp[n - 1][0] ... dp[n - 1][k]
        if(minCandies <= 0)
          dp[n][k] = psa[n - 1][k];
        else
          dp[n][k] = (psa[n - 1][k] - psa[n - 1][minCandies - 1] + MOD) % MOD;
      }
    }
    
    System.out.println(dp[N - 1][K]);
  }
}