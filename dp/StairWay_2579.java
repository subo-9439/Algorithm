package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StairWay_2579{
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] stair;
    static int[][] Dy;

    static void input(){
        N = sc.nextInt();
        stair = new int[N + 1];
        Dy = new int[N + 1][2];
        for(int i = 1; i<=N; i++){
            stair[i] = sc.nextInt();
        }

    }
    static void pro(){
        //초기값 구하기
        Dy[1][0] = 0;
        Dy[1][1] = stair[1];
        if(N >= 2){
            Dy[2][0] = stair[2];
            Dy[2][1] = stair[2] + stair[1];
        }

        //점화식
        for(int i = 3; i<=N; i++){
            Dy[i][0] = Math.max(Dy[i-2][0] + stair[i] , Dy[i-2][1] + stair[i]);
            Dy[i][1] = Dy[i-1][0]+stair[i];
        }
        System.out.println(Math.max(Dy[N][0],Dy[N][1]));
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