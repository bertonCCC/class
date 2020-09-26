import java.io.*;
import java.util.*;

public class ccc05s5{
  static final int MAX = 100 * 1000 + 1;
  static int[] fen = new int[MAX];
  
  static void add(int n){
    for(int i = n; i < MAX; i += i & -i){
      fen[i] += 1;// ++fen[i] or fen[i]++
    }
  }
  
  static int query(int n){
    int sum = 0;
    for(int i = n; i > 0; i -= i & -i){
      sum += fen[i];
    }
    return sum;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    int[] arr = new int[N];
    Integer[] sorted = new Integer[N];
    int[] unique = new int[N];
    
    for(int i = 0; i < N; i++){
      int n = Integer.parseInt(in.readLine());
      arr[i] = n;
      sorted[i] = n;
    }
    
    Arrays.sort(sorted);
    
    for(int i = 0; i < N; i++)
      unique[i] = 1 * 1000 * 1000 * 1000 + 1;
    
    int curIndex = 0;
    for(int i = 0; i < N; i++){
      if(i == 0 || sorted[i] > sorted[i - 1]){
        unique[curIndex] = sorted[i];
        curIndex += 1;
      }
    }
    
    for(int i = 0; i < N; i++){
      arr[i] = Arrays.binarySearch(sorted, arr[i]) + 1;
    }
    
    long total = 0;
    for(int i = 0; i < N; i++){
      int before = i - query(arr[i]);
      total += before + 1;
      add(arr[i]);
    }
    
    double ans = (double)total / N;
    System.out.printf("%.2f\n", Math.rint(ans * 100) / 100.0);
  }
}