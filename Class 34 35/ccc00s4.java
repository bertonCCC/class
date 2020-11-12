import java.io.*;

public class ccc00s4{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int D = Integer.parseInt(in.readLine());
    int N = Integer.parseInt(in.readLine());
    int[] clubs = new int[100];
    int[] dp = new int[5281];
    // dp[d] is the minimum number of strokes to reach a distance of d
    
    for(int i = 0; i < N; i++){
      clubs[i] = Integer.parseInt(in.readLine());
    }
    
    final int INF = 1000 * 1000 * 1000;
    
    // Base case: If d = 0, we can reach distance d with 0 strokes
    // Otherwise, it's impossible until we otherwise find out later
    for(int d = 1; d <= D; d++)
      dp[d] = INF;
    
    // Otherwise, for each distance, for each club, if we use the club on the distance before
    // that would bring us to the current distance is achievable, it's a candidate for the minimum
    // value of dp[d]
    for(int d = 1; d <= D; d++){
      for(int n = 0; n < N; n++){
        int clubDist = clubs[n];
        if(d - clubDist >= 0)
          dp[d] = Math.min(dp[d], dp[d - clubDist] + 1);
      }
    }
    
    if(dp[D] == INF) System.out.println("Roberta acknowledges defeat.");
    else System.out.println("Roberta wins in " + dp[D] + " strokes.");
  }
}