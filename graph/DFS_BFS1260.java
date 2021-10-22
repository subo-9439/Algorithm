package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS1260 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M,V;
    static int adj[][];
    static boolean visit[];
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        adj = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            int x=sc.nextInt(),y= sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }
    static void dfs(int node){

        visit[node] = true;
        sb.append(node).append(' ');

        for(int y=1;y<=N;y++){
            if(adj[node][y]==0) continue;
            if(visit[y]) continue;
            dfs(y);
        }
    }
    static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        visit[node] = true;

        while (!que.isEmpty()){
            node = que.poll();
            sb.append(node).append(' ');
            for(int y=1; y<=N;y++){
                if(adj[node][y]==0)continue;
                if(visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }

        }
    }
    static void pro(){
        visit = new boolean[N+1];
        dfs(V);
        for(int i=1;i<=N;i++) visit[i] = false;
        bfs(V);
        System.out.println(sb.toString());
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
            while (st==null || !st.hasMoreElements()){
                try{
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
                str =br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}