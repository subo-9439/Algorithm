import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] selected;
    
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];
    }
    static void pro(int k){
        if(k == M+1){
            for(int i=1; i<=M; i++)sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            for(int i=selected[k-1]; i<=N; i++){
                if(i == 0) i = 1;
                selected[k] = i;
                pro(k+1);
                selected[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
        input();
        pro(1);
        System.out.println(sb);
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