package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_2667 {
  static Scanner sc = new Scanner(System.in);
  static StringBuilder sb = new StringBuilder();
  static int N,group_cnt;
  static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
  static boolean visit[][];
  static String[] row;
  static ArrayList<Integer> group;
  static void input(){
    N = sc.nextInt();
    row = new String[N];
    for(int i = 0; i < N; i++){
      row[i] = sc.nextLine();
    }
    visit = new boolean[N][N];
  }
  static void dfs(int x, int y){
    group_cnt++;
    visit[x][y] = true;
    for(int k = 0; k < 4; k++){
      int nx = x + dir[k][0];
      int ny = y + dir[k][1];
      if(nx<0||ny<0||nx>=N||ny>=N)continue;
      if(row[nx].charAt(ny) == '0') continue;
      if(visit[nx][ny]) continue;
      dfs(nx, ny);
    }
  }
  static void pro(){
    group = new ArrayList<>();
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        if(!visit[i][j] && row[i].charAt(j)=='1'){
          group_cnt=0;
          dfs(i,j);
          group.add(group_cnt);
        }
      }
    }

    Collections.sort(group);
    sb.append(group.size()).append('\n');
    for(int cnt:group)sb.append(cnt).append('\n');
    System.out.println(sb.toString());
  }
  public static void main(String[] args) {
    input();
    pro();
  }
}
