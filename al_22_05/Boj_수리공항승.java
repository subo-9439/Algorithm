package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOj 1449 실버3
//
public class Boj_수리공항승 {
        static FastReader scan = new FastReader();
        static int N,L;
        static int[] arr;

        static void input(){
            N = scan.nextInt();
            L = scan.nextInt();
            arr = new int[N];
            for(int i = 0; i < N ; i++) arr[i] = scan.nextInt();

        }
        static void pro(){
            int cnt = 1;
            int tape = 0;
            int i = 0;
            for(; i < N-1; i++){
                tape += arr[i+1] - arr[i];
                if(tape<=L-1) continue;
                tape = 0;
                cnt++;
            }
            System.out.println(cnt);

        }
        public static void main(String[] args) {
            input();
            Arrays.sort(arr);
            pro();
        }

        static class FastReader{
            BufferedReader br;
            StringTokenizer st;

            public FastReader(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            String next(){
                while (st == null || !st.hasMoreTokens()){
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
