import java.io.*;

public class dp1p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    int[] arr = new int[N + 1];
    int[] dp  = new int[N + 1];
    
    for(int i = 1; i <= N; i++)
      arr[i] = Integer.parseInt(in.readLine());
    
    for(int i = 1; i <= N; i++)
      dp[i] = 1;
    
    for(int n = 1; n <= N; n++){
      for(int m = 1; m < n; m++){
        if(arr[m] < arr[n])
          dp[n] = Math.max(dp[n], dp[m] + 1);
      }
    }
    
    int ans = 0;
    for(int n = 1; n <= N; n++)
      ans = Math.max(ans, dp[n]);
    System.out.println(ans);
  }
}