import java.io.*;
import java.util.*;

public class ccc09j3{
  public static void printTime(int time, String city){
    int hours = time / 60;
    int minutes = time % 60;
    if(hours != 0){
      System.out.print(hours);
    }
    if(minutes != 0){
      System.out.print(minutes);
    }
    else System.out.print("00");
    
    System.out.println(" in " + city);
  }
  
  public static void main(String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(in.readLine());
    int hours = input/100, minutes = input%100;
    int mins = hours*60 + minutes;
    int newMins = mins;
    final int MAX = 24*60;
    
    printTime(mins, "Ottawa");
    newMins = ((mins - 180) % MAX + MAX) % MAX;
    printTime(newMins, "Victoria");
    newMins = ((mins - 120) % MAX + MAX) % MAX;
    printTime(newMins, "Edmonton");
    newMins = ((mins - 60) % MAX + MAX) % MAX;
    printTime(newMins, "Winnipeg");
    newMins = mins;
    printTime(newMins, "Toronto");
    newMins = ((mins + 60) % MAX + MAX) % MAX;
    printTime(newMins, "Halifax");
    newMins = ((mins + 90) % MAX + MAX) % MAX;
    printTime(newMins, "St. John's");
  }
}