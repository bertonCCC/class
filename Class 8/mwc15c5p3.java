import java.io.*;
import java.util.*;

public class mwc15c5p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]);
    
    String[] words1 = in.readLine().split(" ");
    String[] words2 = in.readLine().split(" ");
    
    HashSet<String> set1 = new HashSet<String>();
    HashSet<String> set2 = new HashSet<String>();
    
    for(int i = 0; i < N; i++)
      set1.add(words1[i]);
    for(int i = 0; i < M; i++)
      set2.add(words2[i]);
    
    int ans = 0;
    for(String word : set2){
      if(set1.contains(word))
        ans += 1;
    }
    
    System.out.println(ans);
  }
}