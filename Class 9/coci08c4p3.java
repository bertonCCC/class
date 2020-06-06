import java.io.*;

public class coci08c4p3{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int R = Integer.parseInt(tokens[0]), C = Integer.parseInt(tokens[1]);
    
    char[][] arr = new char[20][20];
    char[][] arr2 = new char[20][20];
    for(int i = 0; i < R; i++){
      String line = in.readLine();
      //arr[i] = line.toCharArray();
      for(int j = 0; j < C; j++){
        arr[i][j] = line.charAt(j);
      }
    }
    int angle = Integer.parseInt(in.readLine());
    
    while(angle >= 90){
      for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
          arr2[j][R - i - 1] = arr[i][j];
        }
      }
      
      int tmp = R;
      R = C;
      C = tmp;
      
      for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
          arr[i][j] = arr2[i][j];
        }
      }
      
      angle -= 90;
    }
    
    if(angle == 0){
      for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
          System.out.print(arr[i][j]);
        }
        System.out.println();
      }
    }
    else{
      for(int i = 0; i < 20; i++){
          for(int j = 0; j < 20; j++){
            arr2[i][j] = ' ';
        }
      }
      
      for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
          arr2[i + j][i - j + C - 1] = arr[i][j];
        }
      }
      
      for(int i = 0; i < R + C - 1; i++){
        if(i < R){
          for(int j = 0; j <= C + i - 1; j++){
            System.out.print(arr2[i][j]);
          }
        }
        else{
          for(int j = 0; j <= 2 * R - i + 2; j++){
            System.out.print(arr2[i][j]);
          }
        }
        System.out.println();
      }
    }
  }
}