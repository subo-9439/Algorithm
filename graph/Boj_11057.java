package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sort.sort_1015;

public class Boj_11057 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] dp;
    static int[] A;

    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        dp = new int[N+1][10];
    }

    static void pro(){
        //초기값
        for(int num = 0; num <= 9; num++){
            dp[1][num] = 1;
        }
        //점화식을 토대로 dp 배열 채우기
        for(int len = 2; len <= N; len++){
            for(int num = 0; num <= 9; num++){
                //길이가 len이고 num으로 끝나는 개수를 계산하자 == dp[len][num] 을 계산
                for(int prev = 0; prev <= num; prev++){
                    dp[len][num] += dp[len-1][prev];
                    dp[len][num] %= 10007;
                }
            }
        }

        //dp배열로 정답 도출
        int ans = 0;
        for(int num = 0; num <= 9; num++){
            ans += dp[N][num];
            ans %= 10007;
        }
        System.out.println(ans);
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
