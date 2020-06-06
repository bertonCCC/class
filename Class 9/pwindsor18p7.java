import java.io.*;
import java.util.*;

public class pwindsor18p7{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(in.readLine());
    Number[] str = new Number[N];
    for(int i = 0; i < N; i++){
      String temp = in.readLine();
      str[i] = new Number();
      str[i].num = temp;
    }
    
    Arrays.sort(str);
    
    for(int i = 0; i < N; i++){
      System.out.print(str[i].num);
    }
  }
}

class Number implements Comparable<Number>{
  public String num;
  public int compareTo(Number other){
    String sc1 = this.num + other.num;
    String sc2 = other.num + this.num;
    return sc2.compareTo(sc1);
  }
}