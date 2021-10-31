import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static int[] selected;

    static void input(){
        N = Integer.parseInt(sc.next());
        M = Integer.parseInt(sc.next());
    }

    static void rec_func(int k){
        if(k == M+1){
            for(int i=0; i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else{
            for(int cand = 1; cand<=N; cand++){
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