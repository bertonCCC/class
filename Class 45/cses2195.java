import java.io.*;
import java.util.*;

public class cses2195{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int N = Integer.parseInt(in.readLine());
    Point[] pt = new Point[N], upper = new Point[N], lower = new Point[N];
    String[] tokens;
    
    for(int i = 0; i < N; i++){
      tokens = in.readLine().split(" ");
      int x = Integer.parseInt(tokens[0]), y = Integer.parseInt(tokens[1]);
      pt[i] = new Point(x, y);
    }
    
    Arrays.sort(pt, new Comparator<Point>(){
      public int compare(Point a, Point b){
        if(a.x == b.x) return a.y - b.y;
        return a.x - b.x;
      }
    });
    
    Point left = pt[0], right = pt[N - 1];
    int Usize = 0, Lsize = 0;
    
    for(int i = 0; i < N; i++){
      long cp = cross(left, right, pt[i]);
      
      if(cp >= 0){
        while(Usize >= 2 && cross(upper[Usize - 2], upper[Usize - 1], pt[i]) > 0)
          --Usize;
        upper[Usize] = pt[i];
        Usize += 1;
      }
      
      if(cp <= 0){
        while(Lsize >= 2 && cross(lower[Lsize - 2], lower[Lsize - 1], pt[i]) < 0)
          --Lsize;
        lower[Lsize] = pt[i];
        Lsize += 1;
      }
    }
    
    int total = Lsize + Usize - 2;
    System.out.println(total);
    
    for(int i = 0; i < Lsize; i++)
      System.out.println(lower[i].x + " " + lower[i].y);
    
    for(int i = Usize - 2; i > 0; i--)
      System.out.println(upper[i].x + " " + upper[i].y);
  }
  
  static Point minus(Point a, Point b){
    return new Point(a.x - b.x, a.y - b.y);
  }
  
  static long cross(Point a, Point b){
    return 1L * a.x * b.y - 1L * b.x * a.y;
  }
  
  static long cross(Point a, Point b, Point c){
    return cross(minus(b, a), minus(c, a));
  }
}

class Point{
  int x, y;
  public Point(int _x, int _y){ x = _x; y = _y; }
}