import java.io.*;

public class dpk{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]);
    int[] arr = new int[N];
    boolean[] dp = new boolean[K + 1];
    // dp[k] is true if the next player to move having k stones left is winning
    // false if losing
    
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(tokens[i]);
    
    dp[0] = false;
    
    for(int k = 1; k <= K; k++){
      dp[k] = false; // assume the position is losing
      for(int i = 0; i < N; i++){
        int move = k - arr[i];
        
        if(move < 0) continue;
        // not enough stones to make this move
        if(dp[move] == false) dp[k] = true;
        // if making a move would make the other player lose, then
        // the position is winning
      }
    }
    
    if(dp[K]) System.out.println("First");
    else System.out.println("Second");
  }
}