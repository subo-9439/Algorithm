package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*백준 2230 골드5
N개의 정수 중에 정렬을 하여 수 두개를 골라 차이가 M이상이 될 때 를 구한다.
그 떄의 가장 작은 차이는 ?

*/
public class Boj_수고르기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N,M,ans=Integer.MAX_VALUE;
    static int[] nums;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N];

        for(int i = 0; i < N; i++) nums[i] = scan.nextInt();

    }

    static void pro(){
        int right = 0;

        for(int left = 0; left < N-1; left++){
            while (right<N-1 && nums[right]-nums[left] < M){
                right++;
            }
            if(nums[right]-nums[left] >= M) ans = Math.min(ans,nums[right]-nums[left]);
            if(ans == M )break;
        }
        sb.append(ans);

    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums);
        pro();
        System.out.println(sb);
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st==null ||!st.hasMoreTokens()){
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
