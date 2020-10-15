import java.io.*;

public class pacnw16j{
  static final int MAX = 200 * 1000 + 1;
  static int N, Q;
  static long[] arr = new long[MAX], seg = new long[MAX * 4];
  
  static void build(int left, int right, int index){
    if(left == right){
      seg[index] = arr[left];
      return;
    }
    int mid = (left + right) / 2;
    build(left, mid, index * 2);
    build(mid + 1, right, index * 2 + 1);
    seg[index] = Math.min(seg[index * 2], seg[index * 2 + 1]);
  }
  
  // Returns the leftmost index between qleft and qright such that the array value is <= value
  // If no index exists in the range, return 0 instead
  static int leftmost(int qleft, int qright, long value, int left, int right, int index){
    // Case 1: No overlap, return 0
    if(left > qright || right < qleft) return 0;
    
    // Case 2: Full overlap and the max on segment doesn't reach value argument, return 0
    if(left >= qleft && right <= qright && seg[index] > value) return 0;
 
    // Case 3: At a leaf, return the index if the value is <= the value argument, 0 otherwise
    if(left == right) return arr[left] <= value ? left : 0;
    
    // Case 4: Full overlap and the max on segment reaches the value argument or partial overlap
    // We should prioritize the left child segment if it contains an element <= value
    // or the right child segment otherwise
    int mid = (left + right) / 2;
    int temp = leftmost(qleft, qright, value, left, mid, index * 2);
    if(temp != 0) return temp;
    else return leftmost(qleft, qright, value, mid + 1, right, index * 2 + 1);
  }
  
  static long answer(long value, int left, int right){
    int current = left;
    while(current <= right){
      current = leftmost(current, right, value, 1, N, 1);
      if(current == 0) break;
      value %= arr[current];
      current += 1;
    }
    
    return value;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] t = in.readLine().split(" ");
    N = pi(t[0]); Q = pi(t[1]);
    t = in.readLine().split(" ");
    for(int i = 0; i < N; i++)
      arr[i + 1] = pl(t[i]);
    build(1, N, 1);
    
    for(int i = 0; i < Q; i++){
      t = in.readLine().split(" ");
      long v = pl(t[0]);
      int l = pi(t[1]), r = pi(t[2]);
      System.out.println(answer(v, l, r));
    }
  }
  
  static int pi(String s) { return Integer.parseInt(s); }
  static long pl(String s) { return Long.parseLong(s); }
}