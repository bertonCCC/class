import java.io.*;

public class ds3{
  static final int MAX = 100 * 1000 + 1, INF = 1000 * 1000 * 1000 + 1;
  static int[] arr = new int[MAX];
  static Segment[] seg = new Segment[MAX * 2];
  static final Segment ZERO = new Segment(INF, 0, 0);
  static int N;
  
  static int gcd(int a, int b){
    if(a == 0) return b;
    return gcd(b % a, a);
  }
  
  static Segment combine(Segment a, Segment b){
    int g = gcd(a.g, b.g);
    int num = 0;
    if(g == a.g) num += a.n;
    if(g == b.g) num += b.n;
    
    return new Segment(
                       Math.min(a.m, b.m),
                       gcd(a.g, b.g),
                       num
                      );
  }
  
  static Segment init(int n){
    return new Segment(n, n, 1);
  }
    
  static void build(){
    for(int i = 0; i < N; i++)
      seg[i + N] = init(arr[i]);
    for(int i = N - 1; i > 0; i--)
      seg[i] = combine(seg[i * 2], seg[i * 2 + 1]);
  }
  
  static void update(int index, int value){
    seg[index + N] = init(value);
    for(int i = (index + N) / 2; i > 0; i /= 2)
      seg[i] = combine(seg[i * 2], seg[i * 2 + 1]);
  }
  
  static Segment query(int left, int right){
    Segment result = ZERO;
    left += N;
    right += N + 1;
    while(left < right){
      //System.out.println(left + " " + right);
      if(left % 2 == 1) result = combine(result, seg[left++]);
      if(right % 2 == 1) result = combine(result, seg[--right]);
      left /= 2;
      right /= 2;
    }
    return result;

    /*
    Alternate less readable for-loop:
    for(left += N, right += N + 1; left < right; left /= 2, right /= 2)
    */
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    N = Integer.parseInt(tokens[0]);
    int Q = Integer.parseInt(tokens[1]);
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(tokens[i]);
    
    build();
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      String q = tokens[0];
      int a = Integer.parseInt(tokens[1]), b = Integer.parseInt(tokens[2]);
      
      // We subtract 1 from indexes because an iterative segment
      // tree must be 0-indexed and the problem is 1-indexed
      if(q.equals("C")){
        update(a - 1, b);
      }
      else if(q.equals("M")){
        System.out.println(query(a - 1, b - 1).m);
      }
      else if(q.equals("G")){
        System.out.println(query(a - 1, b - 1).g);
      }
      else if(q.equals("Q")){
        System.out.println(query(a - 1, b - 1).n);
      }
    }
  }
}

class Segment{
  public int m, g, n;
  
  public Segment(int m, int g, int n){
    this.m = m;
    this.g = g;
    this.n = n;
  }
}