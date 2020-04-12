import java.io.*;
import java.util.*;

public class ccc20j4{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String str = in.readLine();
    String pat = in.readLine();
    
    int T = str.length(), S = pat.length();
    
    TreeSet<String> set = new TreeSet<String>();
    for(int i = 0; i < S; i++){
      String suf, pre;
      if(i == 0) suf = "";
      else suf = pat.substring(S - i, S);
      pre = pat.substring(0, S - i);
      
      set.add(suf + pre);
    }
    
    for(int i = 0; i < T - S + 1; i++){
      String window = str.substring(i, i + S);
      if(set.contains(window)){
        System.out.println("yes");
        return;
      }
    }
    
    System.out.println("no");
  }
}