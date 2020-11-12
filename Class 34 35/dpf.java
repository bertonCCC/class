import java.util.*;

public class dpf{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String S = in.nextLine();
    String T = in.nextLine();
    int N = S.length(), M = T.length();
    int[][] dp = new int[N + 1][M + 1];
    
    S = "#" + S;
    T = "#" + T; // 1-index the strings
    
    // Find the length of the LCS
    // Do DP like regular
    for(int i = 1; i <= N; i++){
      for(int j = 1; j <= M; j++){
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        if(S.charAt(i) == T.charAt(j))
          dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j - 1]);
      }
    }
    
    // Trace the actual LCS string
    int i = N, j = M;
    String ans = "";
    while(i != 0 || j != 0){
      // If the letters match and we got the dp value from the dp[i - 1][j - 1]
      // Then we add the character to the LCS and trace at i - 1 and j - 1
      if(i >= 1 && j >= 1 && S.charAt(i) == T.charAt(j) && dp[i - 1][j - 1] + 1 == dp[i][j]){
        ans = S.charAt(i) + ans;
        --i; --j;
      }
      // If we got the value from dp[i - 1][j], then trace there next
      else if(i >= 1 && dp[i - 1][j] == dp[i][j])
        --i;
      // If we got the value from dp[i][j - 1], then trace there next
      else if(j >= 1 && dp[i][j - 1] == dp[i][j])
        --j;
    }
    
    System.out.println(ans);
  }
}