import java.util.*;

public class year2015p4{
  static Trace[][] trace = new Trace[1001][1001];
  static String[] codes = {
    "chug A",
    "chug B",
    "fill A",
    "fill B",
    "pour A B",
    "pour B A"
  };
  
  static void traceAnswer(int currentA, int currentB){
    if(currentA == 0 && currentB == 0) return;
    Trace t = trace[currentA][currentB];
    traceAnswer(t.previousA, t.previousB);
    System.out.println(codes[t.operation]);
  }
  
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int maxA = in.nextInt(), maxB = in.nextInt(), target = in.nextInt();
    boolean[][] vist = new boolean[1001][1001]; 
    
    Queue<State> queue = new LinkedList<State>();
    queue.offer(new State(0, 0));
    vist[0][0] = true;
    int newA, newB;
    
    while(!queue.isEmpty()){
      State state = queue.poll();
      int currentA = state.a, currentB = state.b;
      
      if(currentA == target || currentB == target){
        traceAnswer(currentA, currentB);
        return;
      }
      
      if(!vist[0][currentB]){
        queue.offer(new State(0, currentB));
        vist[0][currentB] = true;
        trace[0][currentB] = new Trace(currentA, currentB, 0);
      }
      if(!vist[currentA][0]){
        queue.offer(new State(currentA, 0));
        vist[currentA][0] = true;
        trace[currentA][0] = new Trace(currentA, currentB, 1);
      }
      
      if(!vist[maxA][currentB]){
        queue.offer(new State(maxA, currentB));
        vist[maxA][currentB] = true;
        trace[maxA][currentB] = new Trace(currentA, currentB, 2);
      }
      if(!vist[currentA][maxB]){
        queue.offer(new State(currentA, maxB));
        vist[currentA][maxB] = true;
        trace[currentA][maxB] = new Trace(currentA, currentB, 3);
      }
      
      if(currentA + currentB > maxB){
        newA = currentA + currentB - maxB;
        newB = maxB;
      }
      else{
        newA = 0;
        newB = currentA + currentB;
      }
      if(!vist[newA][newB]){
        queue.offer(new State(newA, newB));
        vist[newA][newB] = true;
        trace[newA][newB] = new Trace(currentA, currentB, 4);
      }
      
      if(currentA + currentB > maxA){
        newA = maxA;
        newB = currentA + currentB - maxA;
      }
      else{
        newA = currentA + currentB;
        newB = 0;
      }
      if(!vist[newA][newB]){
        queue.offer(new State(newA, newB));
        vist[newA][newB] = true;
        trace[newA][newB] = new Trace(currentA, currentB, 5);
      }
    }
    
    System.out.println("Not possible");
  }
}

class State{
  int a, b;
  public State(int a, int b){
    this.a = a;
    this.b = b;
  }
}

class Trace{
  int previousA, previousB, operation;
  public Trace(int a, int b, int o){
    previousA = a;
    previousB = b;
    operation = o;
  }
}