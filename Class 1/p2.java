import java.io.*;

public class p2{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String word = in.readLine();
    // I, O, S, H, Z, X, and N.
    
    boolean ans = true;
    
    for(int i = 0; i < word.length(); i++){
      char ch = word.charAt(i);
      if("IOSHZXN".indexOf("" + ch) == -1){
        ans = false;
        break;
      }
    }
    
    if(ans){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}