import java.io.*;
import java.util.*;

public class ccc19s2{
  static boolean isPrime(int n){
    if(n <= 1) return false;
    for(int i = 2; i * i <= n; i++){
      if(n % i == 0)
        return false;
    }
    return true;
  }
  
  static void solve(int N){
    for(int A = 2; A <= 2 * N; A++){
      int B = 2 * N - A;
      if(isPrime(A) && isPrime(B)){
        System.out.println(A + " " + B);
        return;
      }
    }
  }
  
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());
    for(int i = 0; i < T; i++){
      int N = Integer.parseInt(in.readLine());
      solve(N);
    }
  }
}