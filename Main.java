import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N ,curCnt, modeCnt;
    static long mode;
    static long[] nums;
    static void input(){
        N = sc.nextInt();
        nums = new long[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextLong();
        }
    }
    static void pro(){
        Arrays.sort(nums);
        for(int i=0; i<N; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                curCnt = 1;
            }else{
                curCnt++;
            }
            if(curCnt > modeCnt){
                modeCnt = curCnt;
                mode = nums[i];
            }
        }
        sb.append(mode);
        System.out.println(sb);
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
            while(st == null || !st.hasMoreElements()){
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
        long nextLong(){
            return Long.parseLong(next());
        }
    }
}