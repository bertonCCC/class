import java.io.*;

public class seed3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    int K = Integer.parseInt(in.readLine());
    int Q = Integer.parseInt(in.readLine());
    
    int[] arr = new int[N + 2];
    int[] psa = new int[N + 2];
    
    String[] tokens;
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      int left = Integer.parseInt(tokens[0]),
        right = Integer.parseInt(tokens[1]),
        troops = Integer.parseInt(tokens[2]);
      
      arr[left] += troops;
      arr[right + 1] -= troops;
    }
    
    for(int i = 1; i <= N; i++)
      psa[i] = psa[i - 1] + arr[i];
    
    int ans = 0;
    for(int i = 1; i <= N; i++){
      if(psa[i] < K) ans += 1;
    }
    
    System.out.println(ans);
  }
}