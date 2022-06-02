package al_22_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//투포인터로 풀기
public class Boj_내뒤에너와다른수 {
    static FastReader scan = new FastReader();
    static int N;
    static int[] arr;
    static int[] ans;
    static void input(){
        N = scan.nextInt();
        arr = new int[N+1];
        ans = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = scan.nextInt();
    }
    static void pro(){
        StringBuilder sb = new StringBuilder();
        int R = 1;
        for (int L = 1 ; L <= N && R <= N; ){
            if(arr[L] != arr[R]){
                ans[L] = R;
                L++;
            }else {
                R++;
            }
        }
        for (int i = 1; i <= N; i++){
            if (ans[i] == 0) ans[i] = -1;
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());

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
