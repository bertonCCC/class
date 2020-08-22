import java.io.*;
import java.util.*;

public class dmopc14c2p4{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(in.readLine());
    int[] arr = new int[N + 1];
    int[] psa = new int[N + 1];
    
    for(int i = 1; i <= N; i++){
      arr[i] = Integer.parseInt(in.readLine());
      psa[i] = arr[i] + psa[i - 1];
    }
    
    int Q = Integer.parseInt(in.readLine());
    for(int i = 0; i < Q; i++){
      String[] tokens = in.readLine().split(" ");
      int left = Integer.parseInt(tokens[0]), right = Integer.parseInt(tokens[1]);
      left += 1; right += 1;
      System.out.println(psa[right] - psa[left - 1]);
    }
  }
}
