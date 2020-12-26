import java.io.*;

public class kmp{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String str = in.readLine();
    String pat = in.readLine();
    str = pat + "#" + str;
    int N = str.length();
    int M = pat.length();
    
    int[] pre = new int[N];
    
    for(int i = 1; i < N; i++){
      int best = pre[i - 1];
      while(best > 0 && str.charAt(best) != str.charAt(i))
        best = pre[best - 1];
      if(str.charAt(best) == str.charAt(i))
        ++best;
      pre[i] = best;
      
      if(best == M){
        System.out.println(i - 2 * M);
        return;
      }
    }
    System.out.println(-1);
  }
}