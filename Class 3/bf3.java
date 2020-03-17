import java.io.*;
import java.util.*;

public class bf3{
  static boolean isPrime(int n){
    if(n <= 1) return false;
    for(int i = 2; i * i <= n; i++){
      if(n % i == 0) return false;
    }
    return true;
  }
  
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    
    while(true){
      if(isPrime(N)){
        break;
      }
      ++N;
    }

    System.out.println(N);
  }
}