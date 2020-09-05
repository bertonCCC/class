import java.io.*;

public class cses1643{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    int[] arr = new int[N + 1];
    long[] psa = new long[N + 1];
    
    String[] tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++){
      arr[i + 1] = Integer.parseInt(tokens[i]);
    }
    
    for(int i = 1; i <= N; i++){
      psa[i] = psa[i - 1] + arr[i];
    }
    
    long INF = 1L * 1000 * 1000 * 1000 * 1000 * 1000;
    long minPsa = INF;
    long answer = -INF;
    
    for(int i = 0; i <= N; i++){
      answer = Math.max(answer, psa[i] - minPsa);
      minPsa = Math.min(minPsa, psa[i]);
    }
    
    System.out.println(answer);
  }
}