import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, budget;
    static int[] arr;
    static int ans;

    static void input(){
        N = scan.nextInt();
        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = scan.nextInt();
        }
        budget = scan.nextInt();
    }

    static boolean determinant(int k){
        int sum = 0;
        for(int i=1 ; i<=N; i++){
            sum += Math.min(arr[i], k);
        }
        return sum <= budget;
    }
    static void pro(){
        int L = 0, R = 1000000000;
        while(L<=R){
            int mid = (L+R)/2;
            if(determinant(mid)){
                ans = mid;
                L = mid + 1;
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

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null || !st.hasMoreElements()){
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