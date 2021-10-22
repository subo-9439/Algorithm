package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Gridirion_2667 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static ArrayList<Integer> group;

    static void input(){
        stat
        N = sc.nextInt();
        a = new String[N];
        for(int i = 0; i<N; i++){
            a[i] = sc.nextLine();
        }
        visit = new boolean[N][N];
    }
    static void dfs(int x, int y){
        group_cnt++;
        visit[x][y] = true;
        for(int k=0;k<4;k++){
            int nx = x+dir[k][0];
            int ny = y+dir[0][k];
            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            if(a[nx].charAt(ny)=='0') continue;
            if(visit[nx][ny]) continue;
            dfs(nx,ny);
        }
    }
    static void pro() {
        group = new ArrayList<>();
        for(int i=0; i<N;i++){
            for(int j=0; j<N;j++){
                if(!visit[i][j] && a[i].charAt(j) == '1'){
                    group_cnt=0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for(int cnt:group) sb.append(cnt).append('\n');
        System.out.println(sb);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st==null||!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }


        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
