import java.io.*;

public class seg{
  static final int MAXN = 100 * 1000;
  int[] seg = new int[4 * MAXN];
  
  static void build(int[] arr, int left, int right, int index){
    if(left < right){
      int mid = (left + right) / 2;
      build(left, mid, index * 2);
      build(mid + 1, right, index * 2 + 1);
      seg[index] = Math.max(seg[index * 2], seg[index * 2 + 1]);
    }
    else{
      seg[index] = arr[left]; // left = right
    }
  }
  
  void update(int updateIndex, int value, int left, right, int index){
    if(left < right){
      int mid = (left + right) / 2;
      if(updateIndex <= mid){
        update(updateIndex, value, left, mid, index * 2);
      }
      else{
        update(updateIndex, value, mid + 1, right, index * 2 + 1);
      }
      
      seg[index] = Math.max(seg[index * 2], seg[index * 2 + 1]);
    }
    else{
      seg[index] = value;
    }
  }
  
  int query(int queryLeft, int queryRight, int left, int right, index){
    if(left >= queryLeft && right <= queryRight)
      return seg[index];
    else if(left > queryRight || right < queryLeft)
      return -INF;
    else{
      int mid = (left + right) / 2;
      return Math.max(
                      query(queryLeft, queryRight, left, mid, index * 2);
                      query(queryLeft, queryRight, mid + 1, right, index * 2 + 1)
                     );
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    build(arr, 1, N, 1);
  }
}