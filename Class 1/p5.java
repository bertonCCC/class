import java.io.*;

public class p5{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());
    
    int[] cars = new int[100000];
    int[] branch = new int[100000];
    
    for(int t = 0; t < T; t++){
      int ptr = 0, count = 1;
      
      int N = Integer.parseInt(in.readLine());
      for(int i = 0; i < N; i++)
        cars[i] = Integer.parseInt(in.readLine());
      
      for(int i = N - 1; i >= 0; i--){
        int cur = cars[i];
        
        if(cur == count){
          count += 1;
          continue;
        }
        
        while(ptr > 0 && branch[ptr - 1] == count){
          ptr -= 1;
          count += 1;
        }
        
        branch[ptr] = cur;
        ptr += 1;
      }
      
      while(ptr > 0 && branch[ptr - 1] == count){
        ptr -= 1;
        count += 1;
      }
      
      if(ptr > 0) System.out.println("N");
      else System.out.println("Y");
    }
  }
}