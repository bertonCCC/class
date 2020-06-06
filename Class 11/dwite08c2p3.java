import java.io.*;

public class dwite08c2p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    for(int i = 0; i < 5; i++){
      int ans = 1000000000;
      int N = Integer.parseInt(in.readLine());
      
      for(int a = 1; a <= N; a++){
        if(N % a == 0){
          int rest = N/a;
          for(int b = 1; b * b <= N/a; b++){
            if(rest % b == 0){
              int c = N/a/b;
              ans = Math.min(ans, 2 * (a*b + a*c + b*c));
            }
          }
        }
      }
      
      System.out.println(ans);
    }
  }
}