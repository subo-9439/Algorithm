package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UniquNumbers_13144 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N ;
    static int[] arr, cnt;

    static void input(){
        N = sc.nextInt();
        arr = new int[N+1];
        for (int i=1; i<=N;i++){
            arr[i] = sc.nextInt();
        }
        cnt = new int[100000+1];
    }
    static void pro() {
        long ans =0;
        for(int L=1,R=0; L<=N;L++){
            while (R+1<=N && cnt[arr[R+1]] == 0){
                //증가먼저
                R++;

                cnt[arr[R]]++;
            }
            ans += R-L+1;
            cnt[arr[L]]--;

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
