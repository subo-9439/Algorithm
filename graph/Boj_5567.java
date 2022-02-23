package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//백준 5567
//결혼식 Lv실버2
public class Boj_5567 {
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[] dist;
  static boolean[] visit;
  static ArrayList<Integer>[] adj;
  static ArrayList<Integer> group;

  static void input(){
    N = scan.nextInt(); M=scan.nextInt();
    dist = new int[N+1];
    visit = new boolean[N+1];
    group = new ArrayList<>();
    adj = new ArrayList[N+1];
    for(int i = 1; i<=N; i++) adj[i] = new ArrayList<>();
    for(int i = 1; i<=M; i++){
      int x = scan.nextInt(), y = scan.nextInt();
      adj[x].add(y);
      adj[y].add(x);
    }
  }
  static void bfs(){
    Queue<Integer> queue = new LinkedList<>();
    
    queue.add(1);
    visit[1] =true;
    while(!queue.isEmpty()){
      int x = queue.poll();
      for(int y: adj[x]){
        //방문한적있으면 continue
        if(visit[y]) continue;
        // bfs로 차수가 1이상 2이하인친구들만
        dist[y] = dist[x]+1;
        visit[y] = true;
        if(dist[y]<=2 && dist[y] > 0){
          group.add(y);
        }
        queue.add(y);
      }
    }
  }
  public static void main(String[] args) {
    input();
    bfs();
    System.out.println(group.size());

  }
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
      while(st==null || !st.hasMoreTokens()){
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
