package al_22_06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_보물섬 {
    static Scanner sc  = new Scanner(System.in);
    static int N,M;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static String[] map;
    static int ans;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        map = new String[N];
        for (int i = 0; i < N; i++){
            map[i] = sc.next();
        }
    }
    static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] checked = new boolean[N][M];
        queue.add(new Node(x,y,0));
        checked[x][y] = true;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            x = node.x;
            y = node.y;
            int cnt = node.cnt;
            ans = Math.max(cnt,ans);

            for (int k = 0; k < 4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                int Ncnt = cnt+1;
                if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
                if(checked[nx][ny]) continue;;
                if(map[nx].charAt(ny)=='W')continue;
                queue.add(new Node(nx,ny,Ncnt));
                checked[nx][ny] = true;
            }
        }

    }
    static class Node{
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt =cnt;
        }
    }
    public static void main(String[] args) {
        input();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i].charAt(j) == 'L') {
                    bfs(i,j);
                }

            }
        }
        System.out.println(ans);
    }
}
