import java.io.*;
import java.util.*;

public class coci14c4p1 {
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String digits = in.readLine();
    
    int sum = 0;
    boolean zero = false;
    Integer[] arr = new Integer[digits.length()];
    for(int i = 0; i < digits.length(); i++){
      int val = (int) digits.charAt(i) - 48;
      if(val == 0) zero = true;
      sum += val;
      arr[i] = val;
    }
    
    if(sum % 3 != 0 || !zero){
      System.out.println("-1");
      return;
    }
    
    Arrays.sort(arr);
    for(int i = digits.length() - 1; i >= 0; i--){
      System.out.print(arr[i]);
    }
  }
}