import java.io.*;

public class vmss7wc16c4p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int D = Integer.parseInt(tokens[0]), I = Integer.parseInt(tokens[1]), R = Integer.parseInt(tokens[2]);
    tokens = in.readLine().split(" ");
    String strA = " " + tokens[0];
    String strB = " " + tokens[1];
    // 1-index the strings for convenience
    
    int N = strA.length(), M = strB.length();
    int[][] dp = new int[N][M];
    // dp[n][m] is the min. cost to transform the first n chars of A to the 
    // first m chars of B
    
    // Base case 1: If we transform to the first 0 chars of B (empty string),
    // the best thing to do is delete
    for(int n = 0; n < N; n++)
      dp[n][0] = n * D;
    
    // Base case 2: We can only insert from the first 0 chars of A
    for(int m = 0; m < M; m++)
      dp[0][m] = m * I;
    
    // The base cases let us not start at n = 1, m = 1 and not worry about
    // index out of bounds
    for(int n = 1; n < N; n++){
      for(int m = 1; m < M; m++){
        // n-th char from A and m-th char from B match, so copy over the cost from dp[n - 1][m - 1]
        if(strA.charAt(n) == strB.charAt(m)){
          dp[n][m] = dp[n - 1][m - 1];
        }
        else{
          dp[n][m] = min(
                         dp[n - 1][m]     + D, // delete n-th char from A
                         dp[n][m - 1]     + I, // insert a char to create m-th char from B
                         dp[n - 1][m - 1] + R  // replace n-th char from A with m-th char from B
                        );
        }
        
      }
    }
    
    System.out.println(dp[N - 1][M - 1]);
  }
  
  static int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
  }
}