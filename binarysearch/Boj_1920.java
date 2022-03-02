package binarysearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;
    static int M;
    static int[] B;
    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        for(int i=1; i<=N; i++){
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B = new int[M+1];
        for(int i=1; i<=M; i++){
            B[i] = scan.nextInt();
        }

    }
    static int lower_bound(int[] A, int L, int R, int X){

        while(L <= R){
            int mid = (L+R)/2;
            if(A[mid] == X){
                return 1;
            }
            if(A[mid] < X){
                L = mid + 1;
            }else{
                R = mid - 1;
            }

        }
        return 0;
        
    }
    static void pro() {
        Arrays.sort(A,1,N+1);
        for(int i=1; i<=M; i++){
            sb.append(lower_bound(A, 1, N, B[i])).append('\n');
        }
        System.out.println(sb);

    }
    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()){
                try{

                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
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