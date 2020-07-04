import java.io.*;

public class dmpg17s2{
  static int[] par;
  
  static int find(int cur){
    if(par[cur] == cur) return cur;
    int fin = find(par[cur]);
    par[cur] = fin;
    return fin;
    // return par[cur] = find(par[cur]);
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String[] tokens = in.readLine().split(" ");
    int N = Integer.parseInt(tokens[0]), Q = Integer.parseInt(tokens[1]);
    par = new int[N + 1];
    
    for(int i = 1; i <= N; i++)
      par[i] = i;
    
    for(int i = 0; i < Q; i++){
      tokens = in.readLine().split(" ");
      String type = tokens[0];
      int node1 = Integer.parseInt(tokens[1]), node2 = Integer.parseInt(tokens[2]);
      
      if(type.equals("A")){
        int fin1 = find(node1), fin2 = find(node2);
        if(fin1 != fin2)
          par[fin1] = fin2;
      }
      else{ // type Q
        int fin1 = find(node1), fin2 = find(node2);
        
        if(fin1 == fin2)
          System.out.println("Y");
        else
          System.out.println("N");
      }
    }
  }
}