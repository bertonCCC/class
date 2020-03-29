import java.io.*;
import java.util.*;

public class ccc18s2{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    int[][] arr = new int[N][N], arr2 = new int[N][N];
    
    for(int i = 0; i < N; i++){
      String[] tokens = in.readLine().split(" ");
      for(int j = 0; j < N; j++){
        arr[i][j] = Integer.parseInt(tokens[j]);
      }
    }
    
    while(arr[0][0] > arr[0][1] || arr[0][0] > arr[1][0]){
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
          arr2[j][N - i - 1] = arr[i][j];
        }
      }
      
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
          arr[i][j] = arr2[i][j];
        }
      }
    }
    
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}