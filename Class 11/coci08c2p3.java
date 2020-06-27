import java.io.*;

public class coci08c2p3{
  static int N;
  static int[] bit, sour;
  static int ans = 2 * 1000 * 1000 * 1000;
  
  static void rec(int index, int sum, int product, boolean taken){
    if(index == N){
      if(!taken) return;
      
      ans = Math.min(ans, Math.abs(sum - product));
      return;
    }
    
    rec(index + 1, sum + bit[index], product * sour[index], true);
    rec(index + 1, sum, product, taken);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(in.readLine());
    bit = new int[N]; sour = new int[N];
    
    String[] tokens;
    for(int i = 0; i < N; i++){
      tokens = in.readLine().split(" ");
      sour[i] = Integer.parseInt(tokens[0]);
      bit[i]  = Integer.parseInt(tokens[1]);
    }
    
    rec(0, 0, 1, false);
    
    System.out.println(ans);
  }
}