import java.io.*;

public class cses1649{
  static final int MAX = 200 * 1000 + 1, INF = 1000 * 1000 * 1000 + 1;
  static int[] arr = new int[MAX];
  static int[] seg = new int[MAX * 4];
  
  static void build(int cl, int cr, int p){
    if(cl == cr){
      seg[p] = arr[cl];
    }
    else{
      int m = (cl + cr) / 2;
      build(cl, m, p * 2);
      build(m + 1, cr, p * 2 + 1);
      seg[p] = Math.min(seg[p * 2], seg[p * 2 + 1]);
    }
  }
  
  static void update(int i, int v, int cl, int cr, int p){
    if(cl == cr){
      seg[p] = v;
    }
    else{
      int m = (cl + cr) / 2;
      if(i <= m)
        update(i, v, cl, m, p * 2);
      else
        update(i, v, m + 1, cr, p * 2 + 1);
      
      seg[p] = Math.min(seg[p * 2], seg[p * 2 + 1]);
    }
  }
  
  static int query(int l, int r, int cl, int cr, int p){
    if(cl > r || cr < l) return INF;
    else if(cl >= l && cr <= r) return seg[p];
    else{
      int m = (cl + cr) / 2;
      return Math.min(
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
    for(int i = 1; i <= N; i++){
      arr[i] = Integer.parseInt(tokens[i - 1]);
    }
    
    build(1, N, 1);
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      int q = Integer.parseInt(tokens[0]), a = Integer.parseInt(tokens[1]), b = Integer.parseInt(tokens[2]);
      if(q == 1){
        update(a, b, 1, N, 1);
      }
      else{
        System.out.println(query(a, b, 1, N, 1));
      }
    }
  }
}