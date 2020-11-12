import java.util.*;

public class dpi{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    double[] probs = new double[N + 1];
    double[][] dp = new double[N + 1][N + 1];
    // dp[m][n] is the chance of getting m heads after the first n coin flips
    
    for(int i = 1; i <= N; i++){
      probs[i] = in.nextDouble();
    }
    
    // Base case 1: The probability of getting 0 heads in first flip is 1 - probs[1]
    dp[0][1] = 1 - probs[1];
    // Base case 1: The probability of getting 1 head in first flip is probs[1]
    dp[1][1] = probs[1];
    
    for(int j = 2; j <= N; j++){
      for(int i = 0; i <= j; i++){
        // The chance of getting 0 heads in j coins is the chance of
        // 0 heads in j - 1 coins, times (1 - probs[j])
        if(i == 0) dp[i][j] = dp[i][j - 1] * (1 - probs[j]);
        // The chance of getting i > 0 heads in j coins is the chance of
        // i heads in j - 1 coins times (1 - probs[j])
        // plus i - 1 heads in j - 1 coins times probs[j]
        else dp[i][j] = dp[i][j - 1] * (1 - probs[j]) + dp[i - 1][j - 1] * probs[j];
      }
    }
    
    double ans = 0;
    for(int i = N / 2 + 1; i <= N; i++)
      ans += dp[i][N];
    System.out.printf("%.12f\n", ans);
  }
}