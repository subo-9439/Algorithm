package topology_sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
// Boj 1005
// ACM Craft 골드3 
public class Boj_1005 {
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N, K, W;
  static int[] T,T_done;
  static int[] indeg;
  static ArrayList<Integer>[] adj;

  static void input(){
    N = scan.nextInt(); K = scan.nextInt();
    T = new int[N+1];
    T_done = new int[N+1];
    adj = new ArrayList[N+1];
    indeg = new int[N+1];
    for(int i = 1; i <= N; i++) {
      T[i] = scan.nextInt();
      adj[i] = new ArrayList<>();
    }

    for(int i = 1; i <= K; i++){
      int x = scan.nextInt(), y = scan.nextInt();
      adj[x].add(y);
      indeg[y]++;
    }
    W = scan.nextInt();

  }
  static void pro(){
    Deque<Integer> queue = new LinkedList<>();
    //제일 앞에 "정렬 될 수 있는 정점" 찾기
    for(int i = 1; i <= N; i++) 
      if(indeg[i] == 0 ) {
      queue.add(i);
      T_done[i] = T[i];
    }
    
    //위상 정렬 순서대로 T_done 계산을 함께 해주기
    while(!queue.isEmpty()){
      int x = queue.poll();
      for(int y: adj[x]){
        indeg[y]--;
        if(indeg[y] == 0) queue.add(y);
        T_done[y] = Math.max(T_done[y], T_done[x]+T[y]); 
      }
    }
    System.out.println(T_done[W]);
  }
  public static void main(String[] args) {
    int test_case = scan.nextInt();
    while(test_case>0){
      test_case--;
      input();
      pro();
    }
    }
  }
  class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
      while(st == null || !st.hasMoreElements()){
        try{
          st = new StringTokenizer(br.readLine());
        } catch( IOException e){
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt(){
      return Integer.parseInt(next());
    }

    String nextLine(){
      String str = "";
      try{
        str = br.readLine();
      }catch(IOException e){
        e.printStackTrace();
      }
      return str;
    }
}
