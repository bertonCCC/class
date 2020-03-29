import java.io.*;
import java.util.*;

public class coci19c5p1{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] tokens = in.readLine().split(" ");
    int R = Integer.parseInt(tokens[0]);
    int C = Integer.parseInt(tokens[1]);
    char[][] grid = new char[R][C];
    
    for(int r = 0; r < R; r++){
      String temp = in.readLine();
      for(int c = 0; c < C; c++){
        grid[r][c] = temp.charAt(c);
      }
    }
    
    int ans = 0;
    for(int r = 0; r < R; r++){
      for(int c = 0; c < C; c++){
        if(grid[r][c] == '*'){
          ans += 1;
          
          int r2 = r;
          int c2 = c;
          while(r2 + 1 < R && grid[r2 + 1][c] == '*'){
            r2 += 1;
          }
          while(c2 + 1 < C && grid[r][c2 + 1] == '*'){
            c2 += 1;
          }
         
          for(int rr = r; rr <= r2; rr++){
            for(int cc = c; cc <= c2; cc++){
              grid[rr][cc] = '.';
            }
          }
        }
      }
    }
    
    System.out.println(ans);
  }
}