import java.util.Scanner;

public class Main{
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;
    static Scanner sc = new Scanner(System.in);
    
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M];
    }
    static void func(int k){
        if(k == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i=1; i<=N;i++){
                selected[k] = i;
                func(k+1);
                selected[k] = 0;
            }
        }

    }
    public static void main(String[] args) {
        input();
        func(0);
        System.out.println(sb);
    }
    
}