import java.io.*;

public class dmopc18c5p2{
  public static double average(int N, int M, double[][] values, double C){
    double total = 0.0;
    
    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        total += Math.min(1.0, values[i][j] * C);
      }
    }
    
    return total / N / M;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]);
    double[][] values = new double[N][M];
    
    for(int i = 0; i < N; i++){
      tokens = in.readLine().split(" ");
      for(int j = 0; j < M; j++){
        values[i][j] = Double.parseDouble(tokens[j]);
      }
    }
    
    double left = 0.0, right = 1000.0;
    
    while(right - left >= 0.000001){
      double mid = (left + right) / 2.0;
      
      double newAverage = average(N, M, values, mid);
      if(newAverage >= 0.48){
        right = mid;
      }
      else{
        left = mid;
      }
    }
    
    double ans = left;
    
    if(Math.abs(ans - 1) < 0.00001){
      System.out.println("correctly exposed");
      return;
    }
    else if(ans < 1){
      System.out.println("overexposed");
    }
    else{
      System.out.println("underexposed");
    }
    System.out.println(left);
  }
}