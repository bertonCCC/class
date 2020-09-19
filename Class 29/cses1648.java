import java.io.*;

public class cses1648{
  static final int MAXN = 200 * 1000 + 1;
  static int[] arr = new int[MAXN];
  static long[] fen = new long[MAXN];
  
  static void update(int n, int v){
    int diff = v - arr[n];
    for(int i = n; i < MAXN; i += i & -i){
      fen[i] += diff;
    }
    arr[n] = v;
  }
  
  static long prefix(int n){
    long sum = 0;
    for(int i = n; i > 0; i -= i & -i){
      sum += fen[i];
    }
    return sum;
  }
  
  static long query(int l, int r){
    return prefix(r) - prefix(l - 1);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), Q = Integer.parseInt(tokens[1]);
    
    tokens = in.readLine().split(" ");
    for(int i = 1; i <= N; i++){
      int v = Integer.parseInt(tokens[i - 1]);
      update(i, v);
    }
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      int q = Integer.parseInt(tokens[0]),
        a = Integer.parseInt(tokens[1]),
        b = Integer.parseInt(tokens[2]);
      
      if(q == 1) update(a, b);
      else System.out.print(query(a, b) + "\n");
    }
  }
}