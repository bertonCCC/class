import java.io.*;

public class ccc02s2{
  static int gcd(int a, int b){
    int m = Math.min(a, b);
    for(int i = m; i >= 1; i--){
      if(a % i == 0 && b % i == 0){
        return i;
      }
    }
    return -1;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int num = Integer.parseInt(in.readLine());
    int denom = Integer.parseInt(in.readLine());
    
    int whole = num / denom;
    int rem = num % denom;
    int g = gcd(rem, denom);
    
    rem /= g;
    denom /= g;
    
    if(whole == 0){
      if(rem == 0){
        System.out.println(0);
      }
      else{
        System.out.println(rem + "/" + denom);
      }
    }
    else{
      if(rem == 0){
        System.out.println(whole);
      }
      else{
        System.out.println(whole + " " + rem + "/" + denom);
      }
    }
  }
}