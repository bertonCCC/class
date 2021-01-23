import java.io.*;
import java.util.*;

public class dmopc17c1p5{
  static final int MAX = 1000 * 1000 + 1;
  static int[] fen = new int[MAX];
  
  static void addone(int n){
    for(int i = n; i < MAX; i += i & -i)
      fen[i] += 1;
  }
  
  static int sum(int n){
    int tot = 0;
    for(int i = n; i > 0 ; i -= i & -i)
      tot += fen[i];
    return tot;
  }
  
  static int sum(int left, int right){
    return sum(right) - sum(left - 1);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    final int INF = 1000 * 1000 * 1000;
    
    String[] t = in.readLine().split(" ");
    int N = pi(t[0]), Q = pi(t[1]);
    int[] arr = new int[N + 1];
    Pair[] act = new Pair[N];
    
    t = in.readLine().split(" ");
    for(int i = 1; i <= N; i++)
      arr[i] = pi(t[i - 1]);
    
    Stack<Pair> st = new Stack<Pair>();
    st.push(new Pair(INF, 0));
                     
    for(int i = 1; i <= N; i++){
      while(st.peek().first < arr[i])
        st.pop();
      
      act[i - 1] = new Pair(st.peek().second + 1, i);
      st.push(new Pair(arr[i], i));
    }
    
    Arrays.sort(act, new Comparator<Pair>(){
      public int compare(Pair a, Pair b){
        return a.first - b.first;
      }
    });
    
    Query[] quer = new Query[Q];
    int[] ans = new int[Q];
    
    for(int i = 0; i < Q; i++){
      t = in.readLine().split(" ");
      int left = pi(t[0]), right = pi(t[1]);
      quer[i] = new Query(left, right, i);
    }
    
    Arrays.sort(quer, new Comparator<Query>(){
      public int compare(Query a, Query b){
        return a.l - b.l;
      }
    });
    
    int j = -1; // all indexes up to and including j are activated
    for(int i = 0; i < Q; i++){
      while(j + 1 < N && act[j + 1].first <= quer[i].l){
        j += 1;
        addone(act[j].second);
      }
      
      ans[quer[i].i] = sum(quer[i].l, quer[i].r);
    }
    
    for(int i = 0; i < Q; i++)
      System.out.println(ans[i]);
  }
  
  public static int pi(String s){
    return Integer.parseInt(s);
  }
}

class Pair{
  int first, second;
  public Pair(int f, int s){
    first = f;
    second = s;
  }
}

class Query{
  int l, r, i;
  public Query(int _l, int _r, int _i){
    l = _l;
    r = _r;
    i = _i;
  }
}