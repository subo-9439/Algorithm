package graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek{
  static Scanner sc = new Scanner(System.in);
  static int N,K ;
  static int[] dist;
  static boolean[] visit;
  //x-1 x+1
  //2*x
  //가장 빠른시간
  // 5 17
  //5 - 10 - 9 - 18 - 17
  static void input(){
    N = sc.nextInt();
    K = sc.nextInt();
    dist = new int[100005];
    visit = new boolean[100005];
  }
  static void bfs(){
    Queue<Integer> Q = new LinkedList<>();
    Q.add(N);
    visit[N] = true;
    dist[N] = 0;

    //BFS과정
    while(!Q.isEmpty()){
      int x = Q.poll();
      if(x-1>=0 && !visit[x-1]){
        visit[x-1] = true;
        dist[x-1] = dist[x]+1;
        Q.add(x-1);
      }
      if(x+1 <= 100000 && !visit[x+1]){
        visit[x+1] = true;
        dist[x+1] = dist[x] + 1;
        Q.add(x + 1);
      }
      if(x * 2<=100000 && !visit[2*x]){
        visit[2*x] = true;
        dist[2*x] = dist[x]+1;
        Q.add(2*x);
      }
    }
  }
  static void pro(){
    bfs();
    System.out.println(dist[K]);
  }
  public static void main(String[] args) {
    input();
    pro();
  }
}