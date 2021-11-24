import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] col;
    static int ans;
    static int N;
    static boolean attackable(int r1,int c1, int r2, int c2){
        if(c1 == c2) return true;
        if(r1-c1 == r2 - c2) return true;
        if(r1+c1 == r2 + c2) return true;

        return false;
    }
    static void rec_cur(int row){
        if(row == N+1){
            ans++;
        }else{
            for(int c=1; c<=N; c++){
                for(int r = 1; r<N; r++){
                    if(!attackable(row, c, r, col[r])){
                        col[c] = c;
                        rec_cur(row+1);
                        col[c] = 0;
                    }

                }

            }
    }
    
    public static void main(String[] args) {
        N = sc.nextInt();
        col = new int[N+1];
        rec_cur(1);    
        System.out.println(ans);
    }
}