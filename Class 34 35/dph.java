import java.io.*;

public class dph{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int H = Integer.parseInt(tokens[0]), W = Integer.parseInt(tokens[1]);
    char[][] grid = new char[H][];
    int[][] dp = new int[H][W];
    // dp[h][w] is the number of ways to reach (h, w) from (1, 1)
    
    for(int i = 0; i < H; i++)
      grid[i] = in.readLine().toCharArray();
    
    final int MOD = 1000 * 1000 * 1000 + 7;
    dp[0][0] = 1;
    // Base case: The number of ways to get from (1, 1) to (1, 1) is 1
    // Note that the array is 0-indexed so it's dp[0][0]
    
    for(int h = 0; h < H; h++){
      for(int w = 0; w < W; w++){
        // If we're at a wall, the dp value stays at 0
        if(grid[h][w] == '#') continue;
        
        // Add the values to the cell above and left, if they exist
        // We can get rid of the if statements by 1-indexing
        if(h > 0) dp[h][w] = (dp[h][w] + dp[h - 1][w]) % MOD;
        if(w > 0) dp[h][w] = (dp[h][w] + dp[h][w - 1]) % MOD;
        
        // The intermediate values are at most 2 * MOD - 1 < MAX_INT
        // so we can use ints without fearing overflow
      }
    }
    
    System.out.println(dp[H - 1][W - 1]);
  }
}