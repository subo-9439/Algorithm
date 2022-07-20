package al_22_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Boj 2875 브론즈3 그리디
public class Boj_대회or인턴 {
    static FastReader scan = new FastReader();
    static int N,M,K;

    static void input(){

        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

    }
    static void pro(){
        //나머지가 있는가
        while (K-- > 0){
            int girl = N / 2;
            int boy = M / 1;

            if(girl >= boy){
                N--;
            }else {
                M--;
            }

        }
        System.out.println(Math.min(N/2,M));
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
