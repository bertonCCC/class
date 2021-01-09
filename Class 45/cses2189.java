import java.io.*;

public class cses2189{
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
        y3 = Integer.parseInt(tokens[5]);
      
      Point p1 = new Point(x1, y1);
      Point p2 = new Point(x2, y2);
      Point p3 = new Point(x3, y3);
      
      long cp = cross(minus(p2, p1), minus(p3, p1));
      
      if(cp > 0) System.out.println("LEFT");
      else if(cp < 0) System.out.println("RIGHT");
      else System.out.println("TOUCH");
    }
  }
  
  static Point minus(Point a, Point b){
    return new Point(a.x - b.x, a.y - b.y);
  }
  
  static long cross(Point a, Point b){
    return (long) a.x * b.y - (long) b.x * a.y;
  }
}

class Point{
  int x, y;
  public Point(int _x, int _y){
    x = _x;
    y = _y;
  }
}