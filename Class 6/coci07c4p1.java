import java.io.*;

public class coci07c4p1{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int A = Integer.parseInt(tokens[0]);
    int B = Integer.parseInt(tokens[1]);
    int C = Integer.parseInt(tokens[2]);
    int D = Integer.parseInt(tokens[3]);
    
    tokens = in.readLine().split(" ");
    int[] times = new int[3];
    for(int i = 0; i < 3; i++)
      times[i] = Integer.parseInt(tokens[i]);
    
    for(int i = 0; i < 3; i++){
      int count = 0;
      if((times[i] - 1) % (A + B) < A)
        count += 1;
      if((times[i] - 1) % (C + D) < C)
        count += 1;
      
      if(count == 0) System.out.println("none");
      else if(count == 1) System.out.println("one");
      else if(count == 2) System.out.println("both");
    }
  }
}