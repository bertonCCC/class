import java.io.*;

public class ecoo18r2p3{
  public static boolean ok(int N, int K, int M){
    // is N! divisible by K^M?
    
    // factorize K to prime powers
    int cur = K;
    int min = 2 * 1000 * 1000;
    for(int p = 2; p * p <= K; p++){
      if(cur % p == 0){
        int exp = 0;
        while(cur % p == 0){
          cur /= p;
          exp += 1;
        }
        // (K/p + K/p^2 + K/p^3 + ...) / exp
        int denom = p;
        int sum = 0;
        while(denom <= K){
          sum += K / denom;
          denom *= p;
        }
        
        sum /= exp;
        min = Math.min(min, sum);
      }
    }
    
    return min >= M;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    
  }
}