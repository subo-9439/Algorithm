import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int T,M,N,cnt;
    static int group_cnt;
    static ArrayList<Integer> group;

    static int[][] arr;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] visit;
    static void input(){
        T = sc.nextInt();
        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N][M];
        for (int i=0;i<cnt;i++){
            int x = sc.nextInt(),y = sc.nextInt();
            arr[x][y] = 1;
        }
        visit = new boolean[N][M];
    }
    static void dfs(int x, int y){
        visit[x][y]=true;
        group_cnt++;
        for (int k=0; k<4;k++){
            int nx = x+dir[k][0];
            int ny = y+dir[k][1];
            if(nx<0||ny<0||nx>=M||ny>=N)continue;
            if(visit[x][y]) continue;
            if(arr[nx][ny] == 0) continue;
            dfs(nx,ny);
        }

    }
    static void pro(){
        group = new ArrayList<>();
        for(int i=0;i<M;i++){
            for(int j=0; j<N;j++){
                if(visit[i][j])continue;
                group_cnt =0;
                dfs(i,j);
                group.add(group_cnt);
            }
        }
        System.out.println(group.size());
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}