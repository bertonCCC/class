import java.io.*;
import java.util.*;

public class ccc10j5{
  static boolean[][] vist = new boolean[9][9];
  static int[][] dist = new int[9][9];
  static int[] dr = {+2, +2, +1, -1, -2, -2, +1, -1};
  static int[] dc = {-1, +1, +2, +2, +1, -1, -2, -2};

  static boolean ok(int r, int c){
    return r >= 1 && r <= 8 && c >= 1 && c <= 8 && !vist[r][c];
  }

  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);
    Queue<Position> queue = new LinkedList<Position>();
    
    int R = in.nextInt(), C = in.nextInt(), R2 = in.nextInt(), C2 = in.nextInt();
    
    queue.offer(new Position(R, C));
    vist[R][C] = true;
    
    while(!queue.isEmpty()){
      Position cur = queue.poll();
      int curR = cur.r, curC = cur.c;
      
      if(curR == R2 && curC == C2){
        System.out.println(dist[curR][curC]);
        return;
      }
      
      for(int i = 0; i < 8; i++){
        int newR = curR + dr[i], newC = curC + dc[i];
        
        if(ok(newR, newC)){
          queue.offer(new Position(newR, newC));
          dist[newR][newC] = dist[curR][curC] + 1;
          vist[newR][newC] = true;
        }
      }
    }
  }
}

class Position{
  public int r, c;
  public Position(int r, int c){
    this.r = r;
    this.c = c;
  }
}