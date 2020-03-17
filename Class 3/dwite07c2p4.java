import java.io.*;
import java.util.*;

public class dwite07c2p4{  
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    char[] stack = new char[256];
    int top = -1;

    for(int j = 0; j < 5; j++){
      String str = in.readLine();
      int len = str.length();
      
      boolean balanced = true;
      for(int i = 0; i < len; i++){
        char ch = str.charAt(i);
        
        if("()[]{}".indexOf(ch) == -1) continue;
        
        if("([{".indexOf(ch) >= 0){
          top += 1;
          stack[top] = ch;
        }
        else{
          if(top == -1){
            balanced = false;
            break;
          }
          
          char tp = stack[top];
          if((ch == ')' && tp == '(') || (ch == ']' && tp == '[') || (ch == '}' && tp == '{')){
            top -= 1;
          }
          else{
            balanced = false;
            break;
          }
        }
      }
      
      if(top > -1) balanced = false;
      
      if(balanced)
        System.out.println("balanced");
      else
        System.out.println("not balanced");
    }
  }
}