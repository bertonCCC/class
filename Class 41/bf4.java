import java.io.*;

public class bf4{
  final static int SIZE = 1000 * 1000;
  final static int MOD1 = 1000 * 1000 * 1000 + 7;
  final static int BASE1 = 123456;
  final static int MOD2 = 1000 * 1000 * 1000 + 9;
  final static int BASE2 = 234567;
  static long[] hash1 = new long[SIZE]; // prefix hashes of S
  static long[] pow1 = new long[SIZE]; // powers of BASE
  static long[] hash2 = new long[SIZE]; // prefix hashes of S
  static long[] pow2 = new long[SIZE]; // powers of BASE
  
  static long ret1, ret2;
  static void substring(int left, int right){
    if(left == 0){
      ret1 = hash1[right];
      ret2 = hash2[right];
    }
    else{
      ret1 = ((hash1[right] - hash1[left - 1] * pow1[right - left + 1]) % MOD1 + MOD1) % MOD1;
      ret2 = ((hash2[right] - hash2[left - 1] * pow2[right - left + 1]) % MOD2 + MOD2) % MOD2;
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String S = in.readLine();
    String T = in.readLine();
    
    int N = S.length(), M = T.length();
    
    hash1[0] = S.charAt(0);
    pow1[0] = 1;
    hash2[0] = S.charAt(0);
    pow2[0] = 1;
    
    for(int i = 1; i < N; i++){
      hash1[i] = (hash1[i - 1] * BASE1 + S.charAt(i)) % MOD1;
      pow1[i] = (pow1[i - 1] * BASE1) % MOD1;
      hash2[i] = (hash2[i - 1] * BASE2 + S.charAt(i)) % MOD2;
      pow2[i] = (pow2[i - 1] * BASE2) % MOD2;
    }
    
    long tHash1 = 0;
    long tHash2 = 0;
    
    for(int i = 0; i < M; i++){
      tHash1 = (tHash1 * BASE1 + T.charAt(i)) % MOD1;
      tHash2 = (tHash2 * BASE2 + T.charAt(i)) % MOD2;
    }

    for(int i = 0; i + M <= N; i++){
      substring(i, i + M - 1); // loads into ret1, ret2
      if(ret1 == tHash1 && ret2 == tHash2){
        System.out.println(i);
        return;
      }
    }
    
    System.out.println(-1);
  }
}