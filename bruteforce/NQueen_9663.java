package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NQueen_9663 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] nums;
    static int[] selected;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N+1];
        selected = new int[M+1];
        for(int i=1; i<=N; i++){
            nums[i]= scan.nextInt();
        }
    }
    static void rec_func(int k){
        for(int cand=1;cand<=M;cand++){
//            if()
            selected[k] = cand;
            rec_func(k+1);
            selected[k] = 0;
        }
    }
    public static void main(String[] args) {
        input();
        Arrays.sort(nums);
        rec_func(1);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
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
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str="";
            try {
                str= br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
