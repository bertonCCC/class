import java.io.*;

public class dmpg17g2{
  static final int MAX = 100 * 1000 + 1;
  static final long INF = (long) 1e18;
  static int[] arr = new int[MAX];
  static Segment[] seg = new Segment[MAX * 4];
  
  static Segment combine(Segment a, Segment b){
    long newMax = Math.max(Math.max(a.maxSum, b.maxSum), a.sufSum + b.preSum);
    long newPre = Math.max(a.preSum, a.sum + b.preSum);
    long newSuf = Math.max(b.sufSum, a.sufSum + b.sum);
    long newSum = a.sum + b.sum;
    return new Segment(newMax, newPre, newSuf, newSum);
  }
  
  static Segment init(long n){
    return new Segment(n, n, n, n);
  }

  static void build(int left, int right, int index){
    if(left == right) seg[index] = init(arr[left]);
    else{
      int mid = (left + right) / 2;
      build(left, mid, index * 2);
      build(mid + 1, right, index * 2 + 1);
      seg[index] = combine(seg[index * 2], seg[index * 2 + 1]);
    }
  }
  
  static void update(int uindex, long value, int left, int right, int index){
    if(left == right) seg[index] = init(value);
    else{
      int mid = (left + right) / 2;
      if(uindex <= mid) update(uindex, value, left, mid, index * 2);
      else update(uindex, value, mid + 1, right, index * 2 + 1);
      seg[index] = combine(seg[index * 2], seg[index * 2 + 1]);
    }
  }
  
  static Segment query(int qleft, int qright, int left, int right, int index){
    if(left > qright || right < qleft) return new Segment(-INF, -INF, -INF, 0);
    else if(left >= qleft && right <= qright) return seg[index];
    else{
      int mid = (left + right) / 2;
      return combine(
                     query(qleft, qright, left, mid, index * 2),
                     query(qleft, qright, mid + 1, right, index * 2 + 1)
                    );
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] t = in.readLine().split(" ");
    int N = pi(t[0]), Q = pi(t[1]);
    t = in.readLine().split(" ");
    for(int i = 1; i <= N; i++)
      arr[i] = pi(t[i - 1]);
    build(1, N, 1);
    
    for(int i = 0; i < Q; i++){
      t = in.readLine().split(" ");
      String type = t[0];

      if(type.equals("S")){
        int ind = pi(t[1]), val = pi(t[2]);
        update(ind, val, 1, N, 1);
      }
      else{
        int left = pi(t[1]), right = pi(t[2]);
        System.out.println(query(left, right, 1, N, 1).maxSum);
      }
    }
  }
  
  static int pi(String s) { return Integer.parseInt(s); }
}

class Segment{
  public long maxSum, preSum, sufSum, sum;
  
  public Segment(long m, long p, long ss, long s){
    this.maxSum = m;
    this.preSum = p;
    this.sufSum = ss;
    this.sum = s;
  }
}