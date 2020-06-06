import java.io.*;

public class template{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]);
    
    int[] arr = new int[N];
    long ans = 0;
    int[] freq = new int[1000 * 1000 + 1];
    int unique = 0;
    
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(tokens[i]);
    }
    
    right = -1;
    for(int left = 0; left < N; i++){
      while(right + 1 < N && unique < K){
        // add arr[right + 1]
        
      }
    }
  }
}