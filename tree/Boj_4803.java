package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_4803 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m, vertex_cnt, edge_cnt;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    
    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        adj = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for(int i = 1; i <= n; i++)adj[i] = new ArrayList<>();

        //인접 리스트
        for(int i = 1; i <= m; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x) {
        vertex_cnt++;
        edge_cnt += adj[x].size();
        visit[x] = true;
        for(int y : adj[x]){
            if(visit[y]) continue;
            dfs(y);
        }
    }
    static void pro(int tt) {
        int ans = 0;
        for (int i = 1; i <=n ; i++){
            if(visit[i]) continue;
            vertex_cnt = 0;
            edge_cnt = 0;
            dfs(i);
            if(edge_cnt == (vertex_cnt - 1) * 2) ans++;
        }

        //정답 출력
        sb.append("Case ").append(tt).append(": ");
        if (ans == 0){
            sb.append("No trees.\n");
        } else if (ans == 1){
            sb.append("There is one tree.\n");
        } else {
            sb.append("A forest of ").append(ans).append(" trees.\n");
        }
    }
    public static void main(String[] args) {
        for(int tt = 1; ; tt++){
            input();
            if(n == 0 && m == 0 )break;
            pro(tt);
        }
        System.out.print(sb);
    }
    
    static class FastReader{
        static BufferedReader br;
        static StringTokenizer st;

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
