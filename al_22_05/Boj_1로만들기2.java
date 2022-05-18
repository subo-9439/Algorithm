package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Boj_ 12852 dp문제 실버1
//일단 항상 dp[i-1]의 값은 젤크므로 첨부터 연산이 들어간다.
// i/3과 i/2의 값을 비교해보고 min값 넣어주기
public class Boj_1로만들기2 {
    static FastReader scan = new FastReader();
    static int N;
    static int[] dp;
    static int[] step;
    static void input(){
        N = scan.nextInt();
        dp = new int[N+1];
        step = new int[N+1];
        dp[1] = 1;
    }

    public static void main(String[] args) {
        input();
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1]+1;
            step[i] = i-1;
            if(i%3 == 0 ){
                if(dp[i]>dp[i/3]+1){
                    dp[i] = Math.min(dp[i],dp[i/3]+1);
                    step[i] = i/3;
                }
            }
            if(i%2 ==0){
                if(dp[i] > dp[i/2]+1) {
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                    step[i] = i / 2;
                }
            }
        }
        System.out.println(dp[N]-1);
        for(int i = N; i>0;){
            if(i == 1) {
                System.out.print(i);
                break;
            }
            System.out.print(i+" ");
            i = step[i];
        }
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
