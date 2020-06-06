import java.io.*;
import java.util.*;

public class dmopc16c4p2{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int B = Integer.parseInt(in.readLine());
    
    int[] start = new int[B];
    int[] end = new int[B];
    int[] points = new int[B];
    
    for(int i = 0; i < B; i++){
      String[] tokens = in.readLine().split(" ");
      start[i] = Integer.parseInt(tokens[0]);
      end[i] = Integer.parseInt(tokens[1]);
      points[i] = Integer.parseInt(tokens[2]);
    }
    
    int F = Integer.parseInt(in.readLine());
    Integer[] failed = new Integer[F];
    for(int i = 0; i < F; i++)
      failed[i] = Integer.parseInt(in.readLine());
    
    Arrays.sort(failed);
    
    int sum = 0;
    
    for(int i = 0; i < B; i++){
      int target = start[i];
      
      int left = 0, right = F, mid;
      while(left < right){
        mid = (left + right) / 2;
        
        if(failed[mid] >= target){
          right = mid;
        }
        else{
          left = mid + 1;
        }
      }
      
      // if binary search has F, it's past the end
      if(left == F || failed[left] > end[i]){
        sum += points[i];
      }
    }
    
    System.out.println(sum);
  }
}