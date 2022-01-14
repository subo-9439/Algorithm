import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N,M;
    static int[] cards, finds;
    static void input(){
        N = scan.nextInt();
        cards = new int[N+1];
        for(int i=1; i<=N; i++){
            cards[i] = scan.nextInt();
        }
        //
        M = scan.nextInt();
        finds = new int[M];
        for(int i=0; i<M ;i++){
            finds[i] = scan.nextInt();
        }

        
    }
    static int lower_bound(int[] arr, int L, int R, int X){
        int ans = R + 1;
        while(L <= R){
            int mid = (L+R)/2;
            if(arr[mid] >= X) {
                R = mid - 1;
                ans = mid;
            }else{
                L = mid + 1;
            }
        }
        return ans;
    }
    static int upper_bound(int[] arr, int L, int R, int X){
        int ans = R + 1;
        while(L <= R) {
            int mid = (L+R)/2;
            if(arr[mid] > X){
                R = mid - 1;
                ans = mid;
            }else {
                L = mid + 1;
            }

        }
        return ans;
    }
    static void pro(){
        Arrays.sort(cards,1,N+1);
        for(int find:finds){
            int upper = upper_bound(cards, 1, N, find);
            int lower = lower_bound(cards, 1, N, find);
            sb.append(upper-lower).append(' ');
            }
        System.out.println(sb);
    }
    public static void main(String[] args){
        input();
        pro();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
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