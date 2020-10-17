import java.io.*;

public class dpb{
  public static void main(String[] args) throws IOException{
    final int INF = 1 * 1000 * 1000 * 1000 + 1;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]);
    int[] height = new int[N];
    int[] dp = new int[N];
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++) height[i] = Integer.parseInt(tokens[i]);
    
    dp[0] = 0;
    for(int n = 1; n < N; n++){
      dp[n] = INF;
      for(int k = 1; k <= K; k++){
        if(n - k >= 0){
          dp[n] = Math.min(dp[n], dp[n - k] + Math.abs(height[n] - height[n - k]));
        }
      }
    }
    
    System.out.println(dp[N - 1]);
  }
}