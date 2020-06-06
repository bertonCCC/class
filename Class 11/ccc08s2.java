import java.io.*;

public class ccc08s2{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    while(true){
      int R = Integer.parseInt(in.readLine());
      if(R == 0) break;
      int R2 = R*R;
      int sum = 0;
      
      for(int x = -R; x <= R; x++){
        int y = (int) Math.floor(Math.sqrt(R2 - x * x));
        sum += y - (-y) + 1;
      }
      
      System.out.println(sum);
    }
  }
}