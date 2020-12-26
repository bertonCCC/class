import java.io.*;

public class ecoo16r2p1{
  static void solve(String tmp){
    char[] arr = new char[2 * tmp.length() + 1];
    for(int i = 0; i < tmp.length(); i++){
      arr[i * 2] = '#';
      arr[i * 2 + 1] = tmp.charAt(i);
    }
    arr[2 * tmp.length()] = '#';
    String str = new String(arr);
    
    int N = str.length();
    int[] lps = new int[N];
    
    int center = 0, right = 0, max = 0;
    for(int i = 1; i < N; i++){
      int l = 0;
      if(i <= right){
        l = Math.min(lps[2 * center - i], right - i + 1);
      }
      
      while(i - l - 1 >= 0 && i + l + 1 < N && str.charAt(i - l - 1) == str.charAt(i + l + 1))
        ++l;
      
      if(i + l - 1 > right){
        center = i;
        right = i + l - 1;
      }
      
      lps[i] = l;
      
      if(i - l == 0 || i + l == N - 1)
        max = Math.max(max, l);
    }

    System.out.println(N/2 - max);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    for(int i = 0; i < 10; i++){
      String str = in.readLine();
      solve(str);
    }
  }
}