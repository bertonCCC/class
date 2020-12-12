import java.io.*;

public class bf2hard{
  static final int SIZE = 1000 * 1000, BASE = 123456, MOD = 1000 * 1000 * 1000 + 7;
  static long[] hash = new long[SIZE]; // hash prefixes
  static long[] pow = new long[SIZE]; // pow[i] = BASE ^ i % MOD
  static String S;
  static int N, K;
  
  static long sub(int left, int right){
    if(left == 0) return hash[right];
    long tmp = (hash[right] - hash[left - 1] * pow[right - left + 1]) % MOD;
    return tmp < 0 ? tmp + MOD : tmp;
  }
  
  static boolean less(int ind1, int ind2){
    int left = 0, right = K, mid = 0;
    // binary search on LCP
    
    while(left < right){
      mid = (left + right + 1) / 2;
      if(sub(ind1, ind1 + mid - 1) == sub(ind2, ind2 + mid - 1))
        left = mid;
      else
        right = mid - 1;
    }
    
    int lcp = left; // left == right
    // next character after LCP is the first place they differ
    // which is ind1 + lcp and ind2 + lcp
    if(ind1 + lcp >= N || ind2 + lcp >= N)
      return false;
    else return S.charAt(ind1 + lcp) < S.charAt(ind2 + lcp);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    S = in.readLine();
    
    N = S.length();
    K = Integer.parseInt(in.readLine());
    
    hash[0] = S.charAt(0);
    pow[0] = 1;
    
    for(int i = 1; i < N; i++){
      hash[i] = (hash[i - 1] * BASE + S.charAt(i)) % MOD;
      pow[i] = pow[i - 1] * BASE % MOD;
    }
    
    int ansInd = 0;
    for(int i = 1; i <= N - K; i++){
      if(less(i, ansInd))
        ansInd = i;
    }
    
    System.out.println(S.substring(ansInd, ansInd + K));
  }
}