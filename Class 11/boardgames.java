import java.io.*;
import java.util.*;

public class boardgames{
  public static void main(String[] args) throws IOException{
    final int MAX = 10 * 1000 * 1000;
    Scanner in = new Scanner(System.in);
    
    int N = in.nextInt(), M = in.nextInt();
    Queue<Integer> queue = new LinkedList<Integer>();
    boolean[] visited = new boolean[10 * 1000 * 1000 + 1];
    int[] steps = new int[10 * 1000 * 1000 + 1];
    
    queue.offer(N);
    visited[N] = true;
    
    while(true){
      int current = queue.poll();
      
      if(current == M){
        System.out.println(steps[current]);
        return;
      }
       if(3 * current <= MAX && !visited[3 * current]){
        visited[3 * current] = true;
        queue.offer(3 * current);
        steps[3 * current] = steps[current] + 1;
      }
      
      if(current - 1 > 0 && !visited[current - 1]){
        visited[current - 1] = true;
        queue.offer(current - 1);
        steps[current - 1] = steps[current] + 1;
      }
      
      if(current - 3 > 0 && !visited[current - 3]){
        visited[current - 3] = true;
        queue.offer(current - 3);
        steps[current - 3] = steps[current] + 1;
      }
      
      if(current % 2 == 0 && !visited[current / 2]){
        visited[current / 2] = true;
        queue.offer(current / 2);
        steps[current / 2] = steps[current] + 1;
      }
    }
  }
}