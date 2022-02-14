import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라
//최소비용구하기
public class Boj_1916{

  static class Edge {
    public int to,weight;

    public Edge(int to, int weight){
      this.to = to;
      this.weight = to;
    }
  }
  static class Info {
    public int idx, dist;
    public Info() {}
    public Info(int idx, int dist) {
      this.idx = idx;
      this.dist = dist;
    }
 
  }
  static FastReader sc = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N,M,start, end;
  static int[] dist;
  static ArrayList<Edge>[] edges;

  static void input() {
    N = sc.nextInt(); M =sc.nextInt();
    dist = new int[N+1];
    edges = new ArrayList[N+1];
    for(int i = 1; i <= N; i++) { edges[i] = new ArrayList<>(); }
    for(int i = 1; i <= N; i++) {
      int from = sc.nextInt();
      int to = sc.nextInt();
      int weight = sc.nextInt();
      edges[from].add(new Edge(to, weight));
    } 
    start = sc.nextInt();
    end = sc.nextInt();
    
  }
  static void dijkstra(int start){
    //모든 정점까지에 대한 거리르 무한대로 초기화시켜야한다
    //문제의 정답으로 가능한 거리의 최대값보다 큰 값임을 보장해야 한다.
    for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

    //최소 힙생성
    PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
    //다른 방법 PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2) -> o1.dist - od2.dist);

    //시작점에 대한 정보(Info)를 기록해주고, 거리 배열(dist)에 갱신해준다.
    pq.add(new Info(start,0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Info info = pq.poll();

      // 꺼낸 정보가 최신정보랑 다르면, 의미없이 낡은 정보이므로 폐기한다.
      if (dist[info.idx] != info.dist) continue;

      // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
      for (Edge e: edges[info.idx]) {
        if( dist[info.idx] + e.weight >= dist[e.to]) continue;

        //e.to까지 갈 수 있는 더 짧은 거리를 찾았다면, 이에대한 정보를 갱신하고 pq에 기록해준다.
        dist[e.to] = dist[info.idx] + e.weight;
        pq.add(new Info(e.to, dist[e.to]));
      }

    }
  }
  static void pro(int start){
    dijkstra(start);
    System.out.println(dist[end]);
  }
  public static void main(String[] args) {
    input();
    pro(1);
  }

  static class FastReader{
    BufferedReader br; 
    StringTokenizer st;

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