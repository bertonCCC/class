import java.io.*;

public class ds3{
  static final int MAX = 100 * 1000 + 1, INF = 1000 * 1000 * 1000 + 1;
  static int[] arr = new int[MAX];
  static Segment[] seg = new Segment[MAX * 4];
  static final Segment ZERO = new Segment(INF, 0, 0);
                                            
  static void build(int cl, int cr, int p){
    if(cl == cr){
      Segment s = new Segment(arr[cl]);
      seg[p] = s;
    }
    else{
      int m = (cl + cr) / 2;
      build(cl, m, p * 2);
      build(m + 1, cr, p * 2 + 1);
      seg[p] = Segment.combine(seg[p * 2], seg[p * 2 + 1]);
    }
  }
  
  static void update(int i, int v, int cl, int cr, int p){
    if(cl == cr){
      seg[p] = new Segment(v);
    }
    else{
      int m = (cl + cr) / 2;
      if(i <= m)
        update(i, v, cl, m, p * 2);
      else
        update(i, v, m + 1, cr, p * 2 + 1);
      
      seg[p] = Segment.combine(seg[p * 2], seg[p * 2 + 1]);
    }
  }
  
  static Segment query(int l, int r, int cl, int cr, int p){
    if(cl > r || cr < l) return ZERO;
    else if(cl >= l && cr <= r) return seg[p];
    else{
      int m = (cl + cr) / 2;
      return Segment.combine(
                      query(l, r, cl, m, p * 2),
                      query(l, r, m + 1, cr, p * 2 + 1)
                     );
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), Q = Integer.parseInt(tokens[1]);
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++)
      arr[i + 1] = Integer.parseInt(tokens[i]);
    
    build(1, N, 1);
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      String q = tokens[0];
      int a = Integer.parseInt(tokens[1]), b = Integer.parseInt(tokens[2]);
      
      if(q.equals("C")){
        update(a, b, 1, N, 1);
      }
      else if(q.equals("M")){
        System.out.println(query(a, b, 1, N, 1).m);
      }
      else if(q.equals("G")){
        System.out.println(query(a, b, 1, N, 1).g);
      }
      else if(q.equals("Q")){
        System.out.println(query(a, b, 1, N, 1).n);
      }
    }
  }
}

class Segment{
  public int m, g, n;
  
  public Segment(int n){
    this.m = n;
    this.g = n;
    this.n = 1;
  }
  
  public Segment(int m, int g, int n){
    this.m = m;
    this.g = g;
    this.n = n;
  }
  
  static int gcd(int a, int b){
    if(a == 0) return b;
    return gcd(b % a, a);
  }
  
  public static Segment combine(Segment a, Segment b){
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
}