import java.io.*;

public class zfunc{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String str = in.readLine();
    String pat = in.readLine();
    str = pat + "#" + str;
    int N = str.length();
    int[] zfunc = new int[N];
    
    int left = -1, right = -1;
    for(int i = 1; i < N; i++){
      int best = 0;
      
      if(i <= right)
        best = Math.min(zfunc[i - left], right - i + 1);
      
      while(i + best < N && str.charAt(best) == str.charAt(i + best))
        ++best;
      
      if(i + best - 1 > right){
        left = i;
        right = i + best - 1;
      }
      
      zfunc[i] = best;
    }
    
    for(int i = pat.length() + 1; i < N; i++){
      if(zfunc[i] == pat.length()){
        System.out.println(i - pat.length() - 1);
        return;
      }
    }
    
    System.out.println(-1);
  }
}