import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  static int N,M;
  static int[] indeg;
  static ArrayList<Integer>[] adj;

  static void input() {
    N = scan.nextInt();
    M = scan.nextInt();
    adj = new ArrayList[N+1];
    indeg = new int[N+1];
    for(int i = 1; i <= N; i++){
      adj[i] = new ArrayList<>();
    }
    for(int i = 0; i < M; i++) {
      int x = scan.nextInt(), y = scan.nextInt();
      adj[x].add(y);
      indeg[y]++;
    }
  }
  static void pro(){
    Deque<Integer> qDeque = new LinkedList<>();
    //제일 앞에 "정렬 될 수 있는 정점" 찾기
    for(int i = 1; i <= N; i++) if(indeg[i] == 0) qDeque.add(i);

      //정렬 될 수 있는 정점이 있다면?
      //1. 정렬 결과에 추가하기
      // 2. 정점과 연결된 간선 제거하기
      //3. 새롭게 "정렬 될 수 있는 정점" Queue에 추가하기
      while(!qDeque.isEmpty()){
        int x = qDeque.poll();
        sb.append(x).append(' ');
        for(int y: adj[x]){
          indeg[y] --;
          if (indeg[y] == 0) qDeque.add(y);
        }
      }
    System.out.println(sb);
  }
  public static void main(String[] args) {
    input();
    pro();
  }

  static class FastReader{
    StringTokenizer st;
    BufferedReader br;

    public FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
      while(st == null || !st.hasMoreElements()){
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