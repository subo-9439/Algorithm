package al_22_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    투포인터문제 어렵게 생각하지말자
    있는그대로 구현하면된다.
*/
public class Boj_귀여운라이언 {
    static FastReader scan = new FastReader();
    static int N,K;
    static int MIN = -1;
    static int[] nums;
    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        nums = new int[N];
        for(int i = 0 ; i < N; i++){
            nums[i] = scan.nextInt();
        }
    }
    static void pro(){
        int R = 0, lion = 0;
        for(int L = 0 ; L < N; L++){
            while (R < N && lion < K){
                //R이 1인가
                if(nums[R] == 1) lion++;
                R++;
            }


            if(lion == K){
                if(MIN == -1) MIN = R-L;
                MIN = Math.min(R-L,MIN);
            }

            if(nums[L] == 1) lion--;

        }
    }
    public static void main(String[] args) {
        input();
        pro();
        System.out.println(MIN);

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
