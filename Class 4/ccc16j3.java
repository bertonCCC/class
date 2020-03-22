import java.io.*;
import java.util.*;

public class ccc16j3{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String str = in.readLine();
    
    int N = str.length();
    int longest = 1;
    for(int middle = 0; middle < N; middle++){
      int left = middle;
      int right = middle;
      int len = 1;
      while(
            left - 1 >= 0
              && right + 1 < N
              && str.charAt(left - 1) == str.charAt(right + 1)){
        len += 2;
        left -= 1;
        right += 1;
        longest = Math.max(longest, len);
      }
    }
    
    for(int middle = 0; middle < N - 1; middle++){
      int left = middle + 1;
      int right = middle;
      int len = 0;
      while(
            left - 1 >= 0
              && right + 1 < N
              && str.charAt(left - 1) == str.charAt(right + 1)){
        len += 2;
        left -= 1;
        right += 1;
        longest = Math.max(longest, len);
      }
    }
    
    System.out.println(longest);
  }
}