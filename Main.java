import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N,K;
    static int dist[];
    static boolean visit[];

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        dist = new int[100005];
        visit = new boolean[100005];
    }
    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        visit[N] = true;
        while(!Q.isEmpty()){
            int x = Q.poll();
            if(x-1>=0 && !visit[x-1]){
                dist[x-1] = dist[x]+1;
                visit[x-1] = true;
                Q.add(x-1);
            }
            if(x+1<=100000 && !visit[x+1]){
                dist[x+1] = dist[x] +1;
                visit[x+1] = true;
                Q.add(x+1);
            }
            if(2*x <=100000 && !visit[2*x]){
                dist[2*x] = dist[x] + 1;
                visit[2*x] = true;
                Q.add(2*x);
            }
        }
        System.out.println(dist[K]);
    }
    public static void main(String[] args) {
        input();
        bfs();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null || !st.hasMoreElements()){
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