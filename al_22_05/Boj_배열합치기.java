package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 11728 투포인터 문제
public class Boj_배열합치기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] A,B,ans;
    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N];
        B = new int[M];
        ans = new int[N+M];
        for(int i = 0; i < N; i++){
            A[i] = scan.nextInt();

        }
        for(int i =0; i<M; i++){
            B[i] = scan.nextInt();
        }

    }
    static void pro(){
        int L = 0, R = 0,idx=0;
        // a와 b를 앞에서부터 하나씩 추출해서 출력한다.
        while (L < N && R < M) {
            if(A[L] < B[R]) sb.append(A[L++]).append(' ');
            else sb.append(B[R++]).append(' ');
        }
        while (L < N) sb.append(A[L++]).append(' ');
        while (R < M) sb.append(B[R++]).append(' ');

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
