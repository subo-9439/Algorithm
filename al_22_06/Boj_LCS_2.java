package al_22_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//9252
/*
 * dp(i-1 j) , dp(i , j-1) 중에 가장 큰값을 넣어준다.
 * 또는 i== j 일 때는 dp[i][j] = dp[i-1][j-1] + 1 을 해준다.
 * */
public class Boj_LCS_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static char[] chaArr1;
    static char[] chaArr2;
    static int[][] dp;
    static char[] s;
    static void input(){
        chaArr1 = scan.next().toCharArray();
        chaArr2 = scan.next().toCharArray();
        dp = new int[chaArr1.length+1][chaArr2.length+1];
    }
    static void pro(){
        int max = 0;
        for (int i = 0; i < chaArr1.length; i++){
            for (int j = 0; j < chaArr2.length; j++){
                if(chaArr1[i] == chaArr2[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
                max = Math.max(max,dp[i+1][j+1]);
            }
        }
        String a = String.valueOf(chaArr1);
        String b = String.valueOf(chaArr2);

        sb.append(max).append("\n");
        getLcsToString(a,a.length(),b.length());

        System.out.println(sb.toString());

    }

    //거꾸로 생각하면 편함
    static void getLcsToString(String str,int str1Len, int str2Len){
        Stack<Character> st = new Stack<>();
        while (str1Len > 0 && str2Len > 0) {
//            if(str1Len == 0 || str2Len  == 0 )break;

            if (dp[str1Len][str2Len] == dp[str1Len-1][str2Len]){
                str1Len--;
            }else if(dp[str1Len][str2Len] == dp[str1Len][str2Len-1]){
                str2Len--;
            }else {
                st.push(str.charAt(str1Len-1));
                str1Len--;
                str2Len--;
            }
        }
        while (!st.isEmpty()){
            sb.append(st.pop());
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
