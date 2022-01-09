package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Boj_2470
public class TwoSolution_2470 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] a;

    static void input(){
        N = sc.nextInt();
        a = new int[N+1];
        for(int i=1;i<=N;i++){
            a[i] = sc.nextInt();
        }
    }
    static void pro(){
         Arrays.sort(a,1,N+1);
         int v1=0,v2=0, L=1,R=N;
         int best_sum = Integer.MAX_VALUE;
         while(L<R){
             if(best_sum>Math.abs(a[L]+a[R])){
                 best_sum = Math.abs(a[L]+a[R]);
                 v1 = a[L];
                 v2 = a[R];
             }
             if(a[L]+a[R]> 0) R--;
             else L++;
         }
         sb.append(v1).append(' ').append(v2);
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
