import java.io.*;

public class dmopc16c1p5{
  static final int MAXN = 500 * 1000 + 1;
  static int[] freqfen = new int[MAXN];
  
  static void add(int n){
    for(int i = n; i < MAXN; i += i & -i)
      freqfen[i] += 1;
  }
  
  static int query(int n){
    int sum = 0;
    for(int i = n; i > 0; i -= i & -i)
      sum += freqfen[i];
    return sum;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    int[] arr = new int[N];
    String[] tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(tokens[i]);
    }
    
    long ans = 0;
    for(int i = 0; i < N; i++){
      int less = query(arr[i]);
      int more = i - less;
      
      ans += Math.min(less, more);
      
      add(arr[i]);
    }
    
    System.out.println(ans);
  }
}