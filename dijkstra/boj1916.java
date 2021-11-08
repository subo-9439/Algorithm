package dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1916 {
  
  static Scanner sc = new Scanner(System.in);
  static int N,M;
  static int start, end;
  static int[] dist;
  static ArrayList<Edge>[] edges;
  static StringBuilder sb = new StringBuilder();

  static class Edge{
    public int to, wegiht;

    public Edge(int to, int weight){
      this.to = to;
      this.wegiht = weight;
    }
  }
  static class Info {
    public int idx, dist;

    public Info() {
    }

    public Info(int idx, int dist){
      this.idx = idx;
      this.dist = dist;
    }
  }
  static void input(){
    //N = 5, M = 8;
    N = sc.nextInt();
    M = sc.nextInt();
    dist = new int[N + 1];
    edges = new ArrayList[N + 1];
    for(int i=1 ;i<=N; i++) edges[i] = new ArrayList<Edge>();
    for(int i=1; i<=M;i++){
      int from = sc.nextInt();
      int to = sc.nextInt();
      int weight = sc.nextInt();
      edges[from].add(new Edge(to, weight));
    }
    start = sc.nextInt();
    end = sc.nextInt();
  }

  static void dijkstra(int start){
    //모든 정점까지에 대한 거리를 무한대로 초기화 해주기.
    //문제의 정답으로 가능한 거리의 최대값보다 큰 값임을 보장해야함
    //int? long? double?
    for(int i = 1; i<=N; i++) dist[i] = Integer.MAX_VALUE;

    //최소 힙 생성
    PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
    //다른 방법 PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

    //시작점에 대한 정보(Information)을 기록에 추가하고, 거리배열(dist)에 갱신해준다.
    pq.add(new Info(start, 0));
    dist[start] = 0;

    //거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
    while (!pq.isEmpty()){
      Info info = pq.poll();

      //꺼낸 정보가 최신정보랑 다르면, 의미 없이 낡은 정보이기때문에 폐기한다.
      if(dist[info.idx] != info.dist) continue;
      //연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
      
      //e.to까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신해주고 PQ에 기록해준다.

    }


  }

  static void pro(){
    dijkstra(start);
    System.out.println(dist[end]);
  }

  public static void main(String[] args){
    input();
    pro();
  }
}
