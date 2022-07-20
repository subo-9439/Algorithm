package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_구간합구하기4 {
    static FastReader scan = new FastReader();
    static int N, M;
    static int[] arr;
    static int[] dp;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i <= N;i++){
            arr[i] = scan.nextInt();
        }
    }

    static void pro(){
        for(int i = 1 ; i<=N ; i++){
            dp[i] = dp[i-1]+arr[i];
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        for(int i = 0; i < M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(dp[y]-dp[x-1]);
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st==null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
                return st.nextToken();
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
