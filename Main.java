import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N;
  static ArrayList<Integer> list;
  public static void main(String[] args) {
    N = scan.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0; i<N; i++){
      int x = scan.nextInt();
      if(x == 0){
        if(pq.isEmpty())System.out.println(0);
        else System.out.println(pq.poll());
      }else{
        pq.add(x);
      }
    }
  }
  static class FastReader{
    BufferedReader br; 
    StringTokenizer st;
    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
      while(st == null || !st.hasMoreTokens()){
        try{
          st = new StringTokenizer(br.readLine());
        }catch(IOException e){
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
    int nextInt(){
      return Integer.parseInt(next());
    }
  }   
}
