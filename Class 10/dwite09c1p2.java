import java.io.*;
import java.util.*;

public class dwite09c1p2{
  public static void printAnswers(String current, String before){
    if(current.equals("")){
      System.out.println(before);
      return;
    }
    
    for(int i = 0; i < current.length(); i++){
      char ch = current.charAt(i);
      String newString = current.substring(0, i) + current.substring(i + 1, current.length());
      printAnswers(newString, before + ch);
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    for(int j = 0; j < 5; j++){
      char arr[] = in.readLine().toCharArray();
      Arrays.sort(arr);
      String str = "";
      for(int i = 0; i < arr.length; i++)
        str += arr[i];
      printAnswers(str, "");
    }
  }
}