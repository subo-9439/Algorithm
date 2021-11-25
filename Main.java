import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static FastReader sc = new FastReader();
    static int N, cnt;
    static int[] col;

    static void input(){
        N = sc.nextInt();
        col = new int[N+1];
    }
    static boolean attackable(int r1, int c1, int r2, int c2){
        if(c1 == c2) return true;
        if(r1-c1 == r2-c2) return true;
        if(r1+c1 == r2+c2) return true;
        return false;

    }
    static void rec_func(int row){
        if(row == N+1){
            cnt++;
        }else{
            for(int c=1; c<=N;c++){
                boolean possible = true;
                for(int r1 = 1;r1<=row-1; r1++){
                    if(attackable(r1,col[r1] , row, c)){
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    col[row] = c;
                    rec_func(row+1);
                    col[row] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(cnt);
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
    }
}