package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//중복YES 순서YES CASE1 <<1번
//중복NO 순서YES CASE2
//중복Yes 순서NO CASE3
//중복NO 순서NO CASE4

public class NM_15651 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] selected;

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            selected = new int[M+1];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void rec_func(int k){
        if(k==M+1){
            for(int i=1; i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            for(int cand=1; cand<=N; cand++){
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());

    }
}
