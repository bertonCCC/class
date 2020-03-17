import java.io.*;

public class p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String temp = in.readLine();
    int N = Integer.parseInt(temp);
    
    for(int i = 0; i < N; i++){
      temp = in.readLine();
      int num = Integer.parseInt(temp);
      
      int sum = 1;
          
      for(int j = 2; j * j <= num; j++){
        if(num % j == 0){
          sum += j;
          if(j * j != num) sum += num / j;
        }
      }
      
      String numType;
      if(sum < num) numType = "a deficient";
      else if(sum == num) numType = "a perfect";
      else numType = "an abundant";
      
      System.out.println("" + num + " is " + numType + " number.");
    }
  }
}