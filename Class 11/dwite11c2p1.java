import java.io.*;

public class dwite11c2p1{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    for(int j = 0; j < 5; j++){
      int N = Integer.parseInt(in.readLine());
      
      int right = 0;
      int down = 0;
      int remain = N;

      for(int i = 1; ; i++){
        if(i >= remain){
          if((i & 1) == 1){ // i % 2 == 0
            right += remain;
          }
          else{
            down += remain;
          }
          break;
        }
        else{
          if((i & 1) == 1){
            right += i;
          }
          else{
            down += i;
          }
          remain -= i;
        }
      }
      
      System.out.println(right + " -" + down);
    }
  }
}