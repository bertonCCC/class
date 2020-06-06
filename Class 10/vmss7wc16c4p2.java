import java.io.*;
import java.util.*;

public class vmss7wc16c4p2{
  public static int N, L;
  public static char[][] options;
  public static ArrayList<String> answers = new ArrayList<>();
  
  public static void printAnswers(int current, String before){
    if(current > N){
      if(before.length() <= L)
        answers.add(before);
      return;
    }

    for(char option : options[current]){
      printAnswers(current + 1, before + option);
    }
    if(current != 1){
      printAnswers(current + 1, before);
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    N = Integer.parseInt(tokens[0]);
    L = Integer.parseInt(tokens[1]);
    options = new char[N + 1][];
    
    for(int i = 1; i <= N; i++){
      tokens = in.readLine().split(" ");
      int n = Integer.parseInt(tokens[0]);

      options[i] = new char[n];
      for(int j = 1; j < tokens.length; j++){
        options[i][j - 1] = tokens[j].charAt(0);
      }
      //Arrays.sort(options[i]);
    }
    
    printAnswers(1, "");
    Collections.sort(answers);
    for(String answer : answers){
      System.out.println(answer);
    }
  }
}