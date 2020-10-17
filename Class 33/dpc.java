import java.io.*;

public class dpc{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(in.readLine());
    int[][] happ = new int[N][3];
    int[][] dp   = new int[N][3];
    // 0 = A, 1 = B, 2 = C
    
    String[] tokens;
    for(int i = 0; i < N; i++){
      tokens = in.readLine().split(" ");
      for(int j = 0; j < 3; j++)
        happ[i][j] = Integer.parseInt(tokens[j]);
    }
    
    for(int i = 0; i < 3; i++)
      dp[0][i] = happ[0][i];
    
    for(int d = 1; d < N; d++){
      dp[d][0] = Math.max(dp[d - 1][1], dp[d - 1][2]) + happ[d][0];
      dp[d][1] = Math.max(dp[d - 1][0], dp[d - 1][2]) + happ[d][1];
      dp[d][2] = Math.max(dp[d - 1][0], dp[d - 1][1]) + happ[d][2];
    }
    
    int ans = Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
    System.out.println(ans);
  }
}