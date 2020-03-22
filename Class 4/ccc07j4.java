import java.io.*;
import java.util.*;

public class ccc07j4{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String str1 = in.readLine();
    String str2 = in.readLine();
    
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];
    
    for(int i = 0; i < str1.length(); i++){
      int ascii = (int) str1.charAt(i);
      if(ascii >= 65 && ascii <= 90){
        freq1[ascii - 65] += 1;
      }
    }
    
    for(int i = 0; i < str2.length(); i++){
      int ascii = (int) str2.charAt(i);
      if(ascii >= 65 && ascii <= 90){
        freq2[ascii - 65] += 1;
      }
    }
    
    boolean same = true;
    for(int i = 0; i < 26; i++){
      if(freq1[i] != freq2[i]){
        same = false;
        break;
      }
    }
    
    System.out.println(same ? "Is an anagram." : "Is not an anagram.");
  }
}