import java.io.*;
import java.util.*;

public class dwite08c4p2{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    char[][] grid = new char[3][3];
    
    for(int t = 0; t < 5; t++){
      for(int r = 0; r < 3; r++){
        String line = in.readLine();
        for(int c = 0; c < 3; c++){
          grid[r][c] = line.charAt(c);
        }
      }
      
      boolean found = false;
      for(int r = 0; r < 3; r++){
        if(!found && grid[r][0] != '.' && grid[r][0] == grid[r][1] && grid[r][1] == grid[r][2]){
          System.out.println(grid[r][0]);
          found = true;
        }
      }
      
      for(int c = 0; c < 3; c++){
        if(!found && grid[0][c] != '.' && grid[0][c] == grid[1][c] && grid[1][c] == grid[2][c]){
          System.out.println(grid[0][c]);
          found = true;
        }
      }
      
      if(!found && grid[0][0] != '.' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]){
        System.out.println(grid[0][0]);
        found = true;
      }
      
      if(!found && grid[0][2] != '.' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]){
        System.out.println(grid[0][2]);
        found = true;
      }
      
      if(!found){
        System.out.println('.');
      }
    }
  }
}