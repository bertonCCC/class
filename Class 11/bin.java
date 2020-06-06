import java.io.*;

public class bin{
  public static boolean ok(long N, long x){
    return ( x * (x + 1) / 2 <= N );
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    long N = Long.parseLong(in.readLine());
    
    long left = 0, right = N, mid;
    while(left < right){
      mid = (left + right + 1) / 2;
      
      if(ok(N, mid)){
        left = mid;
      }
      else{
        right = mid - 1;
      }
    }
    
    System.out.println(left); // mid might not be the answer
  }
}