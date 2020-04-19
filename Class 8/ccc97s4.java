import java.io.*;
import java.util.*;

public class ccc97s4{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String N = in.readLine();
    HashMap<String, Integer> dict = new HashMap<String, Integer>();
    
    while(true){
      String line = in.readLine();
      if(line == null) return;
      if(line.equals("")){
        dict.clear();
        System.out.println("");
      }
      
      String word = "";
      for(int i = 0; i < line.length(); i++){
        char ch = line.charAt(i);
        if(ch != ' '){
          word += ch;
        }
        else{ // character IS space
          if(!word.equals("")){
            if(dict.containsKey(word))
              System.out.print(dict.get(word));
            else{
              System.out.print(word);
              int oldSize = dict.size();
              dict.put(word, oldSize + 1);
            }
            
            word = "";
          }
          
          System.out.print(" ");
        }
      }
      
      if(!word.equals("")){
        if(dict.containsKey(word))
          System.out.print(dict.get(word));
        else{
          System.out.print(word);
          int oldSize = dict.size();
          dict.put(word, oldSize + 1);
        }
        
        word = "";
      }
      System.out.println("");
    }
  }
}