import java.io.*;
import java.util.*;

public class dmpg18g1{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]);
    
    boolean[] empty = new boolean[N + 1];
    int[] student = new int[N + 1];
    
    tokens = in.readLine().split(" ");
    for(int i = 0; i < K; i++){
      int num = Integer.parseInt(tokens[i]);
      empty[num] = true;
    }
    tokens = in.readLine().split(" ");
    for(int i = 0; i < K + 1; i++){
      int num = Integer.parseInt(tokens[i]);
      student[num] = i + 1;
    }
    
    Stack<Integer> bus = new Stack();
    int i = 1, count = 0;
    while(count < K || bus.empty()){
      if(student[i] != 0){
        bus.push(student[i]);
        student[i] = 0;
      }
      if(empty[i] && !bus.empty()){
        bus.pop();
        empty[i] = false;
        ++count;
      }
      
      ++i;
      if(i > N) i = 1;
    }
    
    System.out.println(bus.pop());
  }
}