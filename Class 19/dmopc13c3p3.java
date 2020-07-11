import java.io.*;
import java.util.*;

public class dmopc13c3p3{
  static boolean[][] vist;
  static boolean found = false;
  static int N, H;
  static int[][] grid;
  static int[] xdiff = {-1, +1, 0, 0};
  static int[] ydiff = {0, 0, -1, +1};
  
  static void dfs(int row, int col){
    vist[row][col] = true;
    if(row == N - 1 && col == N - 1) found = true;
    
    for(int i = 0; i < 4; i++){
      int newrow = row + xdiff[i];
      int newcol = col + ydiff[i];
      
      if(newrow >= 0 && newrow < N && newcol >= 0 && newcol < N
           && !vist[newrow][newcol] && Math.abs(grid[row][col] - grid[newrow][newcol]) <= H)
        dfs(newrow, newcol);
    }
  }
  
  public static void main(String[] args) throws IOException{
    //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner in = new Scanner(System.in);
    
    N = in.nextInt();
    H = in.nextInt();
    grid = new int[N][N]; // 0-indexed
    vist = new boolean[N][N];
    
    for(int i = 0; i < N; i++)
      for(int j = 0; j < N; j++)
      grid[i][j] = in.nextInt();
    
    dfs(0, 0);
    
    if(found) System.out.println("yes");
    else System.out.println("no");
    
    //System.out.println(found ? "yes" : "no");
  }
}