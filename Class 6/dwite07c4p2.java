import java.io.*;
import java.util.*;

public class dwite07c4p2{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    Triple[] arr = new Triple[5];
    
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        String[] tokens = in.readLine().split(" ", 2);
        int score = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        arr[j] = new Triple();
        arr[j].score = score;
        arr[j].name = name;
        arr[j].index = j;
      }
      
      Arrays.sort(arr);
      
      for(int j = 0; j < 5; j++)
        System.out.println(arr[j].name);
    }
  }
}

class Triple implements Comparable<Triple>{
  public Integer score, index;
  public String name;
  public int compareTo(Triple other){
    if(this.score == other.score){
      return this.index.compareTo(other.index);
    }
    
    return other.score.compareTo(this.score);
  }
}