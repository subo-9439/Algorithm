package al_22_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//9251
/*
* dp(i-1 j) , dp(i , j-1) 중에 가장 큰값을 넣어준다.
* 또는 i== j 일 때는 dp[i][j] = dp[i-1][j-1] + 1 을 해준다.
* */
public class Boj_LCS {
    static FastReader scan = new FastReader();
    static char[] chaArr1;
    static char[] chaArr2;
    static int[][] dp;
    static void input(){
        chaArr1 = scan.next().toCharArray();
        chaArr2 = scan.next().toCharArray();
        dp = new int[chaArr1.length+1][chaArr2.length+1];
    }
    static void pro(){
        for (int i = 0; i < chaArr1.length; i++){
            for (int j = 0; j < chaArr2.length; j++){
                if(chaArr1[i] == chaArr2[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[i].length; j++){
                max = Math.max(max,dp[i][j]);
            }
        }
        System.out.println(max);
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
