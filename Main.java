import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
  static class Node{
    public int x;
    public int y;
    public int z;

    public Node(int x,int y, int z){
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }
  static FastReader scan = new FastReader();
  static int N,M,H;
  static int[][][] adj;
  static int[][] dir = {{1,0,0},{0,1,0},{0,0,1},{-1,0,0},{0,-1,0},{0,0,-1}};
  static int[][][] dist;

  static void input(){
    M = scan.nextInt();
    N = scan.nextInt();
    H = scan.nextInt();

    adj = new int[H][N][M];
    dist = new int[H][N][M];

    for(int h=0; h<H; h++){
      for(int n=0; n<N; n++){
        for(int m=0; m<M; m++){
          adj[h][n][m] = scan.nextInt();
          dist[h][n][m] = -1;
        }
      }
    }
  }

  static int pro(){
    //저장된 상태부터 모두 익었는가
    int cnt = 0;
    for(int h=0; h<H; h++){
      for(int n=0; n<N; n++){
        for(int m=0; m<M; m++){
          if(adj[h][n][m] != 0) cnt++;
        }
      }
    }
    if(cnt == H*N*M) return 0;

    //bfs
    for(int h=0; h<H; h++){
      for(int n=0; n<N; n++){
        for(int m=0; m<M; m++){
          if(dist[h][n][m]!= -1) continue; //방문한적있으면 통과
          if(adj[h][n][m] != 1) continue; // 익은곳에서만 bfs
          bfs(h,n,m);
        }
      }
    }
    int max = 0;
    for(int h=0; h<H; h++){
      for(int n=0; n<N; n++){
        for(int m=0; m<M; m++){
          //return
          //왜냐면 -1은 벽이잖아
          //벽은 거리가 -1로 초기화 되어있는데
          if(adj[h][n][m] == -1)continue;
          if(adj[h][n][m] == 0) return -1;
          max = Math.max(max, dist[h][n][m]); 
        }
      }
    }
    //return
    return max;
  }

  static void bfs(int x, int y, int z){
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x,y,z));
    dist[x][y][z] = 0;

    while(!queue.isEmpty()){
      Node node = queue.poll();
      x = node.x;
      y = node.y;
      z = node.z;

      for(int i=0; i<6; i++){
        int nx = x + dir[i][0];
        int ny = y + dir[i][1];
        int nz = z + dir[i][2];
        if(nx>=H || ny>=N || nz >= M || nx<0 || ny<0 || nz<0) continue;
        if(adj[nx][ny][nz] == -1) continue;//벽이면 통과
        if(dist[nx][ny][nz]==-1){        //처음 방문?
          dist[nx][ny][nz] = dist[x][y][z] + 1;
        }else{
          dist[nx][ny][nz] = Math.min(dist[nx][ny][nz], dist[x][y][z]+1);

        }
        queue.add(new Node(nx,ny,nz));
      }
    }

  }
  public static void main(String[] args) {
    input();
    System.out.println(pro());
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