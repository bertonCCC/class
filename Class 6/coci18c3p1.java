import java.io.*;

public class coci18c3p1{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String str = in.readLine();
    
    int ct = 0, ans = 0;
    for(int i = 0; i < str.length(); i++){
      char ch = str.charAt(i);
      
      if(ch == "HONI".charAt(ct)){
        if(ch == 'I') ans += 1;
        ct = (ct + 1) % 4;
      }
    }
    
    System.out.println(ans);
  }
}