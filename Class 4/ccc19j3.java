import java.io.*;
import java.util.*;

public class ccc19j3{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    
    for(int q = 0; q < N; q++){
      String str = in.readLine();
      int runLen = 0;
      
      for(int i = 0; i < str.length(); i++){
        if(i > 0 && str.charAt(i) != str.charAt(i - 1)){
          System.out.print(runLen + " " + str.charAt(i - 1) + " ");
          runLen = 0;
        }
        
        runLen += 1;
      }
      
      System.out.println(runLen + " " + str.charAt(str.length() - 1));
    }
  }
}