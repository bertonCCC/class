import java.io.*;
import java.util.*;

public class codejam{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int cases = Integer.parseInt(in.readLine());
    for(int i = 1; i <= cases; i++){
      ArrayList<String> prefixes = new ArrayList();
      ArrayList<String> suffixes = new ArrayList();
      
      int N = Integer.parseInt(in.readLine());
      String[] patterns = new String[N];
      String middle = "";
      for(int j = 0; j < N; j++){
        patterns[j] = in.readLine();
        if(patterns[j].charAt(0) != '*'){
          String[] tokens = patterns[j].split("\\*");
          prefixes.add(tokens[0]);
        }
        if(patterns[j].charAt(patterns[j].length() - 1) != '*'){
          String[] tokens = patterns[j].split("\\*");
          suffixes.add(tokens[tokens.length - 1]);
        }
        
        //middle += patterns[j];
      }
      
      String longest_prefix = "";
      for(String prefix : prefixes){
        if(prefix.length() >= longest_prefix.length()){
          if(prefix.substring(0, longest_prefix.length()).equals(longest_prefix)){
            longest_prefix = prefix;
          }
          else{
            longest_prefix = null;
            break;
          }
        }
        else{
          if(longest_prefix.substring(0, prefix.length()).equals(prefix)){
            
          }
          else{
            longest_prefix = null;
            break;
          }
        }
      }
      
      for(String suffix : suffixes){
        if(suffix.length()
      }
    }
  }
}