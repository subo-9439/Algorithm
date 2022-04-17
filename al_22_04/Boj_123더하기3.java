package al_22_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 백준 15988 실버2
* dp자료형 조심
* */
public class Boj_123더하기3 {
    static FastReader scan = new FastReader();
    static StringBuilder sb=  new StringBuilder();

    static int T,  MOD = 1000000009;
    static long[] dp;

    static void input(){
        T= scan.nextInt();
        dp = new long[1000005];

    }
    static void pro(){
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 1000000; i++){
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) % MOD ;
        }
        while (T-- > 0) {
            int N = scan.nextInt();
            sb.append(dp[N]).append('\n');
        }
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
            while (st==null||!st.hasMoreTokens()){
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
