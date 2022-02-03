import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] arr;
    static boolean[] visit;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i = 1; i <= M ; i++){
            int x = scan.nextInt(), y= scan.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }        
    }
    static void bfs(int x){
        int cnt = 1;
        ArrayList<Integer> a = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        visit[x] = true;
        while(!Q.isEmpty()){
            x = Q.poll();
            System.out.println(x);
            for(int y=1; y<=N; y++){
                if(visit[y]) continue;
                if(arr[x][y] == 0)continue;
                visit[y] = true;
                System.out.println(y);
                cnt++;
            }
        }
        a.add(cnt);
        System.out.println(cnt);
    }
    static void pro(){
        for(int i=1; i<=N; i++){
            if(visit[i]) continue;
            bfs(i);
        }
        
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