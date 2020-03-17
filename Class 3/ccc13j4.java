import java.io.*;
import java.util.*;

public class ccc13j4{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());
    int C = Integer.parseInt(in.readLine());
    
    Integer[] chores = new Integer[C];
    for(int i = 0; i < C; i++){
      chores[i] = Integer.parseInt(in.readLine());
    }
    
    Arrays.sort(chores);
    
    int sum = 0;
    int ans = 0;
    for(int i = 0; i < C; i++){
      if(sum + chores[i] <= T){
        ans += 1;
        sum += chores[i];
      }
      else{
        break;
      }
    }
    
    System.out.println(ans);
  }
}