import java.io.*;

public class p6{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    
    int N = Integer.parseInt(in.readLine());
    int[] masses = new int[N + 1];
    int[] psa = new int[N + 1];
    
    for(int i = 1; i <= N; i++){
      masses[i] = Integer.parseInt(in.readLine());
      psa[i] = psa[i - 1] + masses[i];
    }
    
    int Q = Integer.parseInt(in.readLine());
    for(int i = 0; i < Q; i++){
      String[] tmp = in.readLine().split(" ");
      int left = Integer.parseInt(tmp[0]), right = Integer.parseInt(tmp[1]);
      left += 1;
      right += 1;
      
      System.out.println(psa[right] - psa[left - 1]);
    }
  }
}