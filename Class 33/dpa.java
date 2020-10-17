import java.io.*;

public class dpa{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    int[] height = new int[N];
    int[] dp = new int[N];
    String[] tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++) height[i] = Integer.parseInt(tokens[i]);
    
    dp[0] = 0;
    dp[1] = Math.abs(height[1] - height[0]);
    for(int n = 2; n < N; n++){
      dp[n] = Math.min(dp[n - 2] + Math.abs(height[n] - height[n - 2]),
                       dp[n - 1] + Math.abs(height[n] - height[n - 1]));
    }
    
    System.out.println(dp[N - 1]);
  }
}