import java.io.*;

public class p4{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String temp = in.readLine();
    int N = Integer.parseInt(temp);
    
    String[] letters = new String[N];
    String[] bits = new String[N];
    
    for(int i = 0; i < N; i++){
      String[] line = in.readLine().split(" ");
      letters[i] = line[0];
      bits[i] = line[1];
    }
    
    String code = in.readLine();
    String current = "";
    for(int i = 0; i < code.length(); i++){
      current += code.charAt(i);
      int index = -1;
      for(int j = 0; j < N; j++){
        if(current.equals(bits[j])){
          index = j;
          break;
        }
      }
      
      if(index != -1){
        System.out.print(letters[index]);
        current = "";
      }
    }
  }
}