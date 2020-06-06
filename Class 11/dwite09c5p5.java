import java.io.*;

public class dwite09c5p5{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    for(int i = 0; i < 5; i++){
      int N = Integer.parseInt(in.readLine());
      for(int a = 65; a <= 90; a++){
         for(int b = 65; b <= 90; b++){
            for(int c = 65; c <= 90; c++){
               for(int d = 65; d <= 90; d++){
                 int k = a * 1000 * 1000 + b * 10 * 1000 + c * 100 + d;
                 int m = a * 11 + b * 101 + c * 1009 + d * 10007;
                 
                 if(k % m == N){
                   System.out.print((char) a);
                   System.out.print((char) b);
                   System.out.print((char) c);
                   System.out.print((char) d);
                   System.out.println();
                   break;
                 }
               }
            }
         }
      }
    }
  }
}