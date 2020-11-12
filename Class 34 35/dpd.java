import java.util.*;

public class dpd {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int W = in.nextInt();
    
    int[] weights = new int[N + 1];
    int[] values  = new int[N + 1];
    long[] dpOld = new long[W + 1];
    long[] dpNew = new long[W + 1];
    
    for(int i = 1; i <= N; i++){
      weights[i] = in.nextInt();
      values[i]  = in.nextInt();
    }
    
    for(int n = 1; n <= N; n++){
      for(int w = 0; w <= W; w++){
        if(weights[n] > w)
          dpNew[w] = dpOld[w];
        else
          dpNew[w] = Math.max(dpOld[w], dpOld[w - weights[n]] + values[n]);
      }
      
      for(int w = 0; w <= W; w++)
        dpOld[w] = dpNew[w];
    }
    
    System.out.println(dpNew[W]);
  }
}