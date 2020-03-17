import java.io.*;
import java.util.*;

public class bts17p2{
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int G = Integer.parseInt(in.readLine());
    double ans = 1.0;
    for(int i = 0; i < G; i++){
      String[] tokens = in.readLine().split(" ");
      int E = Integer.parseInt(tokens[0]);
      int T = Integer.parseInt(tokens[1]);
      double prob = (T - E) / (double) T;
      ans *= prob;
    }
    System.out.printf("%.10f", ans);
    System.out.println();
  }
}