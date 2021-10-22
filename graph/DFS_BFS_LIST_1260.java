package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_BFS_LIST_1260 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M,V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        adj = new ArrayList[N+1];
        for(int i=1; i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=1;i<=M;i++){
            int x = sc.nextInt(),y=sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }
    static void pro(){

    }


    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st == null ||!st.hasMoreElements()){
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
