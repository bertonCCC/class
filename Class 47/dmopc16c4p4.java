import java.io.*;
import java.util.*;

public class dmopc16c4p4{
  static final int BS = 320, MAX = 100 * 1000 + 1;
  static int[] freq = new int[MAX];
  static int counter = 0;
  static int[] arr = new int[MAX];
  
  static void add(int n){
    int v = arr[n];
    freq[v] += 1;
    if(freq[v] % 2 == 1 && freq[v] > 1) counter -= 1;
    if(freq[v] % 2 == 0) counter += 1;
  }
  
  static void rem(int n){
    int v = arr[n];
    freq[v] -= 1;
    if(freq[v] % 2 == 0 && freq[v] > 0) counter += 1;
    if(freq[v] % 2 == 1) counter -= 1;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = pi(in.readLine());
   
    String[] t = in.readLine().split(" ");
    for(int i = 0; i < N; i++){
      arr[i] = pi(t[i]);
    }
    
    int Q = pi(in.readLine());
    Query[] quer = new Query[Q];
    
    for(int i = 0; i < Q; i++){
      t = in.readLine().split(" ");
      int left = pi(t[0]), right = pi(t[1]);
      left -= 1; right -= 1;
      quer[i] = new Query(left, right, i);
    }
    
    Arrays.sort(quer, new Comparator<Query>(){
      public int compare(Query a, Query b){
        int ablock = a.left/BS;
        int bblock = b.left/BS;
        
        if(ablock == bblock) return a.right - b.right;
        return ablock - bblock;
      }
    });
    
    int[] ans = new int[Q];
    int left = 0, right = -1;
    for(int i = 0; i < Q; i++){
      int qleft = quer[i].left, qright = quer[i].right;
      
      while(left > qleft){
        left -= 1;
        add(left);
      }
      while(right < qright){
        right += 1;
        add(right);
      }
      
      while(left < qleft){
        rem(left);
        left += 1;
      }
      while(right > qright){
        rem(right);
        right -= 1;
      }
      
      ans[quer[i].ind] = counter;
    }
    
    for(int i = 0; i < Q; i++)
      System.out.println(ans[i]);
  }
  
  static int pi(String s){
    return Integer.parseInt(s);
  }
}

class Query{
  public int left, right, ind;
  public Query(int l, int r, int i){
    left = l;
    right = r;
    ind = i;
  }
}