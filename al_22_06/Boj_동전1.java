package al_22_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_동전1 {
    static FastReader scan = new FastReader();
    static int N, K;
    static int[] arr;
    static int[] dp;
    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        arr = new int[N];
        dp = new int[K+1];       //10 +1
        for (int i = 0; i < N; i++) arr[i] = scan.nextInt();
    }
    static void pro(){
        Arrays.sort(arr);
        for (int coinIdx = 0; coinIdx < arr.length; coinIdx++){
            int coin = arr[coinIdx];
            for (int i = 0 ; i < dp.length; i++){
                if(i == coin) dp[i]++;
                else if(i > coin) dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[K]);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while (st==null ||!st.hasMoreTokens()){
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
