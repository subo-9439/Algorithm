package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 20165 
//인내의 도미노 장인 호석
public class Boj_20165 {

  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N,M,R;
  //E = {0,1} W {-1 0} S {1,0} N {-1,0}
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static int[][] adj;
  static boolean[][] visited;
  static String[][] map;
  static int cnt;

  static void input(){
    N = scan.nextInt();
    M = scan.nextInt();
    R = scan.nextInt();
    adj = new int[N+1][M+1];
    map = new String[N+1][M+1];
    for(int i = 1; i<=N; i++){
      for(int j =1; j<=M; j++){
        adj[i][j] = scan.nextInt();
        map[i][j] = "S";
      }
    }
  }
  static int directionX(int x,String S){
    if(S.equals("E")) return x + dir[0][0];
    else if(S.equals("W")) return x + dir[1][0];
    else if(S.equals("S")) return x + dir[2][0];
    else return x + dir[3][0];
  }
  static int directionY(int y,String S){
    if(S.equals("E")) return y + dir[0][1];
    else if(S.equals("W")) return y + dir[1][1];
    else if(S.equals("S")) return y + dir[2][1];
    else return y + dir[3][1];
  }
  static void dfs(int x, int y, String S, int value){
    if(map[x][y].equals("S")) {
      cnt++;
    }

    map[x][y] = "F";
    int nx = directionX(x, S);
    int ny = directionY(y, S);
    if(nx>N || ny > M || nx<1 || ny < 1) return;
    if(value == 1) return;
    if(map[nx][ny].equals("S")&& value-1 < adj[nx][ny]){
      value = adj[nx][ny];
      dfs(nx, ny, S, value);
    }else{
      dfs(nx, ny, S, value-1);
    }
  }
  static void pro(){
    for(int i=0; i<R; i++){
      //공격
      int x = scan.nextInt(), y= scan.nextInt();
      String S = scan.next();
      dfs(x,y,S,adj[x][y]);
      //수비
      x = scan.nextInt(); y = scan.nextInt();
      map[x][y] = "S";
    }
    System.out.println(cnt);
    for(int i = 1; i<=N; i++){
      for(int j =1; j<=M; j++){
        System.out.print(map[i][j]+' ');
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    input();
    pro();
  }
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;

    FastReader(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
      while(st==null|| !st.hasMoreElements()){
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