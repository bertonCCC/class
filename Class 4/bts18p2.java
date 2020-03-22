import java.io.*;
import java.util.*;

public class bts18p2{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String str = in.readLine();
    
    int[][] psa = new int[26][str.length() + 1];
    for(int i = 1; i <= str.length(); i++){
      char ch = str.charAt(i - 1);
      int index = (int)(ch) - (int)'a';
      
      for(int j = 0; j < 26; j++){
        psa[j][i] = psa[j][i - 1];
        if(j == index) psa[j][i] += 1;
      }
    }
    
    int Q = Integer.parseInt(in.readLine());
    for(int i = 0; i < Q; i++){
      String[] tokens = in.readLine().split(" ");
      int left = Integer.parseInt(tokens[0]);
      int right = Integer.parseInt(tokens[1]);
      char ch = tokens[2].charAt(0);
      
      int index = (int)ch - (int)'a';
      
      System.out.println(psa[index][right] - psa[index][left - 1]);
    }
  }
}