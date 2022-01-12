import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A,B;
    static int cnt = 0;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        
        A = new String[N+1];
        B = new String[M+1];

        for(int i=1; i<=N; i++){
            A[i] = scan.nextLine();
        }
        for(int i=1; i<=M ;i++){
            B[i] = scan.nextLine();
        }
    }
    static boolean pro(String[] B, int L, int R, String A){
        while(L<=R){
            int mid = (L+R)/2;
            if(B[mid].compareTo(A) == 0){
                cnt++;
                return true;
            }

            if(B[mid].compareTo(A) < 0){
                L  = mid + 1;
            }else{
                R = mid -1;
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        input();
        Arrays.sort(B,1,M+1);
        Arrays.sort(A,1,N+1);
        for(int i=1; i<=N; i++){
            if(pro(B,1,M,A[i])){
                sb.append(A[i]).append('\n');
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
    static class FastReader { 
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch( IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try{
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}