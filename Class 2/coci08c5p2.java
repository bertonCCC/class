import java.io.*;
import java.util.*;

public class coci08c5p2 {
  static int gcd(int a, int b){
    int res = 1;
    for(int i = 2; i * i <= a; i++){
      while(a % i == 0){
        if(b % i == 0){
          res *= i;
          b /= i;
        }
        a /= i;
      }
    }
    
    if(a > 1 && b % a == 0)
      res *= a;
    
    return res;
  }
  
  /* 
   Euclidean Implementation
   static int gcd(int a, int b){
     if(a == 0) return b;
     return gcd(b % a, a);
   }
   */
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int A = Integer.parseInt(tokens[0]);
    int B = Integer.parseInt(tokens[1]);
    
    int g = gcd(A, B);
    
    for(int i = 1; i * i <= g; i++){
      if(g % i == 0){
        System.out.println(i + " " + A/i + " " + B/i);
        if(i * i != g){
          System.out.println((g/i) + " " + A/(g/i) + " " + B/(g/i));
        }
      }
    }
  }
}