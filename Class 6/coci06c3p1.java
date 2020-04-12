import java.io.*;

public class coci06c3p1{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int[] arr = new int[9];
    int total = 0;
    
    for(int i = 0; i < 9; i++){
      arr[i] = Integer.parseInt(in.readLine());
      total += arr[i];
    }
    
    int fake1 = -1, fake2 = -1;
    
    for(int i = 0; i < 9; i++){
      for(int j = i + 1; j < 9; j++){
        if(arr[i] + arr[j] == total - 100){
          fake1 = i;
          fake2 = j;
        }
      }
    }
    
    for(int i = 0; i < 9; i++){
      if(i != fake1 && i != fake2)
        System.out.println(arr[i]);
    }
  }
}