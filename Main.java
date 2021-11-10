import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, start;
    static int[][] adj;
    static boolean[] check;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        start = sc.nextInt();
        adj = new int[N+1][N+1];
        check = new boolean[N+1];

        for(int i=0;i<M;i++){
            int x = sc.nextInt(), y= sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }
    static void dfs(int x){
        check[x] = true;
        sb.append(x).append(' ');
        for(int i = 1; i <= N; i++){
            if(adj[x][i] == 0)continue;
            if(check[i])continue;
            dfs(i);
        }
    }  
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
        
        while(!q.isEmpty()){
            int x = q.poll();

            sb.append(x).append(' ');
            for(int y=1; y<=N; y++){
                if(check[y]) continue;
                if(adj[x][y] == 0) continue;
                q.add(y);
                check[y] = true;
            }
        }

    }
    public static void main(String[] args) {
        input();
        dfs(start);
        for(int i=1;i<=N;i++)check[i] = false;
        // bfs(start);
        sb.append('\n');
        bfs(start);
        System.out.println(sb);
    }
    static class FastReader{
        BufferedReader br ;
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