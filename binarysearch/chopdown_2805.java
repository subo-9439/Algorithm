package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chopdown_2805 {
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] arr;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1];
        for(int i=1; i<=N;i++){
            arr[i] = sc.nextInt();
        }
    }
    static boolean determinant(int H){
        //H높이로 나무들을 잘랐을 때, M만큼을 얻을 수 있으면
        long sum = 0;
        for(int i=1; i<=N ; i++){
            if(arr[i]>H){
                sum += arr[i]-H;
            }
        }
        return sum>= M;
    }
    static void pro(){
        long L = 0, R = 1000000, ans =0;
        while(L<= R){
            int mid = (int)(L+R)/2;
            if(determinant(mid)){
                ans = mid;
                L = mid+1;
            }else {
                R = mid-1;
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
            while (st==null||!st.hasMoreElements()){
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
        long nextLong(){
            return Long.parseLong(next());
        }

    }
}
