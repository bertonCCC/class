import java.io.*;

public class dwite07c3p1 {
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    for(int j = 0; j < 5; j++){
      int N = Integer.parseInt(in.readLine());
      int unq = 0;
      
      for(int i = 2; i * i <= N; i++){
        boolean isFactor = false;
        while(N % i == 0){
          isFactor = true;
          N /= i;
        }
        if(isFactor) ++unq;
      }
      if(N > 1) ++unq;
      
      if(unq == 3){
        System.out.println("valid");
      }
      else{
        System.out.println("not");
      }
    }
  }
}