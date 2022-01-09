import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb= new StringBuilder();
    static int N, M;
    static int[] arrA, arrB;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arrA = new int[N+1];
        arrB = new int[N+1];
        for(int i=1; i<=N; i++){
            arrA[i] = scan.nextInt();
        }
        for(int i=1; i<=M; i++){
            arrB[i] = scan.nextInt();
        }
    }
    static int lower_bound(int[] B, int L, int R, int A){
        int result = L-1;
        while (L <= R){
            int mid = (L+R) / 2;
            if(B[mid] < A){
                L = mid +1;
                result = mid;
            }else {
                R = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 0; t < T; t++){
            int cnt = 0;
            input();
            Arrays.sort(arrB,1,M);
            for(int n = 1; n <= N; n++){
                cnt += lower_bound(arrB, 1, M, arrA[n]);
            }
            System.out.println(cnt);

        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        String nextLine() {
            String st = "";
            try {
                st = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st;
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}