import java.io.*;

public class ds1{
  static final int MAXN = 100 * 1000 + 1;
  static int[] arr = new int[MAXN];
  static long[] fen = new long[MAXN];
  static int[] freqfen = new int[MAXN];
  
  static void update(int n, int v){
    int diff = v - arr[n];
    for(int i = n; i < MAXN; i += i & -i)
      fen[i] += diff;
    
    for(int i = v; i < MAXN; i += i & -i)
      freqfen[i] += 1;
    
    if(arr[n] != 0){
      for(int i = arr[n]; i < MAXN; i += i & -i){
        freqfen[i] -= 1;
      }
    }
    
    arr[n] = v;
  }
  
  static long sum(int l, int r){
    long sum = 0;
    for(int i = r; i > 0; i -= i & -i)
      sum += fen[i];
    
    for(int i = l - 1; i > 0; i -= i & -i)
      sum -= fen[i];
    
    return sum;
  }
  
  static int freqpre(int n){
    int sum = 0;
    for(int i = n; i > 0; i -= i & -i)
      sum += freqfen[i];
    
    return sum;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    
    int N = Integer.parseInt(tokens[0]), 
      Q = Integer.parseInt(tokens[1]);
    
    tokens = in.readLine().split(" ");
    for(int i = 1; i <= N; i++){
      int v = Integer.parseInt(tokens[i - 1]);
      update(i, v);
    }
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
                         
      if(tokens[0].equals("C")){
        int x = Integer.parseInt(tokens[1]),
          v = Integer.parseInt(tokens[2]);
        update(x, v);
      }
      else if(tokens[0].equals("S")){
        int l = Integer.parseInt(tokens[1]),
          r = Integer.parseInt(tokens[2]);
        
        System.out.println(sum(l, r));
      }
      else{
        int v = Integer.parseInt(tokens[1]);
        System.out.println(freqpre(v));
      }
    }
  }
}