import java.io.*;

public class good_subarrays{
  static int[] freq = new int[2 * 1000 * 1000];
  
  static void solve(BufferedReader in) throws IOException{
    int N = Integer.parseInt(in.readLine());
    String digits = in.readLine();

    int[] arr = new int[N + 1];
    int[] psa = new int[N + 1];
    int[] arr2 = new int[N + 1];
    // N + 1 for 1-indexed arrays
    // PSA is more convenient with 1-indexed arrays
    
    for(int i = 0; i < digits.length(); i++){
      char ch = digits.charAt(i);
      int number = (int) ch - (int) '0';
      // Convert ASCII into number
      
      arr[i + 1] = number;
      // Put into array, 1-indexed
    }
    
    for(int i = 1; i <= N; i++)
      psa[i] = psa[i - 1] + arr[i]; // Construct PSA
    
    for(int i = 1; i <= N; i++)
      arr2[i] = psa[i] - i; // Construct arr2 (see notes)
    
    long total = 0; // Answer to be printed out
    for(int i = 0; i <= N; i++){ // Start at 0 (see notes)
      total += freq[arr2[i] + 1000 * 1000];
      // arr2[i] can be negative!
      // Arrays can't have negative indexes so we offset + 1 million
      freq[arr2[i] + 1000 * 1000] += 1;
    }
    
    System.out.println(total);
    
    // Reset frequency array for next time solve() is called
    for(int i = 0; i < 2 * 1000 * 1000; i++)
      freq[i] = 0;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
    int T = Integer.parseInt(in.readLine());
    for(int i = 0; i < T; i++) solve(in);
    // Solve T times
  }
}