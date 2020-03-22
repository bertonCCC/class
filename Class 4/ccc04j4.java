import java.io.*;
import java.util.*;

public class ccc04j4{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String key = in.readLine();
    String message = in.readLine();
    
    int A = (int)'A';
    int Z = (int)'Z';
    
    int which = 0;
    for(int i = 0; i < message.length(); i++){
      char cur = message.charAt(i);
      int ascii = (int)cur;
      
      if(ascii >= A && ascii <= Z){
        int shift = (int) key.charAt(which) - A;
        int newAscii = ((ascii - A) + shift) % 26;
        System.out.print((char)(newAscii + A));
        which = (which + 1) % key.length();
      }
    }
  }
}