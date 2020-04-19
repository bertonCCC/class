import java.io.*;
import java.util.*;

public class mwc15c2p2{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(in.readLine());
    String[] tokens = in.readLine().split(" ");
    int[] heights = new int[N];
    for(int i = 0; i < N; i++){
      heights[i] = Integer.parseInt(tokens[i]);
    }
    Stack<Tower> rel = new Stack<Tower>();
    
    rel.push(new Tower(0, 1000001));
    for(int i = 0; i < N; i++){
      while(rel.peek().height <= heights[i])
        rel.pop();
      
      int ans = rel.peek().index;
      System.out.print((i - ans) + " ");
      
      rel.push(new Tower(i, heights[i]));
    }
  }
}

class Tower{
  public int index, height;
  public Tower(int i, int h){
    this.index = i;
    this.height = h;
  }
}