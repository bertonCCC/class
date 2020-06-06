import java.io.*;

public class dmopc18c5p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]);
    long M = Long.parseLong(tokens[1]);
    
    int[] arr = new int[N];
    tokens = in.readLine().split(" ");
    for(int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(tokens[i]);
    
    long sum = 0;
    int right = -1, ans = 0;
    
    for(int i = 0; i < N; i++){
      while(right + 1 < N && sum + arr[right + 1] < M){
        right += 1;
        sum += arr[right];
      }
      ans = Math.max(ans, right - i + 1);
      sum -= arr[i];
    }
    
    System.out.println(ans);
  }
}