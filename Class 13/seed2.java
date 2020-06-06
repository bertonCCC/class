 import java.io.*;

public class seed2{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    long left = 1, right = 2 * 1000 * 1000 * 1000, mid;
    while(true){
      mid = (left + right) / 2;

      System.out.println(mid);
      System.out.flush();
      
      String result = in.readLine();
      if(result.equals("FLOATS")){
        right = mid - 1;
      }
      if(result.equals("SINKS")){
        left = mid + 1;
      }
      if(result.equals("OK")){
        break;
      }
    }
  }
}