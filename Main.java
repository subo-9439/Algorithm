import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N,M;
    static int[] A;
    static void input(){
        N = scan.nextInt();
        A = new int[N+1];
        for(int i = 1; i <= N; i++){
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }
    static boolean determinant(long X){
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += A[i]-X;

        }
        return sum > M;
    }
    static void pro(){
        long L = 0, R = 1000000000, ans = 0;
        while(L <= R){
            long mid = (L+R)/ 2;
            if(determinant(mid)){
                L = mid + 1;
                ans = mid;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
    static class FastReader{
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}