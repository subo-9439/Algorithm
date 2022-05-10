package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11052
public class Boj_카드구매하기 {
    static FastReader scan = new FastReader();
    static int N;
    static int[] arr, dp;
    static void input(){
        N = scan.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];
        for(int i = 1 ; i < arr.length;i++) arr[i] = scan.nextInt();
    }
    public static void main(String[] args)   {
        input();
        for(int i =1 ; i < N+1;i++) { //4
            for(int j=1 ; j<=i;j++) { // 1~4
                dp[i] = Math.max(dp[i],arr[j]+dp[i-j]);
            }

        }

        System.out.println(dp[N]);

    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
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
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
