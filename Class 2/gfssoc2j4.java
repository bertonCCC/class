import java.io.*;

public class gfssoc2j4 {
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]);
    int Q = Integer.parseInt(tokens[1]);
    tokens = in.readLine().split(" ");
    int[] arr = new int[N + 1];
    int[] psa = new int[N + 1];
    for(int i = 1; i <= N; i++)
      arr[i] = Integer.parseInt(tokens[i - 1]);
    for(int i = 1; i <= N; i++)
      psa[i] = psa[i - 1] + arr[i];
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      int a = Integer.parseInt(tokens[0]);
      int b = Integer.parseInt(tokens[1]);
      System.out.println(psa[N] - (psa[b] - psa[a - 1]));
    }
  }
}