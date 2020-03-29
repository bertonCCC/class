import java.io.*;
import java.util.*;

public class lcc18c1s3{
  static int[] freq1 = new int[26];
  static int[] freq2 = new int[26];
  
  static boolean equal(){
    for(int i = 0; i < 26; i++){
      if(freq1[i] != freq2[i])
        return false;
    }
    return true;
  }
  
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    String str = in.readLine();
    
    for(int size = N / 2; size >= 1; size--){
      for(int i = 0; i < size; i++){
        int code1 = (int) str.charAt(i) - 97;
        freq1[code1] += 1;
        
        int code2 = (int) str.charAt(i + size) - 97;
        freq2[code2] += 1;
      }
      
      if(equal()){
        System.out.println(size * 2);
        return;
      }
      
      for(int offset = 1; offset + size * 2 <= N; offset++){
        int leftCode1 = (int) str.charAt(offset - 1) - 97;
        freq1[leftCode1] -= 1;
        int rightCode1 = (int) str.charAt(offset + size - 1) - 97;
        freq1[rightCode1] += 1;
        
        int leftCode2 = (int) str.charAt(offset + size - 1) - 97;
        freq2[leftCode2] -= 1;
        int rightCode2 = (int) str.charAt(offset + size * 2 - 1) - 97;
        freq2[rightCode2] += 1;
        
        if(equal()){
          System.out.print(size * 2);
          return;
        }
      }
      
      for(int i = 0; i < 26; i++){
        freq1[i] = 0;
        freq2[i] = 0;
      }
    }
    
    System.out.println(0);
  }
}