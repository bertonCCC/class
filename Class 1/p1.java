import java.io.*;

public class p1{  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] directions = new String[5];
    String[] places = new String[5];
    
    int count = 0;
    while(true){
      String dir = in.readLine();
      String place = in.readLine();
      directions[count] = dir;
      places[count] = place;
      
      count += 1;
      
      if(place.equals("SCHOOL")){
        break;
      }
    }
    
    for(int i = count - 1; i >= 0; i--){
      String newDir;
      if(directions[i].equals("L")){
        newDir = "RIGHT";
      }
      else{
        newDir = "LEFT";
      }
     
      if(i >= 1){
        System.out.println("Turn " + newDir + " onto " + places[i - 1] + " street.");
      }
      else{
        System.out.println("Turn " + newDir + " into your HOME.");
      }
    }
  }
}