import java.io.*;
import java.util.*;

public class dmopc14c2p6{
  static int[] seg = new int[400 * 1000];
  
  static void update(int uind, int val, int left, int right, int ind){
    if(left == right){
      seg[ind] = val;
    }
    else{
      int mid = (left + right) / 2;
      if(uind <= mid) update(uind, val, left, mid, ind * 2);
      else update(uind, val, mid + 1, right, ind * 2 + 1);
      seg[ind] = seg[ind * 2] + seg[ind * 2 + 1];
    }
  }
  
  static int query(int qleft, int qright, int left, int right, int ind){
    if(left > qright || right < qleft) return 0;
    if(left >= qleft && right <= qright) return seg[ind];
    int mid = (left + right) / 2;
    return query(qleft, qright, left, mid, ind * 2)
      + query(qleft, qright, mid + 1, right, ind * 2 + 1);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    Value[] val = new Value[N];
    
    String[] tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++){
      int v = Integer.parseInt(tokens[i]);
      val[i] = new Value(i, v);
    }
    
    Arrays.sort(val, new Comparator<Value>(){
      public int compare(Value a, Value b){
        return b.value - a.value;
      }
    });
    
    int Q = Integer.parseInt(in.readLine());
    Query[] quer = new Query[Q];
    int[] ans = new int[Q];
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      int l = Integer.parseInt(tokens[0]), r = Integer.parseInt(tokens[1]), q = Integer.parseInt(tokens[2]);
      
      quer[i] = new Query(l, r, q, i);
    }
    
     Arrays.sort(quer, new Comparator<Query>(){
      public int compare(Query a, Query b){
        return b.q - a.q;
      }
    });
     
     int j = -1; // Up to and including j, the values of the array
     // that are active
     for(int i = 0; i < Q; i++){
       Query cur = quer[i];
       
       while(j + 1 < N && val[j + 1].value >= cur.q){
         j += 1;
         update(val[j].index, val[j].value, 0, N - 1, 1);
       }
       
       ans[cur.ind] = query(cur.left, cur.right, 0, N - 1, 1);
     }
     
     for(int i = 0; i < Q; i++)
       System.out.println(ans[i]);
  }
}

class Value{
  int index, value;
  public Value(int i, int v){ index = i; value = v; }
}

class Query{
  int left, right, q, ind;
  public Query(int l, int r, int _q, int i){ left = l; right = r; q = _q; ind = i; }
}