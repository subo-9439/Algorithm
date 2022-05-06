package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

//백준 실버1 2468 dfs문제

public class Boj_안전영역 {
    static int N;
    static FastReader scan = new FastReader();
    static boolean[][] visited;
    static int[][] map;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int maxHeight = 0;
    static ArrayList<Integer> group = new ArrayList<>();
    static void input(){
        N = scan.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = scan.nextInt();
                if(map[i][j] > maxHeight) maxHeight = map[i][j];
            }
        }
    }

    static void pro(){
        for(int h = 0; h < maxHeight; h++){
            int cnt = 0;
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] <= h) continue;
                    if(visited[i][j]) continue;
                    dfs(i,j,h);
                    cnt++;
                }
            }
            group.add(cnt);
        }
        Integer res = group.stream().mapToInt(x ->x).max().orElseThrow(NoSuchElementException::new);
        System.out.println(res);
    }
    static boolean dfs(int x, int y, int h){
        visited[x][y] = true;
        for (int i =0 ; i < 4; i++){
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if(dx >= N || dy >= N || dx<0 || dy < 0)continue;
            if(visited[dx][dy]) continue;
            if(map[dx][dy] <= h) continue;
            dfs(dx,dy,h);
        }
        return true;
    }
    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st ==null || !st.hasMoreTokens()){
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
