package al_22_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 너무 편협한 사고로만 dfs를 풀어온거같다.
* 이 문제는 사고를 좀 바꿔야한다.
* 한 점에 대해서 dfs를 하는데 같은 높이일 때만 dfs를 돌게 하면 된다.
* 그럼 그 주변의 같은높이는 visited처리가 된다.
* 구역을 묶어준다는 개념이다 ㄷㄷ
* */
public class Boj_농장관리 {

    static FastReader scan = new FastReader();
    static int N,M;
    static int[][] map;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static boolean[][] visited;
    static boolean isPeak;
    public static void main(String[] args) {
        input();
        pro();
    }
    static void pro(){
        int cnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if(visited[i][j]) continue;
                isPeak = true;
                dfs(i,j);
                if(isPeak) cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for (int k = 0 ; k <8; k++){
            int nx = x+ dir[k][0];
            int ny = y+ dir[k][1];
            if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
            if(map[nx][ny] > map[x][y]) isPeak = false;
            if(!visited[nx][ny] && map[nx][ny] == map[x][y]){
                dfs(nx,ny);
            }
        }
    }
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N ; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = scan.nextInt();
            }
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null|| !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
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
