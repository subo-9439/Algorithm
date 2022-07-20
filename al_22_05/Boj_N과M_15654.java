package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 15654 순열 응용
public class Boj_N과M_15654 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] arr, ans;
    static boolean[] checked;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N];
        ans = new int[M];
        checked = new boolean[N];
        for (int i = 0; i < N; i++) arr[i] = scan.nextInt();
        Arrays.sort(arr);
    }
    static void permutation(int idx, int cnt){
        if(cnt == M) {
            for (int i = 0; i < M; i++)  sb.append(ans[i]).append(" ");
            sb.append("\n");
        }else {
            for (int i = 0; i < N; i++){
                if(checked[i]) continue;
                ans[idx] = arr[i];
                checked[i] = true;
                permutation(idx+1,cnt+1);
                checked[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        //입력단
        input();
        //로직
        permutation(0,0);
        System.out.println(sb);
    }


    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null|| !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return  st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
