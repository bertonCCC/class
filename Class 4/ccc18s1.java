import java.io.*;
import java.util.*;

public class ccc18s1{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    Integer[] arr = new Integer[N];
    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(in.readLine());
    }
    Arrays.sort(arr);
    
    double minimum = 1e9;
    for(int i = 1; i < N - 1; i++){
      minimum = Math.min(minimum, (arr[i] - arr[i - 1] + arr[i + 1] - arr[i]) / 2.0);
    }
    System.out.printf("%.1f", minimum);
  }
}