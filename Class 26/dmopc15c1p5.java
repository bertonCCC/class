import java.io.*;
import java.util.*;

public class dmopc15c1p5{
  static int[][] arr = new int[251][251];
  static int[][] psa = new int[251][251];
  
  static int subrec(int i1, int j1, int i2, int j2){
    return psa[i2][j2]
      - psa[i1 - 1][j2]
      - psa[i2][j1 - 1]
      + psa[i1 - 1][j1 - 1];
    // Standard 2D PSA subrectangle sum
  }
  
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
    
    int C = in.nextInt(), R = in.nextInt(), K = in.nextInt();
    // rows, columns, maximum rectangle size
 
    for(int i = 1; i <= R; i++){
      for(int j = 1; j <= C; j++){
        arr[i][j] = in.nextInt();
        psa[i][j] = psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + arr[i][j];
        // Standard 2D PSA construction
      }
    }
    
    int best = 0;
    for(int width = 1; width <= Math.min(K, C); width++){
      int height = Math.min(K / width, R);
      // Array values are non-negative, so height should be taken as max
      // such that H * W <= N, which means H = floor(K / W)
      
      for(int i = 1; i + height - 1 <= R; i++){
        for(int j = 1; j + width - 1 <= C; j++){
          int sum = subrec(i, j, i + height - 1, j + width - 1);
          best = Math.max(best, sum);
        }
      }
    }
    
    System.out.println(best);
  }
}