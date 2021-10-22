package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class subplus_1806 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;
    static int[] a;

    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();
        a = new int[N+1];
        for(int i=1;i<=N;i++){
            a[i] = sc.nextInt();
        }
    }

    static void pro(){
        int R=0,sum=0, ans=N+1;
        for(int L=1;L<N+1;L++){
            sum-= a[L-1];
            while (R+1 <= N && sum<S) sum+=a[++R];
            if(sum>=S) ans = Math.min(ans,R-L+1);
        }
        if(ans==N+1) ans=0;
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
            while(st==null||!st.hasMoreElements()){
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
