import java.io.*;

public class dmopc18c1p2{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]);
    int[] nums = new int[N + 1];
    tokens = in.readLine().split(" ");
    for(int i = 1; i <= N; i++)
      nums[i] = Integer.parseInt(tokens[i - 1]);
    
    for(int i = 1; i <= N; i++){
      if(i % K != nums[i] % K){
        System.out.println("NO");
        return;
      }
    }
    
    System.out.println("YES");
  }
}