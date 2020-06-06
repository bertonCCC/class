import java.io.*;
import java.util.*;

public class dmopc18c3p1{
  public static int dist(int a, int b){
    if(b > a) return b - a;
    else return b + 12 - a;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    // A, A#, B, C, C#, D, D#, E, F, F#, G, G#
    // 0   1  2  3  4   5  6   7  8  9   10 11
    String[] notes =
    {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
    TreeMap<String, Integer> nums = new TreeMap<String, Integer>();
    
    for(int i = 0; i < 12; i++){
      nums.put(notes[i], i);
    }
    
    int note1 = nums.get(in.readLine()),
      note2 = nums.get(in.readLine()),
      note3 = nums.get(in.readLine());
    
    /*
     * Root
     * type of triad
     * which inversion (cyclic shift)
     */
    if(dist(note1, note2) == 4 && dist(note2, note3) == 3){
      System.out.println(notes[note1]);
      System.out.println("major");
      System.out.println("root position");
    }
    else if(dist(note1, note2) == 3 && dist(note2, note3) == 5){
      System.out.println(notes[note3]);
      System.out.println("major");
      System.out.println("first inversion");
    }
    else if(dist(note1, note2) == 5 && dist(note2, note3) == 4){
      System.out.println(notes[note2]);
      System.out.println("major");
      System.out.println("second inversion");
    }
    else if(dist(note1, note2) == 3 && dist(note2, note3) == 4){
      System.out.println(notes[note1]);
      System.out.println("minor");
      System.out.println("root position");
    }
    else if(dist(note1, note2) == 4 && dist(note2, note3) == 5){
      System.out.println(notes[note3]);
      System.out.println("minor");
      System.out.println("first inversion");
    }
    else if(dist(note1, note2) == 5 && dist(note2, note3) == 3){
      System.out.println(notes[note2]);
      System.out.println("minor");
      System.out.println("second inversion");
    }
    else if(dist(note1, note2) == 4 && dist(note2, note3) == 4){
      System.out.println(notes[note1]);
      System.out.println("augmented");
      System.out.println("root position");
    }
    else if(dist(note1, note2) == 3 && dist(note2, note3) == 3){
      System.out.println(notes[note1]);
      System.out.println("diminished");
      System.out.println("root position");
    }
    else if(dist(note1, note2) == 3 && dist(note2, note3) == 6){
      System.out.println(notes[note3]);
      System.out.println("diminished");
      System.out.println("first inversion");
    }
    else if(dist(note1, note2) == 6 && dist(note2, note3) == 3){
      System.out.println(notes[note2]);
      System.out.println("diminished");
      System.out.println("second inversion");
    }
  }
}