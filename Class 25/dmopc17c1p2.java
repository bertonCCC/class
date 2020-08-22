import java.io.*;
import java.util.*;

public class dmopc17c1p2{
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
    
    int N = in.nextInt(), M = in.nextInt();
    int[] arr = new int[N + 1];
    int[] psa = new int[N + 1];
    HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
    
    long ans = 0;
    for(int i = 0; i <= N; i++){
      if(i >= 1){
        arr[i] = in.nextInt();
        psa[i] = (psa[i - 1] + arr[i]) % M;
      }
      
      if(freq.containsKey(psa[i]))
        ans += freq.get(psa[i]);
      
      if(freq.containsKey(psa[i])){
        int oldFreq = freq.get(psa[i]);
        freq.put(psa[i], oldFreq + 1);
      }
      else{
        freq.put(psa[i], 1);
      }
    }
    
    System.out.println(ans);
  }
}
