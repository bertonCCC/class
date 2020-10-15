import java.io.*;

public class dmopc15c1p6{
  final static int MAX = 200 * 1000 + 1;
  static int[] arr = new int[MAX];
  static long[] seg = new long[4 * MAX];
  static long[] lazy = new long[4 * MAX];
  
  static void build(int left, int right, int index){
    if(left == right){
      seg[index] = arr[left];
      return;
    }
    int mid = (left + right) / 2;
    build(left, mid, index * 2);
    build(mid + 1, right, index * 2 + 1);
    seg[index] = seg[index * 2] + seg[index * 2 + 1];
  }
  
  static void update(int uleft, int uright, long value, int left, int right, int index){
    if(lazy[index] != 0){
      seg[index] += lazy[index] * (right - left + 1);
      if(left != right){
        lazy[index * 2] += lazy[index];
        lazy[index * 2 + 1] += lazy[index];
      }
      lazy[index] = 0;
    }
    
    if(left > uright || right < uleft) return;
    else if(left >= uleft && right <= uright){
      seg[index] += value * (right - left + 1);
      if(left != right){
        lazy[index * 2] += value;
        lazy[index * 2 + 1] += value;
      }
    }
    else{
      int mid = (left + right) / 2;
      update(uleft, uright, value, left, mid, index * 2);
      update(uleft, uright, value, mid + 1, right, index * 2 + 1);
      seg[index] = seg[index * 2] + seg[index * 2 + 1];
    }
  }
  
  static long query(int qleft, int qright, int left, int right, int index){
    if(lazy[index] != 0){
      seg[index] += lazy[index] * (right - left + 1);
      if(left != right){
        lazy[index * 2] += lazy[index];
        lazy[index * 2 + 1] += lazy[index];
      }
      lazy[index] = 0;
    }
    
    if(left > qright || right < qleft) return 0;
    else if(left >= qleft && right <= qright) return seg[index];
    else{
      int mid = (left + right) / 2;
      return
        query(qleft, qright, left, mid, index * 2) +
        query(qleft, qright, mid + 1, right, index * 2 + 1);
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] t = in.readLine().split(" ");
    int M = pi(t[0]), N = pi(t[1]), Q = pi(t[2]);
    t = in.readLine().split(" ");
    for(int i = 0; i < N; i++)
      arr[i + 1] = pi(t[i]);
    build(1, N, 1);
    
    for(int i = 0; i < Q; i++){
      t = in.readLine().split(" ");
      int q = pi(t[0]);
      if(q == 1){
        int l = pi(t[1]), r = pi(t[2]), x = pi(t[3]);
        update(l, r, x, 1, N, 1);
      }
      else{
        int l = pi(t[1]), r = pi(t[2]);
        System.out.println(query(l, r, 1, N, 1) % M);
      }
    }
  }
  
  static int pi(String s){ return Integer.parseInt(s); }
}