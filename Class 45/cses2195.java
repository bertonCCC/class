import java.io.*;

public class cses2195{
  static int sign(long n){
    if(n > 0) return 1;
    else if(n < 0) return -1;
    return 0;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int T = Integer.parseInt(in.readLine());
    for(int i = 0; i < T; i++){
      String[] tokens = in.readLine().split(" ");
      int x1 = Integer.parseInt(tokens[0]),
        y1 = Integer.parseInt(tokens[1]),
        x2 = Integer.parseInt(tokens[2]),
        y2 = Integer.parseInt(tokens[3]),
        x3 = Integer.parseInt(tokens[4]),
        y3 = Integer.parseInt(tokens[5]),
        x4 = Integer.parseInt(tokens[6]),
        y4 = Integer.parseInt(tokens[7]);
      
      Point A = new Point(x1, y1);
      Point B = new Point(x2, y2);
      Point C = new Point(x3, y3);
      Point D = new Point(x4, y4);
      
      boolean ans;
      
      if(cross(A, B, C) == 0 && cross(A, B, D) == 0){
        ans = intersect(A.x, B.x, C.x, D.x) && intersect(A.y, B.y, C.y, D.y);
      }
      else{
        ans = sign(cross(A, B, C)) != sign(cross(A, B, D)) &&
          sign(cross(C, D, A)) != sign(cross(C, D, B));
      }
      
      if(ans)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
  
  static Point minus(Point a, Point b){
    return new Point(a.x - b.x, a.y - b.y);
  }
  
  static long cross(Point a, Point b){
    return (long) a.x * b.y - (long) b.x * a.y;
  }
  
  // AB x AC
  static long cross(Point a, Point b, Point c){
    return cross(minus(b, a), minus(c, a));
  }
}

class Point{
  int x, y;
  public Point(int _x, int _y){
    x = _x;
    y = _y;
  }
}