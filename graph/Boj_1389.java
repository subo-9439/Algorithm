package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1389 케빈 베이커의 6단계 법칙
public class Boj_1389 {

  static FastReader scan = new FastReader();
  static int N,M;
  static ArrayList<Integer>[] adj;
  static int[] dist;

  static void input(){
    N = scan.nextInt();
    M = scan.nextInt();
    adj = new ArrayList[N+1];
    for(int i = 1; i <= N; i++){
      adj[i] = new ArrayList<>();
    }
    for(int i = 1 ; i <= M; i++){
      int x = scan.nextInt(), y= scan.nextInt();
      adj[x].add(y);
      adj[y].add(x);
    }
  }
  static void pro(){
    dist = new int[N + 1];
    int minV = bfs(1), minIdx = 1;
    for(int i = 2; i<= N; i++){
      int v = bfs(i);
      if(v < minV){
        minV = v;
        minIdx = i;
      }
    }
    System.out.println(minIdx);
  }
  static int bfs(int start){
    int res = 0;
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 1; i <=N; i++) dist[i] = -1;
    //start는 방문 가능한 점이므로 queue에 넣어준다.
    queue.add(start);
    dist[start] = 0;
    while(!queue.isEmpty()){
      int x = queue.poll();
      res += dist[x];
      for(int y: adj[x]){
        if (dist[y] != -1) continue;//x에서 y를 갈 수 있지만, 이미탐색한 점이면 무시
        queue.add(y);
        dist[y] = dist[x] + 1;
      }
    }
    return res;
  }
  public static void main(String[] args){
    input();
    pro();
  }
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
      while(st==null||!st.hasMoreTokens()){
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
